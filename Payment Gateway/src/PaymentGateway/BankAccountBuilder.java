package PaymentGateway;

public class BankAccountBuilder {
    User user;
    String accountNumber;
    Integer balance;

    public BankAccountBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public BankAccountBuilder withBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public BankAccountBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public BankAccount build() {
        return new BankAccount(this.user, this.accountNumber, this.balance == null ? 0 : this.balance);
    }
}
