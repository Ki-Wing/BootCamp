package C10Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class C1002Validation {
    public static void main(String[] args) throws IllegalAccessException {

//        User user = new User("test","test@naver.com");

        User user = new User("test", "");
        validate(user);
    }
    static void validate(Object object) throws IllegalAccessException {
        Class<?> myClass = object.getClass();
        Field[] fields = myClass.getDeclaredFields();
        for(Field f : fields){
            if(f.isAnnotationPresent(NotEmpty.class)){
                f.setAccessible(true);
                String value = (String) f.get(object);
                if(value==null || value.isEmpty()){
                    NotEmpty notEmpty = f.getAnnotation(NotEmpty.class);
                    throw new IllegalAccessException(notEmpty.message());
                }

            }
        }

    }

}
class User{
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "email cannot be empty")
    private String email;
    User(String name, String email){
        this.name = name;
        this.email = email;
    }

}

// RetentionPolicy.RUNTIME : 런타입 동작하도록 지정
//어노테이션, 특정 필드(변수)의 값 유무 검사
@Retention(RetentionPolicy.RUNTIME)
// field : 변수에 적용, type : class, interface 등에 적용, method : 메서드
@Target(ElementType.FIELD)
@interface NotEmpty{
    String message() default "this field cannot be empty";
}
