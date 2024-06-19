package C05AnonymousLambda;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.*;
import java.util.Optional.*;

public class C0504SteamAPI {
    public static void main(String[] args) {
        int[] arr = {20,10,4,12};
//        전통적인 방식의 데이터 접근방식 : 메모리 주소 접근
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

//        함수형 프로그래밍 방식 : 데이터의 객체 중심이 아닌, 입력에 따른 출력만 존재
//         forEach : 스트밈의 각 요소를 소모히면서 동작 수행
//        자바에서 함수형 프로그래밍을 지원하기 위한 라이브럴 : streamAPI
        Arrays.stream(arr).forEach(a -> System.out.println(a));


//        스트림 생성
        String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
//        stream<클래스명> : 제네릭타입으로 stream객체가 생성
        Stream<String> stream1 = Arrays.stream(stArr);
        List<String> stList = new ArrayList<>(Arrays.asList(stArr));
        Stream<String> stream2 = stList.stream();

        int[] intArr = {10,20,30,40,50,60};
//        기본형 자료는 별도의 stream을 제공
//        Stream<Integer> stream3 = Arrays.stream(intArr);
        IntStream stream3 = Arrays.stream(intArr);  //LongStream, DoubleStream ...

        List<Integer> mylist = new ArrayList<>();
        mylist.add(10);
        mylist.add(20);
        mylist.add(30);
        Stream<Integer> stream4 = mylist.stream();
//        int가 아니라 Integer이기 때문에 Intstream은 사용 불가

//        stream 변환(중개얀산) : filter, map, sorted, distinct, limit
        String[] stArr1 = {"HTML", "CSS", "JAVA", "PYTHON"};
//        filter : 특정기준으로 대상을 filtering하는 것 (a : 알아서 요소들 꺼내 담음)
//        Stream<String>반환..
        // 밑에처럼하면 stream인지 모름. 참조변수의 스트림뱐환의 경우 제네릭의 타입소거 문제 발생
        // 제네릭의 타입 소거란 제네릭타입을 런타임시점에는 제거하는 것을 의미
        // 타입의 소거된 stream객체에서 배열로 변환하려면 타입이 뭔지를 명시해줘야함(타입캐스팅)
//        String[] newStArr = Arrays.stream(stArr1).filter(a -> a.length() <= 4).toArray();
        String[] newStArr = Arrays.stream(stArr1).filter(a -> a.length() <= 4).toArray(String[]::new); //a변수에는 stream요소의 개수
        String[] numStArr2 = Arrays.stream(stArr1).filter(a->a.length()<=4).toArray(String[]::new); //메소드 참조(매개변수가 추론가능할때 생략하는 방식) -> 클래스::메서드

        int[] intArr3 = {10,10,20,30,40,50};
        // Arrays.stream(intArr3) : 제너릭이 아니라 int Stream이기 때문에 toArray(int[]::new) 이런거 필요 x
        int[] newintArr = Arrays.stream(intArr3).filter(a -> a<=30).toArray();
        int[] newintArr1 = Arrays.stream(intArr3).distinct().toArray();  // 중복제거
        System.out.println(Arrays.toString(newintArr));
        System.out.println(Arrays.toString(newintArr1));

        int total = Arrays.stream(intArr).sum();
        System.out.println(total);

//        [map] : 기존에 스트림을 조작하여 새로운 스트림 반환
        int[] newMapArr = Arrays.stream(intArr).map(a->a*10).toArray();
        System.out.println(Arrays.toString(newMapArr));

        int[] intArr4 = {6,5,4,3,2,1};
        // 홀수 담은 배열의 값을 제곱
        int[] newMapArr2 = Arrays.stream(intArr4).filter(a->a%2!=0).map(a-> a*a).toArray();
        System.out.println(Arrays.toString(newMapArr2));

        //홀수만 담은 배열의 값을 제곱한 새로운 배열 내림차순 정렬 : filter, map, sorted
        int[] newMapArr3 = Arrays.stream(intArr4).filter(a->a%2!=0).map(a-> a*a).sorted().toArray();
        System.out.println(Arrays.toString(newMapArr3));

//        mapToInt : intstream형태로 변환해주는 map
        String[] stArr3 = {"HTML", "CSS", "JAVASCRIPT", "JAVA"};
//        각 문자열의 길이를 담은 새로운 int배열 생성
        int[] newMapArr4 = Arrays.stream(stArr3).mapToInt(a->a.length()).toArray();
        System.out.println(Arrays.toString(newMapArr4));

        int[] newMapArr5 = Arrays.stream(stArr3).mapToInt(a->a.length()).limit(3).toArray();
        System.out.println(Arrays.toString(newMapArr5));


        // 스트림의 소모 -> sum:합계, reduce:누적연산, forEach:출력 등
        int[] intArr2 = {10,20,30,40};
        Arrays.stream(intArr2).forEach(System.out::println);
        int intArrSum = Arrays.stream(intArr2).sum();
        // optional 객체 : 값이 있을수도, 없을수도 있음을 명시한 객체
        int intArrMax = Arrays.stream(intArr2).max().getAsInt();
        int intArrCount = (int)Arrays.stream(intArr2).count();
        int allMultiply = Arrays.stream(intArr2).reduce(1, (a,b) -> a*b);
        int allAdd =Arrays.stream(intArr2).reduce(1, (a,b) -> a+b);
        System.out.println(allAdd + " " + allMultiply);

        String stAllAdd = Arrays.stream(stArr3).reduce("", (a,b) -> a+b);
        System.out.println(stAllAdd);

        //findFirst, findAny
        List<Student> students = new ArrayList<>();
        students.add(new Student("test", 20));
        students.add(new Student("test1", 30));
        students.add(new Student("test2", 23));
        students.add(new Student("test3", 32));

        // 나이가 30이 넘는 학생중에 첫번째 index값을 가지는 학생 객체 생성
        Optional<Student> st1 = students.stream().filter(a -> a.getAge() > 30).findFirst();
        Student st2 = students.stream().filter(a -> a.getAge() > 30).findFirst().get();
        System.out.println(st1 + ""  + st2);

//        student 객체 실습
//1) 모든 객체의 평균나이
        int st3 = (int)students.stream().mapToInt(Student::getAge).average().getAsDouble();
        System.out.println(st3);
//2) 가장 나이 어린 사람 찾기
        Student st4 = students.stream().min(Comparator.comparingInt(Student::getAge)).get();
//        Student st4 = students.stream().sorted((a,b)-> a.getAge()-b.getAge()).findFirst().get();
        System.out.println(st4);
//3) 30대가 몇명인지 출력
        long st5 = students.stream().filter(a -> a.getAge() >= 30).count();
        System.out.println(st5);
//4) 30대 이름
        String st6 = Arrays.toString(students.stream().filter(a -> a.getAge() >= 30).map(Student::getName).toArray(String[]::new));
        System.out.println(st6);

//        Optional 객체 : 특정객체에 값이 없을지도 모른다는 것을 명시적으로 표현
//        ofNullable : null이 있을수도 있는 경우에 optional 객체를 생성
        Optional<String> opt1= Optional.ofNullable(null);
        String st7 = null;
        if(opt1.isPresent()){
            System.out.println(opt1.get().compareTo("hi"));
        }else{
            System.out.println("값이 없음");
        }

//        Optional 객체 생성 3가지
        Optional<String> opt2 = Optional.empty();
        Optional<String> opt3 = Optional.of(null); //null 못들감
        Optional<String> opt4 = Optional.ofNullable(null); //null 들감


//        optional객체 처리 방법 4가지
//        방법1) isPresent() 확인 후 get()
//        if(opt4.isPresent()){
//            System.out.println(opt4.get().length());
//        }
//        방법2) orElse() : 값이 있으면 있는값 return, 없으면 람다 함수 실행
        System.out.println(opt4.orElse("").length());
//        방법3) orElseGet()
        System.out.println(opt4.orElseGet(()-> new String("")).length());
//        방법4) orElseThrow() : 가장 중요. 값이 있으면 return, 없으면 지정된 예외 강제 발생
        System.out.println(opt4.orElseThrow(()->new NoSuchElementException("값이 없습니다.")).length());


        List<Student> studentss = new ArrayList<>();
        students.add(new Student("kim", 20));
        students.add(new Student("kim1", 21));
        students.add(new Student("kim2", 23));
        students.add(new Student("kim3", 25));
//        방법1
        OptionalDouble answer = studentss.stream().filter(a->a.getAge()>=29).
                mapToInt(a->a.getAge()).average();
        if(answer.isPresent()){
            System.out.println(answer.getAsDouble());
        }else {
            System.out.println("값이 없습니다.");
        }
        System.out.println(answer);
//        방법2
        double answer2 = students.stream().filter(a->a.getAge()>=29).
                mapToInt(a->a.getAge()).average().
                orElseThrow(()->new NoSuchElementException("값이 없습니다."));





    }
}
