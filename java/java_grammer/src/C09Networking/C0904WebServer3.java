package C09Networking;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.sql.*;

public class C0904WebServer3 {
    public static void main(String[] args) throws IOException, SQLException {
        // DB 연결 ㄱㄱ
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String passwd = "1234";
        Connection con = DriverManager.getConnection(url, userName, passwd);

        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("8081 서비스 시작");

        while (true) {
            // 클라이언트 연결 ㄱㄱ
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                sb.append(line).append("\n");
            }

            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String info = firstLine.split(" ")[1];

            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n";

            if (info.contains("?")) {
                String queryString = info.split("\\?")[1];
                Statement st = con.createStatement();
                ResultSet rs = null;

                //localhost:8081?id=2
                if (queryString.contains("id=")) {
                    String id = queryString.split("id=")[1].split("&")[0];
                    String myQuery = "SELECT name, email, passwd FROM Author WHERE id=" + id;
                    rs = st.executeQuery(myQuery);
                //localhost:8081?name=test&email=test@test.com
                } else if (queryString.contains("name=") && queryString.contains("email=")) {
                    String name = queryString.split("name=")[1].split("&")[0];
                    String email = queryString.split("email=")[1].split("&")[0];
                    String myQuery = "SELECT name, email, passwd FROM Author WHERE name='" + name + "' AND email='" + email + "'";
                    rs = st.executeQuery(myQuery);
                }

                if (rs != null && rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("passwd");
                    httpResponse += "name: " + name + "\nemail: " + email + "\npasswd: " + password;
                } else {
                    httpResponse += "Not found";
                }
            }

            // HTTP 응답 전송
            socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}
