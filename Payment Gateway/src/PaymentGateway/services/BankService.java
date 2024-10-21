package PaymentGateway.services;

import PaymentGateway.BankAccount;
import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Repository.BankAccountRepository;
import PaymentGateway.Repository.InstrumentRepository;
import PaymentGateway.User;

public class BankService {
    BankAccountRepository bankAccountRepository;

    public BankService(){
        this.bankAccountRepository = BankAccountRepository.getInstance();
    }

    public void addBankAccount(User user, BankAccount account) {
        this.bankAccountRepository.addBankAccount(user.getId(), account);
    }
}
