package A7이분탐색;

import java.util.*;
//
public class B3입국심사 {
    public static void main(String[] args) {
//        B3입국심사 solution = new B3입국심사();
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times){
        long start = 1;
        Arrays.sort(times);
        long end = times[times.length-1]*n;
        long answer = end;

        while(start <= end){
            int p = 0;
            long mid = (start + end) / 2;

            for(int t : times){
                p += mid/t;
            }
            if(p >= n){
                answer=mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return answer;
    }
}

