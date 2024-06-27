package A4Greedy;

public class G2체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};

    }
        public int solution(int n, int[] lost, int[] reserve) {
            int[] students = new int[n];

            for (int l : lost) {
                students[l - 1]--;
            }

            for (int r : reserve) {
                students[r - 1]++;
            }

            for (int i = 0; i < n; i++) {
                if (students[i] < 0) {
                    if (i > 0 && students[i - 1] > 0) {
                        students[i]++;
                        students[i - 1]--;
                    } else if (i < n - 1 && students[i + 1] > 0) {
                        students[i]++;
                        students[i + 1]--;
                    }
                }
            }

            int answer = 0;
            for (int student : students) {
                if (student >= 0) {
                    answer++;
                }
            }

            return answer;
        }
    }

