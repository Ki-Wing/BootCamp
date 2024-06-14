package C03Inheritance;

// extend 키워드를 통해 상소관계를 표현
public class C0301Inheritance extends Parents {
    int c = 30;
    public static void main(String[] args) {
        C0301Inheritance c = new C0301Inheritance();
//        자식 class라도 private 변수는 상속 및 접근불가
        System.out.println(c.a);
        System.out.println(c.c);

//        메서드 상속
        c.parentMethod();

    }

//    부모 메서드 재정의  ->  오버라이딩
//    성능 최적화를 위해 붙여주는게 좋다고 알려져있음(명시적)

//    @override
    void parentMethod(){
        System.out.println("부모가 아니라 자식입니다");
    }


    void childMethod(){
        System.out.println("자식입니다.");
    }


}
    class Parents{
        int a =10;
//        static int a =10;  이러면 parents에서 그냥 출력 가능

        private int b = 20;   //자식 class에서 접근할 수 있을까? 두둥
        
        void parentMethod(){
            System.out.println("부모 클래스 입니다.");
        }

}
