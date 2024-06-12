package C02ClassBasic;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class C0202ClassLecture {
    public static void main(String[] args) {
//        System.out.println(MyCalculator.sum(10,20));
//
//        // 누적합
//        MyCalculatorInstance.sumAcc(20);
//        System.out.println(MyCalculatorInstance.total);
//
//        클래스 메서드 호풀 방식 : 클래스.메서드명()
//        MyCalculatorInstance.sumAcc(40);
//        System.out.println(MyCalculatorInstance.total);
//
        //간단 회계 프로그램
            // A부서 매출
//        MyCalculatorInstance A = new MyCalculatorInstance();    //A 객체의 고유 메모리 공간 할당
////       객체 메서드 호출 방식 : 객체명.메서드명()
//        A.sumAcc(10);
//        A.sumAcc(30);
//        System.out.println(A.total);
//
//
//        MyCalculatorInstance B = new MyCalculatorInstance();
//        B.sumAcc(10);
//        B.sumAcc(20);
//        System.out.println(B.total);


        // C0203Person 객체 생성
        C0203Person person1 = new C0203Person();   // 힙 메모리에 person1 자리가 생김.
//        변수값에 직접 접근해 값 할당하는 방식
//        person1.name = "ynlee";    //private을 해서 이렇게 못씀
//        person1.email = "ynlee@google.com";
//        person1.age = 20;
//        person1.lunch();
//
//        일반적인 패턴은 변수값에 직접 접근 X
//        의도를 명확히한 메서드를 통해 변수값을 할당하고 가져옴
//        person1.lunch(); // 이렇게만하면 null
        person1.setName("ynlee");    //이름을 setiing했기 때문에
        System.out.println(person1.getName());
        person1.lunch();
    }

}


class MyCalculatorInstance{
//    static이 o면 class 변수
//    static이 x면 객체 변수
    int total = 0;
    static int test = 1;

    int sum(int a, int b){
        return a+b;
    }

    int sub(int a, int b){
        return a-b;
    }

    // static을 넣으면 객체 변수에 접근을 못하는거임
    void sumAcc(int a){
        // 객체 그 자신을 의미
        this.total+=a;
        // 객체는 class 변수에 접근 가능
        test = a;
    }
}