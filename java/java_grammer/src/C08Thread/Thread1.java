package C08Thread;

// Thread class에는 run메서드가 있는데 빈거임
// 실행시 작업하고자 하는 내용을 run() 메ㅔ서드를 overriding 통해 구현
// 상속 관계이기 때문에 다중 상속 불가 : runnable과의 차이
public class Thread1 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread1 실행 시작");
    }


}
