package C01Basic;

import java.util.*;
import java.io.*;

public class C05LoopStatements {
    public static void main(String[] args) {
// 조건문(2~10까지 출력)
//        int a = 2;
//        while(a<=10){
//            System.out.println(a);
//            ++a;


//구구단
        Scanner sc = new Scanner(System.in);
//    System.out.print("숫자 : ");
//    int number = sc.nextInt();
//
//    for (int i = 1; i <= 9; i++) {
//        System.out.println(number + " X " + i + " = " + (number * i));
//    }
//
//    sc.close();


//        String answer = "1234";
//        String ip;
//        int cnt = 0;
//        while (true) {
//            System.out.print("비번 입력: ");
//            ip = sc.next();
//
//            if (answer.equals(ip)) {
//                System.out.println("문이 열립니다.");
//                break;
//            } else {
//                ++cnt;
//                System.out.println("비번이 틀렸습니다. (" + cnt + "/5)");
//
//                if (cnt >= 5){
//                    System.out.println("입력 횟수를 초과했습니다.");
//                    break;
//                }
//            }
//
//        }


// result에 숫자 num을 반대로 뒤집은 숫자값을 넣기
// 나머지 활용!!!!!!
//        int num=1234;
//        int result=0;
//
//        while (num!= 0) {
//            result = result*10 + num%10;
//            num /=10;
//        }
//        System.out.println("num 뒤집 결과 : " + result);

//do - while문
//        int a = 1;
//        do{
//            System.out.println(a);
//            a++;
//        }while(a<11);


//홀수 출력하기
//    for (int i = 1; i <= 10; i++) {
//        if(i%2!=0){
//            System.out.println(i);
//        }
//    }


//        짝수 더한값
//        int sum =0;
//        for (int i = 1; i <= 20; i++) {
//            if(i%2==0){
//                sum+=i;
//            }
//        }
//        System.out.println(sum);


//        최대공약수 구하기
//        int a = 24;
//        int b = 36;
//        int ex = 1;
//        int min = Math.min(a, b);
////        int min = a>b? a:b;  - 방법1
//
//        for (int i = 1; i <= min; i++) {
//            if (a%i==0 && b%i==0) {
//                ex=i;
//            }
//        }
//        System.out.println("최대공약수: " + ex);
//        }
//    }


//소수 구하기
//        int number = sc.nextInt();
//        boolean isPrime = true;
//        if (number <= 1) {
//            isPrime = false;
//        } else {
//            for (int i = 2; i <= Math.sqrt(number); i++) {
//                if (number % i == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//        }
//        if(isPrime){
//            System.out.println("소수O");
//        }else{
//            System.out.println("소수X");
//        }


//홀수(1~10) 출력하기
//    for (int i = 1; i <= 10; i++) {
//        if(i%2!=0){
//            System.out.println(i);
//            continue;
//        }
//    }


//배열과 enhanced for문(향상된 for문 - for each문)
//    int[] arr = {1, 3, 5, 7, 9};
// arr[i] 는 실제 원본 배열 안을 가리키는거임


//일반 for문을 통한 arr값 변경 후 출력
//        System.out.println(Arrays.toString(arr));

//향상된 for문을 통한 arr값 변경 후 출력
//        향상된 for문으로는 실제 arr값의 변경은 불가능
//    for (int num: arr){
//        System.out.println(num);


//    자바 변수의 유효번위 : ()
//    int num = 10;
//    if(num > 1){
//        int abc=20;
//        num=20;
//    }
//
//        System.out.println(num);
//        System.out.println(abc);    내부적으로 선언한 abc이기 때문에 유효범위에 인지



//    구구단 만들기-2
//    for (int i = 1; i <= 9; i++) {
//        System.out.println(i + "단 입니다.");
//        for (int j = 1; j <= 9; j++) {
//            System.out.println(i + " X " + j + " = " + (j * i));
//        }
//    }


//라벨문
//        loop1:
//        for (int i = 0; i<5; i++){
//            loo2:
//            for (int j = 0; j<5; j++){
//                System.out.println("hello world");
//                if( j == 2){
//                    break loop1;
//                }
//            }


//        라벨문 활용헤서 값 찾기
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int targert = 11;
        loop1:
        for (int i = 0; i<matrix.length; i++){
            loop2:
            for (int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == targert){
                    System.out.println("11을 찾아서 종료합니다. i = " + i + " j = " + j);
                    break loop1;
                }
            }
        }






    }
}