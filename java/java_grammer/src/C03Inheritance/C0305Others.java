package C03Inheritance;

//public class C0305Others extends FinalParents{   -> 상속 불가능
public class C0305Others{
    public static void main(String[] args) {
        final int a=10;
//        a= 20; 변경 불가능
        
        AbstractDog dog = new AbstractDog();

//        추상클래스와 인터페이스는 구현없이 객체생성 불가
//        AbstractAnimal ani = new AbstractAnimal()

        // dog의 객체임
        AbstractAnimal ani = new AbstractDog();


    }

}

//final을 class에 추가 시 상속 불가한 클래스 생성
final class FinalParents{

}

// 추상클래스<중요 개념>
abstract class AbstractAnimal{
    void makeSound1(){
        System.out.println("[1]동물의 소리가 들려옵니다..");
    }

    //Method 앞에 final 붙으면 오버라이딩 불가
    final void makeSound2() {
        System.out.println("[2]동물의 소리가 들려옵니다..");
    }
    
    // abstract class는 자식 class로 하여금 오버라이딩 강제
    // abstract Method가 하나라도 있으면 반드시 class에도 abstract 키워드 붙어야함
    // 리턴타입과 매개변수만 정의
    // 이걸로 객체는 못만듦
    abstract void makeSound3();

    }

class AbstractDog extends AbstractAnimal{
    @Override
    void makeSound3() {
        System.out.println("[3]왈왈");
    }

    // 불가능    
//    void makeSound2{
//    }
}