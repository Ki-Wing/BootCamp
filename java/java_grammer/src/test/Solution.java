package test;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>();
        int result[] = new int[score.length];

        for(int i=0;i<score.length; i++){
            pq.add(score[i]);
            if (pq.size() > k){
                pq.poll();
            }
            result[i] = pq.peek();
            }

        }
        return result;
}
