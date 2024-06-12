package C01Basic;

import java.util.*;

public class C09Map {
    public static void main(String[] args) {
//        Map<String, String> myMap = new HashMap<>();
        // 값 입력 : put
//        myMap.put("basketball", "농구");
//        myMap.put("baseball", "야구");
//        myMap.put("soccer", "축구");
//        System.out.println(myMap);
//
//        // key로 value 찾기 : get, 검색 복잡도는 O(1)
//        System.out.println(myMap.get("soccer"));
//
//        // 삭제
//        myMap.remove("baseball");
//        System.out.println(myMap);
//
////        putifAbsent : 비어있으면 put
//        myMap.putIfAbsent("baseball", "야구");
////        getOrDefYLT : key가 없으면 defalut값 return
//        System.out.println(myMap.getOrDefault("baseball", "비어있음"));

////        System.out.println(myMap.containsKey("baseball"));
//        Map<String, Integer> myMap1 = new HashMap<>();
//        String[] arr = {"농구", "농구", "배구", "야구", "배구"}; //농구 : 2, 배구 : 2, 야구 :1
//        for (String a : arr) {
//            myMap1.put(a, myMap1.getOrDefault(a, 0) + 1);
//        }
////        keyset() : 키목록을 set형태로 반환
////        values() : value목록을 반환
//
//        for (String a : myMap1.keySet()) {
//            System.out.println(a);
//            System.out.println(myMap1.get(a));
//        }
//        for (int a : myMap1.values()) {
//            System.out.println();
//
//        }
//
//
////        Iterator를 통해 key값 하나씩 출력
//        Iterator<String> mmyIter = myMap1.keySet().iterator();
////        next() 메서드는 데이터를 하나씩 소모시키면서 return
////        System.out.println(mmyIter.next());
////        // hasNext() : iterator 안에 값이 있는지 없는지 boolean return
//        System.out.println(mmyIter.hasNext());
//        while (mmyIter.hasNext()) {      //값이 없을때까지 출력
//            System.out.println(mmyIter.next());
//        }

        Map<String, Integer> linkedMap = new LinkedHashMap<>();   //순서를 가지고 있다.
        linkedMap.put("hi1",1);
        linkedMap.put("hi2",1);
        System.out.println(linkedMap);

//         treemap : key를 통해 데이터를 정렬(최적화-log(n))
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("hi1",1);
        treeMap.put("hi2",1);
        System.out.println(treeMap);


    }
}


