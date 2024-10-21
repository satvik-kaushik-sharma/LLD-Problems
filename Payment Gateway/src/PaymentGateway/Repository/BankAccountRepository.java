package PaymentGateway.Repository;


import PaymentGateway.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class BankAccountRepository {
    private static BankAccountRepository instance;
    Map<String, BankAccount> bankAccountData;

    private BankAccountRepository() {
        this.bankAccountData = new HashMap<>();
    }

    public static BankAccountRepository getInstance() {
        if(BankAccountRepository.instance == null) {
            BankAccountRepository.instance = new BankAccountRepository();
        }
        return BankAccountRepository.instance;
    }

    public void addBankAccount(String userId, BankAccount BankAccount) {
        this.bankAccountData.put(userId, BankAccount);
    }

    public BankAccount getBankAccount(String userId) {
        if(bankAccountData.containsKey(userId)) return bankAccountData.get(userId);
        return null;
    }
}
