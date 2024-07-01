package Test;

import java.io.*;
import java.util.*;

public class 애너그램_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static Set<String> mySet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        int totalLength = 0;

        // 전체 문자 배열의 길이 계산
        for (String s : str) {
            totalLength += s.length();
        }

        char[] chars = new char[totalLength];
        int index = 0;

        // 각 문자열을 chars 배열에 복사
        for (String s : str) {
            for (char c : s.toCharArray()) {
                chars[index++] = c;
            }
        }
        System.out.println(Arrays.toString(chars));

//        visited = new boolean[chars.length];

        dfs(chars, chars.length);
        System.out.println(sb.toString());
    }

    private static StringBuilder dfs(char[] chars, int line) {
        if (mySet.size() == line){
            sb.append(mySet);
            return sb;
        }
        for(int i=0; i<line; i++){
            if(visited[i]) continue;
            if(!visited[i]){
                visited[i] = true;
                mySet.add(String.valueOf(chars[i]));
                dfs(chars, line);
                visited[i] = false;
            }
        }
        return null;
    }

}