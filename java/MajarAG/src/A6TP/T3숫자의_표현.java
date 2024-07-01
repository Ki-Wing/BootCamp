package A6TP;

import java.util.*;

public class T3숫자의_표현 {
    public static void main(String[] args) {
        // n*(n+1)/2
        T3숫자의_표현 solution = new T3숫자의_표현();
        int n = 15;
        System.out.println(solution.solution(n));
    }

    public int solution(int n) {
        int start =1, sum=0;
        int cnt=0;

        for(int end=1; end <=n;end++){
            sum+=end;
            while(sum>n && start <=end){
                sum -=start++;
            }
            if(sum == n){
                cnt++;
            }
        }
        return cnt;
    }

}
