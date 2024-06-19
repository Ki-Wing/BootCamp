package C05AnonymousLambda;

import java.util.*;

public class C0503ComparableComparator {
    public static void main(String[] args) {
//        자바에서는 비교를 위한 인터페이스 2개를 제공 : Comparable(오래됨), Comparator
//        comparable  인터페이스에는 comparaTo 메서드 선언
//        comparator 인터페이스에는 compare 메서드 선언

//        string 클래스에 compareTo 내장(comparable 구현)
//        string class 외에도 java  많은 내장 클래스에 comparable 구현
//        String a = "hi", b = "hhi";
//
//        // 두 문자열의 각 자리를 순차적으로 비교 (문자열 비교는 유니코드값의 차이 반환)
//        System.out.println(a.compareTo(b));
//
//        Integer a1 = 10, a2 = 30;
//        System.out.println(a1.compareTo(a2));
//
//        List<String> my = new ArrayList<>();
//        my.add("java");
//        my.add("python");
//        my.add("c");
//        Collections.sort(my); //comparable의 compateTo 메서드를 내부적으로 구현해서 정렬
//        System.out.println(my);
//        Collections.sort(my, Comparator.reverseOrder()); // 정렬
//        System.out.println(my);
//        my.sort(Comparator.reverseOrder());


////        student 객체 5개 생성
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("test1",24));
//        students.add(new Student("test2",25));
//        students.add(new Student("test3",22));
//        students.add(new Student("test4",21));
//        students.add(new Student("test5",22));
////        Collections.sort(students); //뭘로 정렬해야할지 모르니까 에러나는겨
////        방법1) Student 객체에서 Comparable를 구현 => compareTo 메서드를 오버라이딩
//        System.out.println(students); //메모리 주소값이 나오는거임
////        Collecions.sort(students)
//        for(Student o : students){
////            System.out.println(s.getAge());
//            System.out.println(o.getName());
//        }
////        방법2) Comparator를 구현한 익명객체를 srot에 주입
//        Comparator<Student> com = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge();  //오름차순
//            }
//        };
//        // 위에 코드를 람다로 만든거임
//        Comparator<Student>  ex = (a,b) -> a.getAge() - b.getAge();
//        // 위보다 더 간단하게
//        students.sort(( (a,b) -> a.getAge() - b.getAge()));
//        for(Student o : students){
////            System.out.println(s.getAge());
//            System.out.println(o.getName());
//        } //naturalOrder()
//
//
//        // 문자열 길이대로 내림차순 정렬
//        String[] stArr = {"hello", "java", "C++", "world2"};
////        Arrays.sort(stArr, Comparator.reverseOrder());
//        Arrays.sort(stArr, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
////        Arrays.sort(stArr, (s1, s2) -> s2.length() - s1.length());  // 이게 더 간단하고 쉬움
//        System.out.println(Arrays.toString(stArr));
//
//
//        // [4,5], [1,2], [5,0], [3,1] 기준으로 배열을 내림차순 정렬(배열에 0번째가 아닌 1번째를 기준으로)
//        // 만약에 1번째가 같으면 0번째로 내림차순
//        List<int[]> myList = new ArrayList<>(Arrays.asList(new int[]{4, 5}, new int[]{1, 2},
//                new int[]{5, 0}, new int[]{3, 1}));
//        myList.sort((a, b) -> b[1] - a[1]);
//        myList.forEach(arr -> System.out.println(Arrays.toString(arr)));


//        //pq 글자 길이, 내림차순
//        String[] stArr1 = {"hello", "java", "C++", "world2"};
//        Queue<String> pq = new PriorityQueue<>((s1, s2) -> s2.length() - s1.length());
//
//        for(String s : stArr1){
//            pq.add(s);
//        }
//
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }



//thread 구현 방법 : 쓰레드상속, runnable 주입
//            runnable 인터페이스 주입을 통한 쓰레드 생성
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("쓰레드 1입니다.");
            }
        });
        t1.start(); // 쓰레드 시작
        
        //위에랑 동일한데 람다로 바꾼거임
        Thread t2 = new Thread( () ->
            System.out.println("새로 생성한 객체입니다."));
        t2.start(); // 쓰레드 시작

        //위에랑 동일하게
        new Thread(() ->  System.out.println("새로 생성한 객체입니다.")).start();
        System.out.println("main 쓰레드 입니다");

//        위에 코드들 돌리면 쓰레드는 4개임(t1,t2,t3, 기본적으로 돌아가는거)
    }
}



//class Student implements Comparable<Student>{
class Student{

    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age= age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    // 모든 class의 조상 class인 object class의 toString 메서드를 오버라이드함
    // 객체 호출시에 자동으로 toString메서드 호출

    @Override
    public String toString(){
        return "이름 : " + this.name + ", 나이 : " + this.age + "\n";
    }

//    @Override
//    public int compareTo(Student o) {
////        return this.age - o.getAge(); //반대로하면 정렬 바뀜
////        return this.name.compareTo(o.getName());
//        return o.getName().compareTo(this.name);
//    }
}


