package Test;

import java.io.*;
import java.util.*;

public class 아기상어2_17086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

 /*
5 4
0 0 1 0
0 0 0 0
1 0 0 0
0 0 0 0
0 0 0 1
 */
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 1) {
                    queue.offer(new int[]{i, j});  // 상어가 있는 위치를 큐에 추가  (0, 2), (2, 0), (4, 3)
                }
            }
        }
        System.out.println( bfs(maze, queue, n, m));

    }

    public static int bfs(int[][] maze, Queue<int[]> queue, int n, int m) {
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        int distance = 0;

        while (!queue.isEmpty()) {
            // 상어 위치 (0, 2) -> 8방향 이동
            int[] temp = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 0) { //  범위 내에 O, 아직 방문하지 X 빈 칸인 경우 검사
                    queue.offer(new int[]{nx, ny});
                    maze[nx][ny] = maze[temp[0]][temp[1]] + 1;  // 새로운 좌표의 거리를 현재 좌표의 거리 +1로
                    if (maze[nx][ny] > distance) {
                        distance = maze[nx][ny];
                    }
                }
            }
        }

        // 탐색 과정에서 시작점이 1로 설정되기 때문에 실제 거리를 구하기 위해 -1 (초기 상어의 위치가 1로 설정)
        return distance - 1;
    }
}



