package C06EtcClass;

public class C0601Math {
    public static void main(String[] args) {
        //static(class) 메서드임
        double randomValue = Math.random(); //0.0~1.0미만 임의의 double형 반환
//        System.out.println(randomValue);

        //로또
        for(int i=0;i<7;i++){
            int number = (int) (Math.random() * 45) + 1;
//            System.out.println(number);
        }

        //절대값 반환
        System.out.println(Math.abs(-4)); // 절대값 반환
        System.out.println(Math.floor(5.7)); // 내림
        System.out.println(Math.ceil(5.7)); // 올림
        System.out.println(Math.round(5.7));  // 반올림
        System.out.println(Math.min(5,8));
        System.out.println(Math.max(5,8));
        //정수 3개 min, max값
        System.out.println(Math.max(5, Math.max(1, Math.max(3, 9))));
        System.out.println(Math.pow(2,5));  // 제곱 연산 수행 a의 b승
        System.out.println(Math.sqrt(25));  // 제곱근 연산 수행




    }
}
