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


//        student 객체 5개 생성
        List<Student> students = new ArrayList<>();
        students.add(new Student("test1",24));
        students.add(new Student("test2",25));
        students.add(new Student("test3",22));
        students.add(new Student("test4",21));
        students.add(new Student("test5",22));
//        Collections.sort(students); //뭘로 정렬해야할지 모르니까 에러나는겨
//        방법1) Student 객체에서 Comparable를 구현 => compareTo 메서드를 오버라이딩
        System.out.println(students); //메모리 주소값이 나오는거임

        for(Student o : students){
//            System.out.println(s.getAge());
            System.out.println(o.getName());
        }

    }
}

class Student implements Comparable<Student>{
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

    @Override
    public int compareTo(Student o) {
//        return this.age - o.getAge(); //반대로하면 정렬 바뀜
//        return this.name.compareTo(o.getName());
        return o.getName().compareTo(this.name);
    }
}


