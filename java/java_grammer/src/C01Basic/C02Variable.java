package C01Basic;

import java.math.BigDecimal;
import java.util.Scanner;

public class C02Variable {
    public static void main(String[] args) {
//        java 변수타입 : 기본형, 참조형으로 구분
        byte a = 127;
        byte b =-128;
        a++;
        System.out.println(a); //-128 (오버/언더플로우 발생)

        int int_a = 10;
        long long_a = 10L;   // long은 명시적으로 타입 명시

//        부동 소수점 오차 테스트
        double double_a = 0.1;
        System.out.println(double_a);

        double total = 0;
        for(int i =0; i<1000; i++){
            total += 0.1;     // *10으로 소수점 오차 연산을 피할 수 있음
        }
        System.out.println(total);     // 99.9999999999986

//        BigDecimal의 원리는 저장할 떄 문자열로 저장해서 연산할때 정수로 변환,
//        최종결과는 실수로 반환 (정확한 소수 계산 시 이거 사용)

        double d1 = 1.03;
        double d2 = 0.42;
        System.out.println("double 계산 : " + (d1-d2));
        BigDecimal b1 = new BigDecimal("1.03");
        BigDecimal b2 = new BigDecimal("0.42");
        double re = b1.subtract(b2).doubleValue();
        System.out.println("BigDecimal 계산 : " + re);

//        문자형 : char
        char m1 = '가';

//        boolean : T/F
        boolean bool1 = true;
        boolean bool2 = false;

        Scanner sc = new Scanner(System.in);
        int in_a = sc.nextInt();
        boolean bool3 = in_a >0;
        if(bool3){
            System.out.println("참");
        }

//        타입변환
//        System.out.println('a'>'b');   알파벳 비교를 위해 묵시적 타입변환 발생
        System.out.println((int)'b');   //명시적

        int i1 = 10;
        double i2 = i1;  //int -> diuble 문제 없음
        
        double i3 = 10.4;
        int i4 = (int)i3;     // 묵시적 형변환은 불가능. 명시적은 가능

//        상수는 초기화 이후에 값이 재활용되는것이 불가능
        int q = 1;
        q = 10;
//        상수는 final keyword 통해 표현 (재할당 불가능)
//        일반적으로 상수값은 대문자로 표기
        final int q1= 10;


    }
}
