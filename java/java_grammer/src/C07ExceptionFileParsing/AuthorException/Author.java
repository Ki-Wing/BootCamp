package C07ExceptionFileParsing.AuthorException;
import java.util.*;
public class Author {
    static int staticid = 0;
    private String name;
    private String email;
    private String passwd;
    private int id;

    Author(String name, String email, String passwd) {
        this.id = ++staticid;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public static int getStatic_id() {
        return staticid;
    }

    public static void setStatic_id(int staticid) {
        Author.staticid = staticid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }
}

