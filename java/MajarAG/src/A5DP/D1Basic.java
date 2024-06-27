package A5DP;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class D1Basic {
    public static void main(String[] args) {

    // 1, 4, 5 로 13 만들 수 있는 조합 중에 가장 작은 조합
    // 11 9 8 중에 가장 작은 조합을 가진 조합의 개수에 +1
    // Min(f(n-1), f(n-2), ... ) + 1
    int target = 13;
    int[] number = {1,4,5};
    int[] arr = new int[target+1];

    arr[1] = 1;
    for(int i=2; i<=target; i++){
        int min = Integer.MAX_VALUE;
        for(int n : number){
                if(i-n>=0 && min > arr[i-n]){  //4부터는 1로 가야하는데..
                    min = arr[i-n];
                }
        }
        arr[i] = min+1;
    }
    System.out.println(Arrays.toString(arr));
    }

}

