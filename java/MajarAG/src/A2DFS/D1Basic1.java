package A2DFS;

import java.util.*;

public class D1Basic1 {
    static List<List<Integer>> adjList; // 자료형 수정
    static boolean[] visited;

    public static void main(String[] args) {
        // 방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것을 먼저 방문하는 DFS 알고리즘 형식의 방문순서 출력
        int[][] arr = {{0,1},{0,2},{1,3},{2,3},{2,4}};

        adjList = new ArrayList<>();
        visited = new boolean[5];

        // 인접 리스트 초기화
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선 추가 (양방향)
        for (int[] a : arr) {
            adjList.get(a[0]).add(a[1]);
//            adjList.get(a[1]).add(a[0]); // 양방향일 경우
        }

        // 정점의 인접 리스트를 정렬 (정점 번호가 작은 것을 먼저 방문하기 위해)
        for (List<Integer> neighbors : adjList) {
            Collections.sort(neighbors);
        }

        // DFS 시작 (예: 정점 0부터 탐색 시작)
        dfs(0);
    }

    // DFS 함수
    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int target : adjList.get(v)) {
            if (!visited[target]) {
                dfs(target);
            }
        }
    }
}
