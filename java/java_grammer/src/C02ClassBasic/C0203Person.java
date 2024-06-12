package C02ClassBasic;

public class C0203Person {
    private String name;
    private String email;
    private int age;

    // static이 없으니까 객체 method임
    public void lunch(){
        System.out.println(this.name + "님, 밥 먹기 실행");
    }

    // setter
    public void setName(String name){
        this.name = name;  //매개변수로 넘어오니까 this를 써야함
    }

    //getter
    public String getName(){
        return this.name;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;




    }
}
