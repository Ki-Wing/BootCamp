package C01Basic;

// stack을 활용한 함수 호툴 원리
public class C1101StackFunction1 {
    public static void main(String[] args) {
        System.out.println("main시작");
        function1();
        System.out.println("main끝");
    }
    
    static void function1(){
        System.out.println("fun1시작");
        function2();
        System.out.println("fun1끝");
        
    }
    static void function2(){
        System.out.println("fun2시작");
        System.out.println("fun2끝");

    }
}
