package C08Thread;

public class Library {
    static int bookcnt = 100;
    // synchronized 키워드를 통해서 해당 메서드에 한해서 lock 걸도록 설정
    public synchronized static void borrow()  {
        if(bookcnt>0){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            bookcnt -= 1;
            System.out.println("대출완료");
            System.out.println("남아있는 책 수량 :  " + bookcnt);

        }else{
            System.out.println("남아있는 책이 없습니다.");
        }
    }
}
