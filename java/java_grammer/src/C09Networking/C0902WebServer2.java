package C09Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C0902WebServer2 {
    // checked exception임
    public static void main(String[] args) throws IOException {
        // socket이란 서버-사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("8081서비스 시작");
        while (true){
            // accept : client의 연결 요청 수락
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine())!=null && !line.isEmpty()){
                sb.append(line + "\n");
            }

            String requestString = sb.toString();
//            System.out.println(requestString);

            String firstLine = requestString.split("\n")[0];
            String info = firstLine.split(" ")[1];  //GET이 0번째
            String id="";
            //?를 기준으로 split하면서..
            if(info.contains("?")){
                String st1 = info.split("\\?")[1];
                String[] stArr = st1.split("&");
                for(String s : stArr){
                    String[] keyValue = s.split("=");
                    if(keyValue[0].equals("id")){
                        id = keyValue[1];
                    }
                }
            }

            System.out.println(info);
            // 기본적으로 문자열
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "hi~ hello" + id;

            // utf-8문자열 return
            socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
            //플러시랑 일반적으로 변경사항을 확적(반영)하는 것을 의미
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}