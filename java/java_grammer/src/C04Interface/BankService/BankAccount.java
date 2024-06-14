package C04Interface.BankService;

public class BankAccount {
    static long static_id = 0L;
    private long id;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountNumber) {
        static_id += 1;
        id = static_id;
        this.accountNumber = accountNumber;
    }

    public void updateBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }
}
