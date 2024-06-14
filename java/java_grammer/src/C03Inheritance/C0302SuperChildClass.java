package C03Inheritance;

public class C0302SuperChildClass extends superParents{
    int a;
    int c;

    C0302SuperChildClass(){
//        부모클래스의 생성자를 의미
//        super.변수명 : 부모클래스의 변수명의미
        super(30);
        a=10;
        c=20;
    }

    public static void main(String[] args) {
        C0302SuperChildClass c1 = new C0302SuperChildClass();
        c1.display2();
    }


    void display2(){
        System.out.println(a);   //this.a 의미 객체 변수

    }
}


class superParents{
    int a;

    superParents(int a){
        this.a=a;
    }
    void display(){
        System.out.println("부모 클래스입니다.");
    }
}
