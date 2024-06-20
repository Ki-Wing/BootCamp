package C09Networking;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class C0901WebServer1 {
                // checked exception임
    public static void main(String[] args) throws IOException {
        // socket이란 서버-사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("[8081]service start");
        while(true){
            // accept : client의 연결 요청 수락
            Socket socket = serverSocket.accept();
            // 기본적으로 문자열
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "hello world";
            // utf-8문자열 return
            socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
            //플러시랑 일반적으로 변경사항을 확적(반영)하는 것을 의미
            socket.getOutputStream().flush();
            socket.close();
        }




    }

}
