package C06EtcClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C0603GenericMain {
    public static void main(String[] args) {
        String[] stArr = {"java", "python", "c++"};
        stChange(stArr, 0, 1);
        System.out.println(Arrays.toString(stArr));

        Integer[] intArr = {10,20,30};
        intChange(intArr,0,1);
        System.out.println(Arrays.toString(intArr));

        genChange(stArr,0,1);
        System.out.println(Arrays.toString(stArr));
        genChange(intArr,0,1);
        System.out.println(Arrays.toString(intArr));

        Student s1 = new Student();
        s1.setValue("ynlee");

        GenericStudent s2 = new GenericStudent();
        s2.setValue(122);

        // 제네릭 사용
        List<String> myList= new ArrayList<>();
        myList.add("hi");
        myList.add("java");

        //컴파일 후 제네릭 소거
//        List<String> myList= new ArrayList<>();
//        myList.add("hi");
//        myList.add("java");


    }

//    제네릭메서드 생성 : 반환타입 왼쪽에 <T> 선언
//    유의점 ㅣ 제네릭은 객체 타입이 들어와야함
    static <T> void genChange(T[] arr, int a, int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    static void stChange(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    static void intChange(Integer[] arr, int a, int b) {
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}

class GenericStudent<T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}



class Student{
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}