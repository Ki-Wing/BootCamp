package A6TP;

import java.util.*;

public class T2연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        List<int[]> ranges = new ArrayList<>();
        int start = 0, sum = 0;

        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];
            while (sum > k && start <= end) {
                sum -= sequence[start++];
            }

            if (sum == k) {
                ranges.add(new int[]{start, end});
            }
        }

        if (ranges.isEmpty()) {
            return new int[0];
        }

        int[] shortestRange = ranges.get(0);
        for (int[] range : ranges) {
            if ((range[1] - range[0]) < (shortestRange[1] - shortestRange[0])) {
                shortestRange = range;
            }
        }

        return shortestRange;
    }

    private static void printResult(int[] result) {
        if (result.length == 0) {
            System.out.println("No subarray found");
        } else {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }
    }

    public static void main(String[] args) {
        T2연속된_부분_수열의_합 solution = new T2연속된_부분_수열의_합();
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] result = solution.solution(sequence, k);
        printResult(result); // 예상 결과: [2, 4]
    }
    }


