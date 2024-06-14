package C04Interface;

public class InterfaceMain {
    public static void main(String[] args) {
        CatImplements cat1 = new CatImplements();
        cat1.makeSound();
        DogImplements dog1 = new DogImplements();
        dog1.makeSound();

        // 다형성  하나의 객체가 여러개의 참조뱐수를 가질 수 있음을 의미
        AnimalInterface1 cat2 = new CatImplements(); //멀티 구현이 가능하기 때문에..
        cat1.makeSound();
        AnimalInterface1 dog2 = new DogImplements();
        dog1.makeSound();


        CatMultiImplements cat3 = new CatMultiImplements();
        System.out.println(cat3.play("코숏","스트릿"));
        cat3.makeSound();
        DogMultiImplements dog3 = new DogMultiImplements();
        System.out.println(dog3.play("리트리버", "시고르잡종"));
        dog3.makeSound();


////만약 animalinterface을 넣으면?
//        // AnimalInterface1을 넣으면 2기능을 못씀
//        AnimalInterface1 cat4 = new CatMultiImplements();
//        System.out.println(cat4.play("코숏","스트릿"));
//        cat4.makeSound();
//        // AnimalInterface2을 넣으면 1기능을 못씀
//        AnimalInterface2 dog4 = new DogMultiImplements();
//        System.out.println(dog4.play("리트리버", "시고르잡종"));
//        dog4.makeSound();


//    기본적으로 추상클래스, 인터페이스 객체 생성이 불가능하나,
//        익명내부클래스 방식으로 생성이 가능
        AnimalInterface1 al1 =  new AnimalInterface1() {
            @Override
            public void makeSound() {
                System.out.println("hi");
            }
        };
        al1.makeSound();



    }
}
