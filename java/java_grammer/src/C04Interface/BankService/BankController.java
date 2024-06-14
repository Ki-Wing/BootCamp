package C04Interface.BankService;

import java.util.*;

public class BankController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계좌번호를 입력하세요");
        String accountNumber = sc.nextLine();
        BankAccount bankAccount = new BankAccount(accountNumber);

        while (true) {
            System.out.println("서비스 번호를 입력하세요. 1.카드 2.카카오페이");
            int number = Integer.parseInt(sc.nextLine());
            System.out.println("서비스 번호를 입력하세요. 1.입금 2.출금");
            int number2 = Integer.parseInt(sc.nextLine());

            BankService bankService;
            if (number == 1) {
                bankService = new BankCardService();
            } else if (number == 2) {
                bankService = new BankKakaoService();
            } else {
                System.out.println("잘못된 서비스 번호입니다.");
                continue;
            }

            System.out.println("금액을 입력하세요 : ");
            int money = Integer.parseInt(sc.nextLine());

            if (number2 == 1) {
                bankService.deposit(money, bankAccount);
            } else if (number2 == 2) {
                bankService.withdraw(money, bankAccount);
            } else {
                System.out.println("잘못된 서비스 번호입니다.");
            }
        }
    }
}
