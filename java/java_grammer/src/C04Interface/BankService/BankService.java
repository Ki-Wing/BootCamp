package C04Interface.BankService;

public interface BankService {
    void deposit(int money, BankAccount bankAccount);
    void withdraw(int money, BankAccount bankAccount);
}

class BankCardService implements BankService {

    @Override
    public void deposit(int money, BankAccount bankAccount) {
        int myMoney = bankAccount.getBalance();
        int total = myMoney + money;
        bankAccount.updateBalance(total);
        System.out.println(money + "원 카드 입금되었습니다.");
        System.out.println("현재 잔액은 " + total);
    }

    @Override
    public void withdraw(int money, BankAccount bankAccount) {
        int myMoney = bankAccount.getBalance();
        if (myMoney < money) {
            System.out.println("잔액 부족입니다.");
        } else {
            int total = myMoney - money;
            bankAccount.updateBalance(total);
            System.out.println(money + "원 카드 출금되었습니다.");
            System.out.println("현재 잔액은 " + total);
        }
    }
}

class BankKakaoService implements BankService {

    @Override
    public void deposit(int money, BankAccount bankAccount) {
        int myMoney = bankAccount.getBalance();
        int total = myMoney + money;
        bankAccount.updateBalance(total);
        System.out.println(money + "원 카카오페이 입금되었습니다.");
        System.out.println("현재 잔액은 " + total);
    }

    @Override
    public void withdraw(int money, BankAccount bankAccount) {
        int myMoney = bankAccount.getBalance();
        if (myMoney < money) {
            System.out.println("잔액 부족입니다.");
        } else {
            int total = myMoney - money;
            bankAccount.updateBalance(total);
            System.out.println(money + "원 카카오페이 출금되었습니다.");
            System.out.println("현재 잔액은 " + total);
        }
    }
}

