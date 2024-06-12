package C01Basic;

import java.util.*;
import java.io.*;

public class C04IfStatements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.print("문자 입력 : ");
//        char ch = scanner.next().charAt(0);
//
//        if (Character.isLowerCase(ch)) {
//            System.out.println(ch + " 소문자입니다.");
//        } else if (Character.isUpperCase(ch)) {
//            System.out.println(ch + " 대문자입니다.");
//        } else {
//            System.out.println(input + " 문자가 아닙니다. ");
//        }



//        [교통 수단 추천]
//        택시 : 10000, 버스 : 3000, 킥보드 : 2000
//        사용자에게 얼마 있는지 물어보고 구간별로 교통수단 추천

//        System.out.print("현재 보유 금액 : ");
//        int money = sc.nextInt();
//
//        if (money >= 10000) {
//            System.out.println("택시 추천.");
//        } else if (money >= 3000) {
//            System.out.println("버스 추천");
//        } else if (money >= 2000) {
//            System.out.println("킥보드 추천");
//        } else {
//            System.out.println("교통수단을 이용할 수 없습니다.");
//        }



//        [상향연산자] : 결과값 = 조건식 ? 반환값1 : 반환값2
//        int answer = 1234;
//        System.out.print("비번 입력:");
//        int ip = sc.nextInt();
//
//        String re = (answer==ip? "문이 열립니다.":"비밀번호가 틀렸습니다");
//        System.out.println(re);



//        switch문 : if else if등 조건문 가독성 있게
        System.out.print("비번 입력:");
        int ip = sc.nextInt();

        switch (ip) {
            case 1:
                System.out.println("대출 업무입니다.");
                break;
            case 2:
                System.out.println("예금 업무입니다.");
                break;
            case 3:
                System.out.println("적금 업무입니다.");
                break;
            case 0:
                System.out.println("상담사를 연결합니다.");
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
                break;
        }

        sc.close();
    }
}
