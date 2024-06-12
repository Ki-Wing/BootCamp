package C02ClassBasic;

public class C0204MethodOverloading {
    public static void main(String[] args) {
//        방법1
        C0204MethodOverloading example = new C0204MethodOverloading();
        System.out.println(example.sum(1,2));
        System.out.println(example.sum(1,2, 3));
        System.out.println(example.sum(1.1,2.2));

//        방법2
//        static int sum ~

    }

//    접근제어자를 안붙이면 기본적으로 default 접근제어자
    int sum(int a, int b){
        return a+b;
    }

//    매개변수의 타입 또는 개수가 다르면, 같은 이름의 메소드 정의 가능 = 메소드 오버로딩
    int sum(int a, int b, int c){
        return a+b+c;
    }
    double sum(double a, double b){
        return a+b;
    }
}
