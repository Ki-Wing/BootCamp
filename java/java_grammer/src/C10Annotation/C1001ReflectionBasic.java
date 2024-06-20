package C10Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class C1001ReflectionBasic {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 리플랙션 : java 프로그램이 런타임에 클래스, 메서드, 필드 등의 정보를 검사하고 수정할 수 있게함

        // 객체생성방식1. 기존의 방식과 메서드 호출
        Calculator calculator = new Calculator("Samsung");
        calculator.sayHi();
        
        // 객체생성방식2. 런타입 환경에서 리플렉션 기술을 통해 객체 생성 및 메서드 호출
            //<?> : 제네릭 표현으로 어떤 클래스타입도 가능하다
            //getclass 메서드 : 런타입시점에 calcuator라는 객체 타입을 가져오는 메서드
        Class<?> myclass = calculator.getClass();
        // 객체생성2-1)
        Calculator cal1 = (Calculator) myclass.getConstructor(String.class).newInstance();
        // 메서드 생성
        Method cal1Method = cal1.getClass().getMethod("sayHi");
        cal1Method.invoke(cal1);
        // 객체생성2-2) 실시간으로 Calculator 찾음
        Calculator cal2 = Calculator.class.getConstructor(String.class).newInstance("Casio");
        // 메서드 생성
        Method cal2Method = Calculator.class.getMethod("sayhi");
        cal2Method.invoke(cal2);

        // 리플렉션 기술을 통해 필드 접근 및 수정
        Field nameField = Calculator.class.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(cal1, "Casio");
        cal1Method.invoke(cal1);

    }
}

class Calculator{
    private  String name;

    public Calculator(){

    }

    public Calculator(String name){
        this.name = name;
    }
    public void sayHi(){
        System.out.println("my name is "+this.name);
    }





}
