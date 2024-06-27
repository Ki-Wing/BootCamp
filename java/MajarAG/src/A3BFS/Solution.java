package A3BFS;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int[] p : puddles) {
            maze[p[1]-1][p[0]-1] = -1;
        }

        maze[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i=0; i<2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] != -1) {
                    if (!visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                    maze[nx][ny] += maze[x][y];
                    maze[nx][ny] %= 1000000007;
                }
            }
        }
        return maze[n-1][m-1];
    }
}
