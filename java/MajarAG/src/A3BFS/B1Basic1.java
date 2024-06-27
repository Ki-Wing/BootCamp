package A3BFS;

import java.util.*;

public class B1Basic1 {
        static List<List<Integer>> adjList = new ArrayList<>();
        static boolean[] visited;
        public static void main(String[] args) {
            int[][] input = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4},
            };
            visited = new boolean[input.length];
            for(int i = 0; i<input.length; i++){
                adjList.add(new ArrayList<>());
            }
            for (int[] a : input ){
                addEdge(a[0],a[1]);
            }
            bfs(0);
        }
        static void addEdge(int a , int b){
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        static void bfs(int start){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            while (!queue.isEmpty()){
                int temp = queue.poll();
                System.out.println(temp);
                
                for(int target : adjList.get(temp)){
                    // target을 q에 add하기 전에 target을 true로 셋팅
                    if(!visited[target]){
                        visited[target] = true;
                        queue.add(target);
                    }
                }
            }
        }
    }