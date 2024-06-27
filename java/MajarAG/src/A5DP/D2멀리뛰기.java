package A5DP;

public class D2멀리뛰기 {
    public static void main(String[] args) {
        // 기억하기 방식
        int n = 4;
        System.out.println("결과: " + solution(n));
    }
    public static long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] )%1234567;
        }

        return dp[n];
    }
}
