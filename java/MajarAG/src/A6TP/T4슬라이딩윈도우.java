package A6TP;

public class T4슬라이딩윈도우 {
    public static void main(String[] args) {
        // 정수 배열 nums와 정수 k가 주어졌을때
        // 길이가 k인 연속된 부분 배열의 최대합 구하기
        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int sum = max;
        for (int i=k; i<nums.length; i++) {
            sum += nums[i]-nums[i-k]; // 슬라이딩 윈도우
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
