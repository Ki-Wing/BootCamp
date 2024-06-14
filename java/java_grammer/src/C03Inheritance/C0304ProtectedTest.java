package C03Inheritance;

public class C0304ProtectedTest {
    public static void main(String[] args) {
        C0304ProtectedClass pc = new C0304ProtectedClass();
        System.out.println(pc.st4);  // public 접근 가능
//        System.out.println(pc.st1);  // private 접근불 가능
        System.out.println(pc.st2);  //String변수 접근 가능
        System.out.println(pc.st3);  // protected 접근 가능(같은 패키지에 있으니까)

    }
}
