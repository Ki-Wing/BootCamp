package C07ExceptionFileParsing.AuthorException;

import java.util.*;

class AuthorService {
    AuthorRepository authorRepository;
    AuthorService(){
        authorRepository = new AuthorRepository();
    }
    public void register(Author author) throws IllegalArgumentException{
        // 만약에 password 5자리 이하이면 예외발생 (IllegalArgu)
        Optional <Author> authors = authorRepository.getAuthorByEmail(author.getEmail());
        if (author.getPasswd().length()>=5) {
            if(authors.isPresent()){
                throw new IllegalArgumentException("이미 같은 회원이 존재합니다.");
            }else{
                authorRepository.register(author);
            }
        }else{
            throw new IllegalArgumentException("비밀번호 길이가 짧습니다.");
        }
    }
    
    Optional<Author> login(String email, String pwd ) throws IllegalArgumentException, NoSuchElementException {
        Optional <Author> author = authorRepository.getAuthorByEmail(email);
        if(author.isPresent()){
            if(author.get().getPasswd().equals(pwd)){
                return author;
            }else{
                // email에 맞는 passwd인지
                throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
            }
        }else{
            // 해당하는 email이 있는지
            throw new NoSuchElementException(email+" : 이메일을 찾을 수 없습니다.");
        }
    }
}