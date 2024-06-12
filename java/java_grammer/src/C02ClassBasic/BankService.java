package C02ClassBasic;

import java.util.*;

public class BankService {    // BanckService
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> account = new HashMap<>();
        boolean run = true;

        while (run) {
            System.out.println("[서비스 목록]");
            System.out.println("1. 계좌 개설");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 계좌 송금");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            int N = sc.nextInt();

            switch (N) {
                case 1:
                    System.out.print("계좌번호를 입력해주세요: ");
                    String accountNumber = sc.next();
                    if (account.containsKey(accountNumber)) {
                        System.out.println("이미 존재하는 계좌번호입니다.");
                    } else {
                        account.put(accountNumber, new BankAccount(accountNumber));
                        System.out.println("계좌가 개설되었습니다.");
                    }
                    break;

                case 2:
                    System.out.print("입금할 계좌번호: ");
                    accountNumber = sc.next();
                    BankAccount depositAccount = account.get(accountNumber);
                    if (depositAccount == null) {
                        System.out.println("계좌번호를 찾을 수 없습니다.");
                    } else {
                        System.out.print("입금 금액: ");
                        int d_amount = sc.nextInt();
                        depositAccount.deposit(d_amount);
                    }

//                    [다른 방법] - List로 하는법도 공부해보기
//                        int money = sc.nextInt();
//                        for(backAccount b : backAccounts){
//                            if(b.getAccountNumber().equals(accountNumber)){
//                                b.deposit(money);
//                            }
//                        }


                    break;

                case 3:
                    System.out.print("출금할 계좌번호: ");
                    accountNumber = sc.next();
                    BankAccount withdrawAccount = account.get(accountNumber);
                    if (withdrawAccount == null) {
                        System.out.println("계좌번호를 찾을 수 없습니다.");
                    } else {
                        System.out.print("출금 금액: ");
                        int w_amount = sc.nextInt();
                        withdrawAccount.withdraw(w_amount);
                    }
                    break;

                case 4:
                    System.out.print("송금할 계좌번호: ");
                    String fromAccountNumber = sc.next();
                    BankAccount fromAccount = account.get(fromAccountNumber);
                    if (fromAccount == null) {
                        System.out.println("송금할 계좌번호를 찾을 수 없습니다.");
                    } else {
                        System.out.print("입금할 계좌번호: ");
                        String toAccountNumber = sc.next();
                        BankAccount toAccount = account.get(toAccountNumber);
                        if (toAccount == null) {
                            System.out.println("입금할 계좌번호를 찾을 수 없습니다.");
                        } else {
                            System.out.print("송금 금액: ");
                            int amount = sc.nextInt();
                            fromAccount.transfer(toAccount, amount);
                        }
                    }
                    break;

                case 5:
                    run = false;
                    System.out.println("서비스를 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 선택입니다.");
                    break;
            }
        }

        sc.close();
    }
}

class BankAccount {
    private String accountNumber;
    private int balance;

    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다.(잔액: " + balance + ")");
        }
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.(잔액: " + balance + ")");
        } else {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다.(잔액: " + balance + ")");
        }
    }

    public void transfer(BankAccount recipient, int amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.(잔액: " + balance + ")");
        } else {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println(amount + "원이 송금되었습니다 (송금 계좌: " + recipient.getAccountNumber() + ")");
        }
    }
}
