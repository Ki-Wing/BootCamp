package A7이분탐색;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B1Basic {
    public static void main(String[] args) {
//        이분탐색 사전에 오름차순 정렬이 되어 있어야 가능한 알고리즘
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        int target = 17;

        int start = 0;
        int end = arr.length -1;
        Arrays.sort(arr);

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                System.out.println(mid);
                break;
            }

            if(arr[mid] < target){
                ;start = mid +1;
            }else{
                end = mid-1;
            }
        }

//        이렇게 하면 끝이긴 함
//        System.out.println(Arrays.binarySearch(arr, 17));
    }
}
