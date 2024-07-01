package Test;

// 시간초과(이중 for문 앞에서부터 비교)
// 22% (뒤에서 부터 비교)
// 38% (stringTokenizer 사용)
// 68% (result 초기 setting을 마지막만 설정, stringBuilder 사용)
// 69% (람다식 사용)
// 100%!!! 스택 구현

import java.io.*;
import java.util.*;

public class 오큰수_17287 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        int[] arr2 = new int[N];
        int top = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            while (top >= 0 && arr[arr2[top]] < arr[i]) {
                result[arr2[top--]] = arr[i];
            }
            arr2[++top] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}
