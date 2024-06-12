package C01Basic;

import java.util.*;
import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11QueueStackDeque {
    public static void main(String[] args) {
//        Queue<Integer> que = new LinkedList<>();
//        que.add(10);
//        que.add(20);
//        que.add(30);
//        System.out.println(que.peek());
//        System.out.println(que.poll());
//
//        Queue<Integer> que1 = new LinkedList<>();  //큐는 get이 없음.

//LinkedList vs ArrayList
//        LinkedList add (중간삽입)
//        long startTime = System.currentTimeMillis();   //간단하게 코드 얼마나 시간 걸리는지 알 수 있음
//        LinkedList<Integer> ll = new LinkedList<>();
//        for(int i =0;i<10000; i++){
//            ll.add(0,10);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("LinkedList의 중간 삽입 : " + (endTime - startTime));
//
////        ArrayList add (중간삽입)  -> 개느림
//        long startTime1 = System.currentTimeMillis();   //간단하게 코드 얼마나 시간 걸리는지 알 수 있음
//        ArrayList<Integer> ll1 = new ArrayList<>();
//        for(int i =0;i<10000; i++){
//            ll1.add(0,10);
//        }
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("ArrayList의 중간 삽입 : " + (endTime1 - startTime1));
//
////        LinkedList get (조회)
//        long startTime2 = System.currentTimeMillis();   //간단하게 코드 얼마나 시간 걸리는지 알 수 있음
//        for(int i =0;i<10000; i++){
//            ll.get(i);
//        }
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("LinkedList의 조회 : " + (endTime2 - startTime2));
//
////        ArrayList get (조회) -> 개느림
//        long startTime3 = System.currentTimeMillis();   //간단하게 코드 얼마나 시간 걸리는지 알 수 있음
//        for(int i =0;i<10000; i++){
//            ll1.get(i);
//        }
//        long endTime3 = System.currentTimeMillis();
//        System.out.println("ArrayList의 조회 : " + (endTime3 - startTime3));
//
//프린터
//        Queue<String> q = new LinkedList<>();
//        q.add("문서1");
//        q.add("문서2");
//        q.add("문서3");
//        while (!q.isEmpty()){
//            System.out.println(q.poll());
//        }
//
////ArrayBlockingQueue : 길이제한큐
//        Queue<String> q1 = new ArrayBlockingQueue<>(3);
////        add 사용하면 길이제한 초과 시 예외 발샐
//        q1.add("10");
//        q1.add("20");
//        q1.add("30");  //하나 더 추가하면 막음
//        q1.offer("30");
//
//        System.out.println(q1);
//
//
////우선순위 큐 : D를 꺼낼때 정렬된 데이터 pop
//        Queue<Integer> pq = new PriorityQueue<>();
//        pq.add(10);
//        pq.add(30);
//        pq.add(20);
//        pq.add(40);
//        pq.add(50);
//        while(!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }


        
//        stack
//        Stack<Integer> st = new Stack<>();
//        st.push(10);
//        st.push(20);
//        System.out.println(st.peek());   //20 출력
//
//
////        String 객체 5개 정도 stack에 추가후에 while문 통해 출력
//        Stack<String> st1 = new Stack<>();
//        st1.push("e");
//        st1.push("e");
//        st1.push("l");
//        st1.push("n");
//        st1.push("y");
//        while(!st.isEmpty()){
//            System.out.println(st1.pop());   //요소 제거 후 반환
//        }

//데큐
        Deque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(10);
        d1.addLast(20);
        System.out.println(d1);
        d1.addLast(30);
        System.out.println(d1);
        System.out.println(d1.peekFirst());
        System.out.println(d1.peekLast());
        System.out.println(d1.pollFirst());
        System.out.println(d1.pollLast());
        System.out.println(d1);


        
    }
}

