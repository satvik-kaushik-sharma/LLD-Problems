package PaymentGateway.Instrument;

import PaymentGateway.BankAccount;

public class CreditCard extends Instrument{

//    todo make another CardInstrument class to inherit here
    private String cardNumber;
    private String cvv;
    private String pin;  // in prod - stored a hashed version

    public CreditCard(String id, BankAccount bankAccount) {
        super(id, bankAccount);
    }
}
