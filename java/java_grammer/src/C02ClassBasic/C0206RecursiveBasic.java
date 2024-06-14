package C02ClassBasic;

public class C0206RecursiveBasic {
    public static void main(String[] args) {
//        for문으로 1~10 누적 합계
        int sum =0;
        for(int i =1;i<=10;i++){
            sum+= i;
        }
        System.out.println(sum);
        System.out.println(sumValue(10));

        //피보나치 수열
        int first =1, second = 1, num=5;
        for(int i = 2;i<num;i++){
            int tmp = first;
            first = second;
            second = tmp+first;
        }
        System.out.println(second);
        System.out.println(fibonacci(5));

    }

    static int fibonacci(int n) {
            if (n <= 2) {
                return 1;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }   // 비효율적


    static int sumValue(int n){
        if(n==1){
            return 1;
        }
        return n + sumValue(n-1);
    }


}
