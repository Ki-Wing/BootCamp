package C02ClassBasic;

import java.util.*;

public class C0207RecurCombiPermu {
    static List<Integer> myList;

    static List<List<Integer>> answer;
    static int count;

    public static void main(String[] args) {

//        List<Integer>myList = new ArrayList<>(Arrays.asList(1,2,3,4));
////        myList로 만들수 있는 2개짜리 숫자조합을 이중리스트에 담기
////        [[1,2], [1,3] [1,4], ...]
//        List<List<Integer>> combinations = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        for(int i=0; i<myList.size()-1; i++){
//            temp.add(myList.get(i));
//            for(int j=i+1; j<myList.size(); j++){
//                temp.add(myList.get(j));
//                combinations.add(temp);
//                temp.remove(myList.size()-1);
//            }
//            temp.remove(myList.size()-1);
//        }

//        myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        answer = new ArrayList<>();
//        count = 5;
//        combinations(new ArrayList<>(), 0);
//        System.out.println(answer);


        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<List<Integer>> permutations = new ArrayList<>();
        permutations(myList, new ArrayList<>(), permutations);

        System.out.println(permutations);

    }

//    myList: 조합을 생성할 원본 리스트
//    answer: 생성된 조합을 저장할 리스트
//    count: 조합의 크기


    static void combinations(List<Integer> temp, int start) {
        if (temp.size() == count) {
//            temp값을 그대로 add할경우 temp메모리값이 add되므로, 모든 answer리스트에 같은 temp리스트 add
//            answer.add(temp);
            answer.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combinations(temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    //순열 만들기
    static void permutations(List<Integer> list, List<Integer> temp, List<List<Integer>> result) {
        if (list.isEmpty()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int re = list.remove(i);
            temp.add(re);
            permutations(list, temp, result);
            temp.remove(temp.size() - 1);
            list.add(i, re);
        }

    }
}
