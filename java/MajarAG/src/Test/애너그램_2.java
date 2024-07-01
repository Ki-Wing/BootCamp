package Test;

import java.io.*;
import java.util.*;


    public class 애너그램_2 {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = sc.next();
            }

            for (String s : str) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);  // 사전 순으로 정렬
                List<String> anagrams = generateAnagrams(chars);

                for (String anagram : anagrams) {
                    System.out.println(anagram);
                }
            }
        }

        private static List<String> generateAnagrams(char[] arr) {
            List<String> anagrams = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(new Node("", new boolean[arr.length]));

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                String current = node.str;
                boolean[] used = node.used;

                if (current.length() == arr.length) {
                    anagrams.add(current);
                } else {
                    for (int i = 0; i < arr.length; i++) {
                        if (!used[i]) {
                            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                                continue;
                            }
                            boolean[] newUsed = Arrays.copyOf(used, used.length);
                            newUsed[i] = true;
                            String newStr = current + arr[i];
                            stack.push(new Node(newStr, newUsed));
                        }
                    }
                }
            }

            return anagrams;
        }

        static class Node {
            String str;
            boolean[] used;

            Node(String str, boolean[] used) {
                this.str = str;
                this.used = used;
            }
        }
    }
//    개선된 코드 설명
//    입력 처리:
//
//    각 문자열을 입력받아 배열로 저장합니다.
//    문자열 순열 생성:
//
//    각 문자열에 대해 문자를 정렬하고, generateAnagrams 메서드를 호출하여 애너그램을 생성합니다.
//    애너그램 생성:
//
//    스택을 사용하여 DFS를 수행하며, 각 상태를 Node 객체로 저장합니다.
//    Node 객체는 현재 문자열과 사용된 문자를 추적하는 boolean 배열을 포함합니다.
//    모든 문자를 사용한 문자열을 생성하면 결과 리스트에 추가합니다.
//    사용되지 않은 문자를 사용하여 새로운 문자열을 생성하고, 이를 스택에 추가합니다.
//    중복 제거:
//
//    중복된 문자를 피하기 위해, 이전 문자가 사용되지 않은 경우에만 현재 문자를 사용하도록 합니다.
//    이 코드는 입력된 각 문자열에 대해 가능한 모든 애너그램을 사전 순으로 생성하여 출력합니다. 재귀를 사용하지 않고 스택을 사용하여 DFS를 구현하였습니다.
