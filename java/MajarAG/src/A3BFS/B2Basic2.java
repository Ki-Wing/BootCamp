package A3BFS;

import java.util.*;

public class B2Basic2 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        int[][] input = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int numNodes = 5; // 노드의 수를 명시적으로 정의

        visited = new boolean[numNodes];
        distance = new int[numNodes];
        Arrays.fill(distance, -1); // 초기값 -1로 설정 (방문되지 않은 노드)

        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : input) {
            addEdge(a[0], a[1]);
        }
        bfs(0);

        System.out.println("노드 거리 배열: " + Arrays.toString(distance));
    }

    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println("현재 노드: " + temp);

            for (int target : adjList.get(temp)) {
                if (!visited[target]) {
                    visited[target] = true;
                    queue.add(target);
                    distance[target] = distance[temp] + 1; // 이전 노드 거리 + 1
                }
            }
        }
    }
}
