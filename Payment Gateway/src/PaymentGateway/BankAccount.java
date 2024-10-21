package PaymentGateway;

public class BankAccount {
    User user;
    String accountNumber;
    Integer balance;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
//    String ifscCode; // in prod - maybe a branch id


    @Override
    public String toString() {
        return "BankAccount{" +
                "user=" + user +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    public BankAccount(User user, String accountNumber, Integer balance) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
