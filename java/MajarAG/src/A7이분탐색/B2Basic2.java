package A7이분탐색;

import java.util.Arrays;

// 원하는 값이 없으면 유사 숫자중 가장 적은 수 반환
public class B2Basic2 {
    public static void main(String[] args) {
        // 이분탐색은 사전에 오름차순 정렬이 되어 있어야 가능한 알고리즘
        int[] arr = {1, 3, 4, 5, 7, 8, 9};
        int target = 6;

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println(mid);
                break;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        System.out.println("value : " + arr[result] + "\t index : " + result);

        // 가까운 값 찾기

        int[] arr2= {10,20,30};
        System.out.println(Arrays.binarySearch(arr2,25));

        int index2 = Arrays.binarySearch(arr, target);
        if(index2 <0){
            System.out.println(Math.abs(index2)-1);
        }else{
            System.out.println(index2);
        }

    }
}

