package C07ExceptionFileParsing.AuthorException;

import java.util.*;

public class AuthorRepository {
    List<Author> authors; // DB 연결이 안되어 있어 일단은 Author리스트를 DB 대용으로 사용함.
    AuthorRepository(){
        authors = new ArrayList<>();
    }
    public void register(Author author) {
        authors.add(author);
    }
    public Optional<Author> getAuthorByEmail(String email){
        Author author1 = null;;
        for(Author author: authors){
            if(author.getEmail().equals(email)){
                author1 = author;
            }
        }
        return Optional.ofNullable(author1);
    }
}