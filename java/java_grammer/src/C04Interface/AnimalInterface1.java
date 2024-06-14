package C04Interface;

public interface AnimalInterface1 {
    public default void makeSound(){
        System.out.println("동물의 울음소리");
    }
}
