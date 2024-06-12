package C02ClassBasic;

public class C0201Method {
    public static void main(String[] args) {
//        for문 1~10 total
//        클래스명.메서드 : 기본방식 (같은 클래스내에서 클래스메서드 호출은 명 생략 가능)
        System.out.println(C0201Method.totalSum(10,30));
        System.out.println(totalSum(10,20));

    }

    public static int totalSum(int start, int end){
//        코드의 중복이 발생하므로 반복을 피하기 위해 위 기능을 분리
        // 매개변수 값을 int 2개로 정의
        // 메서드 구성요소 : 매개변수, 리턴타입, 접근제어자(public), 클래스메서드여부(static) 없느면 객체 메서드임
        
        int total = 0;
        for (int i = start; i <= end; i++){
            total += i;
        }
        return total;
    }





}
