package Test;

import java.io.*;
import java.util.*;

public class 애너그램_6443 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static Set<String> mySet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for (String s : str) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            visited = new boolean[chars.length];
            mySet.clear();
            dfs(chars, new StringBuilder(), visited);

            for (String anagram : mySet) {
                sb.append(anagram).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static void dfs(char[] chars, StringBuilder sb, boolean[] visited) {
        if (sb.length() == chars.length) {
            mySet.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;


            if (i > 0 && chars[i] == chars[i-1] && !visited[i-1]) continue;


            visited[i] = true;
            sb.append(chars[i]);
            dfs(chars, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
