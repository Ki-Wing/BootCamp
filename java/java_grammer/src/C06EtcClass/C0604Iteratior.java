package C06EtcClass;

import java.util.*;

public class C0604Iteratior {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("바나나");
        list.add("체리");
        list.add("블루베리");
        list.add("딸기");

//        for(String s : list){
//            System.out.println(s);
//        }

//        iterator는 참조하고 있는 원본데이터 삭제 가능 -> remove
         Iterator<String> iters = list.iterator();
        while(iters.hasNext()){
            System.out.println(iters.next());
        }

        Iterator<String> iters1 = list.iterator();
        while(iters1.hasNext()){
            if(iters1.next().equals("바나나"))
                iters1.remove();
        }
        System.out.println(list);
    }
}
