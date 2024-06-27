package A2DFS;

import java.util.*;

public class D3Basic3 {
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};
        graph = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] a : arr) {
            graph.get(a[0]).add(a[1]);
        }

        List<List<Integer>> graph1 = new ArrayList<>();
        List<Integer> graph2 = new ArrayList<>();
        graph2.add(1);
        dfs(graph1, graph2, 1);

        for (List<Integer> path : graph1) {
            System.out.println(path);
        }
    }

    static void dfs(List<List<Integer>> graph1, List<Integer> graph2, int node) {
        if (graph.get(node).isEmpty()) {
            graph1.add(new ArrayList<>(graph2));
            return;
        }

        for (int target : graph.get(node)) {
            graph2.add(target);
            dfs(graph1, graph2, target);
            graph2.remove(graph2.size() - 1);
        }
    }
}
