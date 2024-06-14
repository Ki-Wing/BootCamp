package C03Inheritance;

public class C0303MethodOverriding {
    public static void main(String[] args) {
            dog myDog = new dog();
            myDog.sound();

//            상속관계일때 부모클래스타입을 자식클래스객체의 타입으로 지정가능
//                animal 클래스에 정의된 메서드만 사용 가능하도록 제약 발생

        animal myDog2 = new dog();
        myDog2.sound(); //컴파일 에러


    }
}


class animal{
    void sound(){
        System.out.println("동물의 울음 소리가... 들립니다...");
    }
}


class dog extends animal{
    void sound(){
        System.out.println("멍멍");
    }

}


class cat extends  animal{
    void sound(){
        System.out.println("냥냥");
    }
}


