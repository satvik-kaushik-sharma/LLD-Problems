package PaymentGateway.Instrument;

import PaymentGateway.BankAccount;

public class NetBanking extends Instrument{

    private String userID;
    private String password; // in prod - stored a hashed version


    public NetBanking(String id, BankAccount bankAccount) {
        super(id, bankAccount);
    }
}
