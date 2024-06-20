package C09Networking;

import java.sql.*;

public class C0903DatabaseConnected {
        //getConnection 얘도 checked Exception 나옴
    public static void main(String[] args) throws SQLException {
        //mysql driver 필요
        //useSSL = false : 보안처리 안하겠다
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String passwd = "1234";

        Connection con = DriverManager.getConnection(url, userName, passwd);

        System.out.println("DB 연결 성공");

        //statement : query 담아 db로 전달하는 객체
        Statement st = con.createStatement();
        String myQuery = "SELECT * FROM post";
        ResultSet rs = st.executeQuery(myQuery);

        int id = 0;
        String title = "";
        while(rs.next()){
            id = rs.getInt("id");
            title = rs.getString("title");
            System.out.println("id는 " + id + "title은 " + title);
        }



    }
}
