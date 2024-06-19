package C07ExceptionFileParsing;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class C0702FileParsing {
    public static void main(String[] args) throws IOException {
        // io 패키지 사용
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        // String input = br1.readLine(); // 한 줄 읽기
        // System.out.println(input);

//        // 파일에서 읽기 (파일 경로 넣기)
//        try (BufferedReader br2 = new BufferedReader(new FileReader("src/C07ExceptionFileParsing/test_file.txt"))) {
//            String line;
//            while ((line = br2.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//
//        // NIO 패키지를 사용한 파일 처리
//        Path filePath = Paths.get("src/C07ExceptionFileParsing/test_file.txt");
//try{
//        // 문자열 통째로 read
//        String st1 = Files.readString(filePath);
//        System.out.println(st1);
//
//        // 문자열 각 라인을 list 형태로 read
//        List<String> st2 = Files.readAllLines(filePath);
//        for (String line : st2) {
//            System.out.println(line);
//        }
//    }catch(IOException e){
//        e.printStackTrace();
//    }


//      파일 쓰기- append(쓰기), write(덮어쓰기)
//       create_new (생성)
        Path filePath = Paths.get("src/C07ExceptionFileParsing/test_file.txt");

        if(Files.exists(filePath)){
            Files.write(filePath, "김아무개\n".getBytes(), StandardOpenOption.APPEND);
        }else{
            Files.write(filePath, "".getBytes(), StandardOpenOption.CREATE_NEW);
        }









    }


}
