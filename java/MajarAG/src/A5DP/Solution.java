package A5DP;

public class Solution {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m, n, puddles));
    }
    public static int solution(int m, int n, int[][] puddles) {
        int[][] maze = new int[n][m];

        for (int[] p : puddles) {
            maze[p[1]-1][p[0]-1] = -1;
        }

        maze[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == -1) {
                    maze[i][j] = 0;
                    continue;
                }
                if (i > 0) maze[i][j] += maze[i-1][j];
                if (j > 0) maze[i][j] += maze[i][j-1];
                maze[i][j] %= 1000000007;
            }
        }
        return maze[n-1][m-1];
    }
}
