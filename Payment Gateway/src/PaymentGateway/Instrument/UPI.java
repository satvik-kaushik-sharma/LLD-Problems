package PaymentGateway.Instrument;

import PaymentGateway.BankAccount;

public class UPI extends Instrument{
    private String upiID;
    private String pin; // in prod - stored a hashed version

    public String getUpiID() {
        return upiID;
    }

    public void setUpiID(String upiID) {
        this.upiID = upiID;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public UPI(String id, BankAccount bankAccount, String upiID, String pin) {
        super(id, bankAccount);
        this.upiID = upiID;
        this.pin = pin;
    }
}
