package C04Interface;

public class CatImplements implements AnimalInterface1{

    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}

class CatMultiImplements implements AnimalInterface1, AnimalInterface2{

    @Override
    public String play(String a, String b) {
        return a + "와 " + b + "가 웁니다.";
    }

    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}