package C04Interface;

public class StaticFinalInterface {
    public static void main(String[] args) {
        Myimplements m1 = new Myimplements();
        m1.methodA();
        System.out.println();
    }
}

interface MyInterface{
    //아래 변수는 컴파일타임에 static final 키워드가 불금
    int my_constant = 10;

}

class Myimplements implements MyInterface{
    public void methodA(){
        System.out.println("hi");
    }
}
