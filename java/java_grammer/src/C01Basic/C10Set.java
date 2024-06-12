package C01Basic;

import java.util.*;

public class C10Set {
    public static void main(String[] args) {
//        Set<String> mySet = new HashSet<>();
//        mySet.add("h");
//        mySet.add("h");
//        mySet.add("i");
//        System.out.println(mySet);
//
//
//        String[] arr = {"baseball", "baseball","basketall"};
//        Set<String> mySet1 = new HashSet<>(Arrays.asList(arr));
//        System.out.println(mySet1);

//        집합 관련 함수 : 교집합(retainAll), 합집합(addAll), 차집합(removeAll)
        Set<String> set1 = new HashSet<>(Arrays.asList("java", "python","c++"));
        Set<String> set2 = new HashSet<>(Arrays.asList("java","html","node.js"));

        set1.addAll(set2);
//        set1.remove(set2);
        System.out.println(set1);

//        linkedhashset, treeset
        Set<String> set3 = new TreeSet<>();      // nloog(n) : arrays.sort랑 비슷한 성능
        set3.add("java");
        set3.add("java");
        set3.add("python");
        System.out.println(set3);


    }
}
