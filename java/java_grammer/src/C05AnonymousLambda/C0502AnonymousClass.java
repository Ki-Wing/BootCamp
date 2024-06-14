package C05AnonymousLambda;

public class C0502AnonymousClass {
    public static void main(String[] args) {
        // abstractanimal 상속한 클래스가 별도로 존재하지 않고
        // 익명의 클래스가 만들어짐과 동시에 익명 객체가 생성
        AbstractAnimal a1 = new AbstractAnimal() {
            @Override
            void makeSound2() {
            }
        };

        // 익명 객체에 구현메서드가 1개밖에 없을때에
        // 람다표현식(화살표 함수)로 표현 가능
//        Animal a2 = new Animal() {
//            @Override
//            public void makeSound() {
//                System.out.println("그르륵 스컬");
//            }
//        };

        // () 부분에 매개변수를 지정해 구현체에서 활용
        // 변수의 개수가 많을 때에는 개수&순서 맞춰서 지정
        Animal a2 = (a) -> System.out.println("그르륵 스컬스컬");
        a2.makeSound(10);

        // 실행문이 한줄 일때는 {}와 return 생략 가능
        // 2줄 이상이면 {} 사용해서 return 처리
        // 익명 객체 = 익명함수
        Animal2 a3 = (a,b,c) -> a+b+c;
        System.out.println(a3.makeSound("hi","hi",3));

        Animal2 a4 = (a,b,c) -> {
            if(c>10){
                return a+b;
            }else{
                return a;
            }
        };
        System.out.println(a4.makeSound("hi","hi",3));

    }
}


interface Animal{
    void makeSound(int a);
}

abstract class AbstractAnimal{
    void makeSound1(){
        System.out.println();
    }

    abstract void makeSound2();
}



interface Animal2{
    String makeSound(String a, String b, int c);
}



