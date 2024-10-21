package PaymentGateway.Instrument;

import PaymentGateway.BankAccount;

public abstract class Instrument {
    String instrumentId;
    BankAccount bankAccount;

    public Instrument(String id, BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.instrumentId = id;
    }

    public String getInstrumentId() {
        return instrumentId;
    }


    public BankAccount getBankAccount() {
        return bankAccount;
    }

}
