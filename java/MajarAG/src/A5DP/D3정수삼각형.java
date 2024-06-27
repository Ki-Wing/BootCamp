package A5DP;

public class D3정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int maxSum = 0;
        for (int j = 0; j < dp[n-1].length; j++) {
            if (dp[n-1][j] > maxSum) {
                maxSum = dp[n-1][j];
            }
        }

        return maxSum;
    }
}
