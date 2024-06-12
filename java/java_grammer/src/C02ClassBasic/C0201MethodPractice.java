package C02ClassBasic;

public class C0201MethodPractice {
    public static void main(String[] args) {
        if(isPrime(10)){
            System.out.println("소수O");
        }else{
            System.out.println("소수X");
        }
    }

    // 숫자 값이 소수인지 아닌지 판별하는 메서드 생성
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }

}