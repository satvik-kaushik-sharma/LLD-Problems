package PaymentGateway.services;

import PaymentGateway.BankAccount;
import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Instrument.ProcessingStrategy.ProcessingStrategy;
import PaymentGateway.Instrument.ProcessingStrategy.ProcessingStrategyFactory;
import PaymentGateway.Repository.BankAccountRepository;
import PaymentGateway.Repository.UserRepository;
import PaymentGateway.User;

public class PaymentService {
    private final UserRepository userRepo = UserRepository.getInstance();
    private final ProcessingStrategyFactory processingStrategyFactory = new ProcessingStrategyFactory();
    BankAccountRepository bankAccountRepository = BankAccountRepository.getInstance();

    public synchronized void makePayment(String fromUserId, String toUserId, Instrument instrument, Integer amount) throws Exception {
//        get users from user repo
        User fromUser = userRepo.getUser(fromUserId);
        User toUser = userRepo.getUser(toUserId);
//        get instrument from instrument repo
//        Instrument deductAmountInstrument = instrumentRepo.getInstrument(instrumentId);
//        verify that instrument belongs to "from user"
        if(!instrument.getBankAccount().getUser().equals(fromUser)) {
            throw new Exception("User doesn't own the Instrument provided");
        }
        ProcessingStrategy processingStrategy = processingStrategyFactory.getStrategyByInstrumentType(instrument);
//        verify credentials provided
        if(!processingStrategy.authenticate(instrument)) {
            throw new Exception("Wrong credentials provided");
        };
//        check if balance is sufficient
        if(!processingStrategy.canProcessAmount(instrument, amount)) {
            throw new Exception("Insufficient Funds");
        };
//        process transaction
        processingStrategy.deductAmount(instrument ,amount);

        BankAccount creditAccount = bankAccountRepository.getBankAccount(toUserId);
//        todo acquire locks - how?
        creditAccount.setBalance(creditAccount.getBalance() + amount);
    }
}
