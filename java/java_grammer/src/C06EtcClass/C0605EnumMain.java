package C06EtcClass;

public class C0605EnumMain {
    public static void main(String[] args) {
        EnumStudent s1 = new EnumStudent();
        s1.setName("lee");
        s1.setClassgrade(ClassGrade.c1);

        EnumStudent s2 = new EnumStudent();
        s2.setName("lim");
        s2.setClassgrade(ClassGrade.c2);
// 타입이 String타입이므로 임의 클래스변수 사용하지 않을 수 있음
//        s2.setClassgrade("secondgrade");
// role의 경우 Enum으로 설정 시 위와 같은 실수 방지할 수 있음
//            s2.setRole("secondgrade"); 타입 안맞아서 불가능
        s2.setRole(Role.GENERAL_USER);

        System.out.println(s2.getRole());
        System.out.println(s2.getRole().getClass());
//        enum값 내부에는 저장된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(s2.getRole().ordinal());


    }
}

class ClassGrade{
    static final String c1 = "Freshman";
    static final String c2 = "Sophomore";
    static final String c3 = "Junior";
}

enum Role{
//    각 열거형 상수는 콤마로 구분하고, 상수목록끝에 세미콜론으로 마무리
//    static final 생략이 되어있는 형식
    GENERAL_USER, ADMIN_USER, SUPER_USER
}

class EnumStudent{
    private String name;
    private String classgrade;
    private Role role;

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassgrade() {
        return classgrade;
    }

    public void setClassgrade(String classgrade) {
        this.classgrade = classgrade;
    }

}