package ATM;

public class ATMCard {
    private String cardNumber;
    private String pin; // encrypt in prod
    private Integer balance;
    public  ATMCard(String cardNumber, String pin) {
        this.balance = 98000;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
