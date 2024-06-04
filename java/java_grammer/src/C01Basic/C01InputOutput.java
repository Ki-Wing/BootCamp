package C01Basic;

import java.util.Scanner;

public class C01InputOutput {
    public static void main(String[] args) {
//        출력은 : System.out
        int a = 20;     // 20이라는 값을 a 변수에 담겠다
        System.out.print(a);    // 출력 후 줄바꿈 X
        System.out.println(a);  // 출력 후 줄바꿈 O

//        문자열 + 숫자 = 문자열
        String st = "10";
        System.out.println(a+st);

//        숫자 + 숫자 = 숫자
        int b = 40;
        System.out.println(a+b);


//         입력은 : Systme.in (키보드 입력)
        Scanner sc = new Scanner(System.in);    //(매개변수)
//         nextLine은 입력 받은 데이터를 한 줄 읽어서 String으로 리턴
        System.out.println("문자 : ");
        String abc = sc.nextLine();

        System.out.println("정수 : ");
        int ab = sc.nextInt();

        System.out.println("실수 : ");
        double abcd = sc.nextDouble();

        System.out.println("논리값 : ");
        boolean abcde = sc.nextBoolean();

        System.out.println(abc + ab + abcd);

        sc.close();         // 입출력 sys 메모리 해제 (java 밖의 sys이기 때문)

    }
}