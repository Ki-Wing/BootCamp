package C07ExceptionFileParsing;

import java.sql.*;
import java.util.*;

public class C0701Exception {
    public static void main(String[] args) throws SQLException {
        System.out.println("나눗셈 프로그램입니다.");
        Scanner sc = new Scanner(System.in);

//        예외 발생할 것으로 예상되는 코드에 try로 감싸고
//                예외 발생시 대응하는 코드 catch에 작성 // 중료
//        try{
//            System.out.println("분자 입력");
//            int head = Integer.parseInt(sc.nextLine());
//
//            System.out.println("분모 입력");
//            int tail = Integer.parseInt(sc.nextLine());
//
//            double result = head/tail;
//            System.out.println("나눈 값은 : " + result);

//            예외는 catch 구문 순차적으로 검사
//        }catch(ArithmeticException e){
//            System.out.println("[0 value error]");
//            e.printStackTrace(); // 예외 발생 내역 로그 남기기 위함(sys 차원)
//        }catch(NumberFormatException e){
//            System.out.println("[숫자에 맞는 값을 입력하시오.]");
//            System.out.println(e.getMessage());
////            Exception은 모든 예외의 조상클래스
//        }catch (Exception e){
//            System.out.println("예외 발생");
//
//        }finally {
//            System.out.println("무조건 실행되는 구문");
//        }
//        System.out.println("감사합니다.");


//        throws : 예외처리 위임을 명시
//        login("1234");
        login2("1234");


    }

    //unchecked 예외에서는 throws키워드가 예외사항을 명시하는 용도로만 사용
    //IllegalArgumentException이 runtimeexception에 포함
    static void login(String passwd) throws IllegalArgumentException {

        if (passwd.length() < 10) {
//            throw new : 예외를 강제로 발생
//            예외는 기본적으로 메서드를 호출한 쪽에 전파
//            unchecked 예외는 예외처리가 강제되지 않음
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
        if(passwd.contains("*")){
            throw new RuntimeException();
        }
    }

    static void login2(String passwd) throws SQLException {

//        방법1 : 직접 예외처리
//        try {
//            if (passwd.length() < 10) {
//                throw new SQLException("DB 조회 시 에러가 발생했습니다.");
//            }
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//        방법2: 메서드 호출한 쪽에 위임 : throws
        if (passwd.length() < 10) {
            throw new SQLException("DB 조회 시 에러가 발생했습니다.");
//

        }

    }
}
