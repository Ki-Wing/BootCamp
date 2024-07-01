package A6TP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1Basic {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
        int target = 10;
//
//        List<int[]> result1 = Method1(nums, target);
//        printResult(result1);
//
//        List<int[]> result2 = Method2(nums, target);
//        printResult(result2);
//
//        List<int[]> result3 = Method3(nums, target);
//        printResult(result3);

        List<int[]> result = Method2_1(nums, target);
        for (int[] range : result) {
            System.out.println("[" + range[0] + ", " + range[1] + "]");
        }

        int start = 0, end=0;
        int sum = nums[0];
        List<int[]> pairs = new ArrayList<>();

        while(start <= end&& end < nums.length -1){
            if(sum == target){
                pairs.add(new int[]{start,end});
                sum-=nums[start];
                start++;
            }else if(sum < target && end < nums.length-1){
                end++;
                sum += nums[end];
            }else{
                sum-=nums[start];
                start++;
            }
        }



    }

    /**
     * Method1: 이중 for문을 사용해서 두 수의 합이 target이 되는 쌍의 인덱스를 찾음
     */
//    public static List<int[]> Method1(int[] nums, int target) {
//        List<int[]> pairs = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    pairs.add(new int[]{i, j});
//                }
//            }
//        }
//        return pairs;
//    }

    /**
     * Method2: 투 포인터를 사용해서 정렬된 배열 속 두 수의 합이 target이 되는 쌍의 인덱스 찾기
     */
    public static List<int[]> Method2(int[] nums, int target) {
        List<int[]> pairs = new ArrayList<>();
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int left = 0;
        int right = sortedNums.length - 1;

        while (left < right) {
            int sum = sortedNums[left] + sortedNums[right];
            if (sum == target) {
                pairs.add(new int[]{findIndex(nums, sortedNums[left]), findIndex(nums, sortedNums[right])});
                int[] arr = new int[]{0,0};
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }
    private static int findIndex(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }

        /**
         * 투 포인터를 사용하여 부분 배열의 합이 target이 되는 구간의 시작과 끝 인덱스를 찾는다.
         */
    public static List<int[]> Method2_1(int[] nums, int target) {
        List<int[]> ranges = Method2_1(nums, target);

        int start=0, sum=0;

        for (int end=0; end<nums.length; end++) {
            sum += nums[end];

            while (sum>target && start<=end) {
                sum -= nums[start++];
            }

            if (sum==target) {
                ranges.add(new int[]{start, end});
            }
        }

        return ranges;
    }





    /**
     * Method3: 버킷을 사용해 두 수의 쌍이 target이 되는 인덱스를 찾음
     */
//    public static List<int[]> Method3(int[] nums, int target) {
//        List<int[]> pairs = new ArrayList<>();
//        int max = Arrays.stream(nums).max().getAsInt();
//        int[] bucket = new int[max + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (complement >= 0 && complement <= max && bucket[complement] > 0) {
//                pairs.add(new int[]{i, indexOf(nums, complement, i)});
//                bucket[complement]--;
//            } else {
//                bucket[nums[i]]++;
//            }
//        }
//        return pairs;
//    }
//
//    private static int indexOf(int[] nums, int value, int excludeIndex) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == value && i != excludeIndex) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    private static void printResult(List<int[]> result) {
//        for (int[] pair : result) {
//            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
//        }
//    }
}
