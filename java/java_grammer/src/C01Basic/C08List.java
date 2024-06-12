package C01Basic;

import java.sql.Array;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class C08List {
    public static void main(String[] args) {
//        ArrayList<String> myList = new ArrayList<String>();
//
////        가장일반적인 List선언방법
////        왼쪽에 인터페이스, 오른쪽엔 구현체(클래스)
//        List<String> myList1 = new ArrayList<>();
//
////초기값 생성1) 하나씩 add
//        myList1.add("java");
//        myList1.add("python");
//        myList1.add("c++");
//
////초기값 생성2) 리스트 주입
//        String[] arr = {"java", "python", "c++"};
//        List<String> myList2 = new ArrayList<>(Arrays.asList(arr));
//        List<String> myList3 = new ArrayList<>(List.of(arr));
//
//        int[] intArr = {10,20,30};
//        List<Integer> intList4 = new ArrayList<>();
//        for(int i: intArr){
//            intList4.add(i);
//        }
//
        List<Integer> myList5 = new ArrayList<>();
        myList5.add(10);
        System.out.println(myList5);
//        add(index, 값) : 중간에 값 삽입  -> 성능 떨어짐.. index에 공간 만들라고 밀림
        myList5.add(0, 30);
        System.out.println(myList5);
//
        List<Integer> myList6 = new ArrayList<>();
        myList6.add(1);
        myList6.add(2);
        myList6.add(3);
        myList6.add(4);


//        특정 list 요소 모두 add
        myList6.addAll(myList5);

//        get: 특정 위치의 요소를 반환
        System.out.println(myList6);
        System.out.println(myList6.get(2));

//        for문을 통해 전체 list 출력
//        size() : list의 길이(개수) 반환

        for(int i=0;i<myList6.size();i++){
            System.out.println(myList6.get(i));
        }


//        remove: 요소 삭제
//        1) index를 통한 삭제 2)value를 통한 삭제
        System.out.println(myList6);
        myList6.remove(0);
        System.out.println(myList6);
        myList6.remove(Integer.valueOf(10));
        System.out.println(myList6);

//      set(index, value) : 인덱스 위치 자리에 value값 setting(값 변경)
        myList6.set(myList6.size()-1,10); //맨 끝자리 자리 변경

//        indexof : 특정값이 몇번째 index에 위치한지 return : 가장 먼저 나오는 값의 index return
        System.out.println(myList6.indexOf(10));

//        전체삭제: clear()
//        isEmpty : 값이 비었는지 확인
        System.out.println(myList6.isEmpty());
        myList6.add(10);
        System.out.println(myList6.contains(10));   //특정 값 유무 확인

//        이중list (list 안에 list)     -> [[], [] ....]
        List<List<Integer>> myList7 = new ArrayList<>();
        myList7.add(new ArrayList<>());
        myList7.add(new ArrayList<>());
        myList7.get(0).add(10);
        myList7.get(0).add(20);
        myList7.get(1).add(1);
        myList7.get(1).add(2);


//        리스트 안에 배열
        ArrayList<int[]> myList8 = new ArrayList<int[]>();;
        myList8.add(new int[]{1,2});
        myList8.add(new int[]{10,20,30});


//        리스트 정렬 : Collections.sort(), 리스트객체.sort()
        List<Integer> myList9 = new ArrayList<>();
        myList9.add(5);
        myList9.add(3);
        myList9.add(2);
        myList9.add(1);
        myList9.add(4);
//        정렬1) Collections.sort()
        Collections.sort(myList9);        //오름차순
        Collections.sort(myList9, Comparator.reverseOrder());     //내림차순
//        정렬2) 리스트객체.sort()


//        배열과 list간의 변환
//                1,String배열을 list<String>으로 변환
        String[] stArr = {"java", "python", "C++"};
//        1-1 Arrays.asList
        List<String> stList = new ArrayList<>(Arrays.asList(stArr));
//        1-2 for문을 통해 담기
//        1-3 StreamApi(참고)
        List<String> stList1= Arrays.stream(stArr).collect(Collectors.toList());
//        2.List<String>을 String배열로 변환
//                2-1 for문을 통해 담기
//                2-2 toArray
            String[] stArr2 = stList1.toArray(new String[stList.size()]);


//3. int배열을 List<Integer>로 변환
//3-1 for문을 통해 담기
//                3-2 streamAPI사용
            int[] intArr ={10,20,30,40};
            List<Integer> intList = Arrays.stream(intArr).boxed().collect(Collectors.toList());















    }
}
