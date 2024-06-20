package C08Thread;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args)  {
        // 쓰레드 생성 방법 : 1.스레드 상속방식
//        Thread t1 = new Thread1();
//            //start 메서드가 상속되어 있고, 이 메서드를 통해 run메서드 실행
//        t1.start();
//        Thread t2 = new Thread1();
//        t2.start();
//
//        // 2. runnable 구현한 객체를 Thread클래스에 주입하는 방식
//        Thread t3 = new Thread(new Thread2());
//        t3.start();
//        new Thread(new Thread2()).start();
//        // 익명 class를 만들어서 익명 객체에 넣음
//        new Thread(()-> System.out.println("익명 Runnable 객체 주입 후 Thread 실행")).start();


//        Theard 동시성 이슈 테스트 -> 도서관(200권) : 단일 스레드

        for(int i =0; i<1000;i++){
            Thread th = new Thread(() -> Library.borrow());
            th.start();

//            동시성 이슈 해결방법 첫번째. join() 메서드 사용
//            join() : 다른 스레드의 완료전까지 새로운 스레드가 실행되지 않음
//            th.join();


        }
        System.out.println("최종적으로 1541은 수량" + Library.bookcnt);

    }

}
