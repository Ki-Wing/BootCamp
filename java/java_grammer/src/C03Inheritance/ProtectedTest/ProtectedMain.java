
//루트(최상단) 패키지는 src
package C03Inheritance.ProtectedTest;
// * 을 통해 패치키내 모든 클래스 import 가능
// * 을 통해 패키지내에 패키지까지 포함해서 모든 내용 import는 불가능
//즉, java.* 불가임

import C03Inheritance.C0304ProtectedClass;

public class ProtectedMain extends C0304ProtectedClass {
    public static void main(String[] args) {
        C0304ProtectedClass c1 = new C0304ProtectedClass();
//        System.out.println(c1.st2); // default 접근 불가
//        System.out.println(c1.st3); // protected 접근 불가(동일 패키지가 아니기 때문)
        System.out.println(c1.st4);

        ProtectedMain p1 = new ProtectedMain();
//        System.out.println(p1.st2); // default 접근 불가
        System.out.println(p1.st3);  // 상속한 객체에서 protected 접근 가능



    }
}
