package C01Basic;

// 재귀함수를 잘못 사용하면 스택오버플로우 생길 수 있음 -> for문으로 할 수 있는걸 재귀에 한다? 위험한 코드임

public class C1102StackFunction2 {
    public static void main(String[] args) {
        System.out.println("main함수 시작");
        function1(1);
        System.out.println("main함수 끝");


    }
    static int function1(int n){
        System.out.println("func1 시작 " + n);
        System.out.println("func1 끝");
        return function1(n+1);    // stackoverflow 무한히 계속 쌓이는 거임
        
    }
}
