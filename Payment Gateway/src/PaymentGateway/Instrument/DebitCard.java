package PaymentGateway.Instrument;

import PaymentGateway.BankAccount;

public class DebitCard extends Instrument{

    private String cardNumber;
    private String cvv;
    private String pin;  // in prod - stored a hashed version

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public DebitCard(String id, BankAccount bankAccount, String cardNumber, String cvv, String pin) {
        super(id, bankAccount);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.pin = pin;
    }
}
