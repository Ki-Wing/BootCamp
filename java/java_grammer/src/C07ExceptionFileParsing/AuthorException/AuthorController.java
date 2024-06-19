package C07ExceptionFileParsing.AuthorException;

import java.util.Scanner;

public class AuthorController {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.회원가입 \n2.로그인\n3.종료");
            int num = sc.nextInt();
            sc.nextLine(); // consume newline

            if (num == 1) {
                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("이메일: ");
                String email = sc.nextLine();
                System.out.print("비밀번호(8자리 이상): ");
                String passwd = sc.nextLine();
                Author auth = new Author(name, email, passwd);
                try {
                    authorService.register(auth);
                    System.out.println("회원가입 성공!");
                } catch (Exception e) {
                    System.out.println("회원가입 실패: " + e.getMessage());
                }
            } else if (num == 2) {
                System.out.print("이메일: ");
                String email = sc.nextLine();
                System.out.print("비밀번호: ");
                String passwd = sc.nextLine();

                try {
                    authorService.login(email, passwd);
                    System.out.println(" 로그인 성공!");
                } catch (Exception e) {
                    System.out.println("로그인 실패: " + e.getMessage());
                }
            } else if (num == 3) {
                System.out.println("프로그램 종료.");
                sc.close();
                return;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

