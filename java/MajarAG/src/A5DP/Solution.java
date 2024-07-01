package A5DP;

import java.io.*;
import java.util.*;

// 38%까지 감
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 0; i--) {
            int init = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    init = arr[j];
                    break;
                } else if (result[j] > arr[i]) {
                    init = result[j];
                    break;
                }
            }
            result[i] = init;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());

        for( int i : result){
            System.out.println(i + " ");
        }



    }
}
