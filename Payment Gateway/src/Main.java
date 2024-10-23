import PaymentGateway.BankAccount;
import PaymentGateway.BankAccountBuilder;
import PaymentGateway.Instrument.DebitCard;
import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Instrument.UPI;
import PaymentGateway.Repository.BankAccountRepository;
import PaymentGateway.Repository.InstrumentRepository;
import PaymentGateway.Repository.UserRepository;
import PaymentGateway.User;
import PaymentGateway.services.BankService;
import PaymentGateway.services.PaymentService;

public class Main {
    public static void main(String[] args) throws Exception {
//        need:-
//        2 users
//        bank accounts for both
//        multiple instruments for user 1

        User u1 = new User("1");
        User u2 = new User("2");
        UserRepository.getInstance().addUser(u1);
        UserRepository.getInstance().addUser(u2);

        BankAccount accountForU1 = new BankAccountBuilder().withAccountNumber("1").withUser(u1).withBalance(100).build();
        BankAccount accountForU2 = new BankAccountBuilder().withAccountNumber("2").withUser(u2).build();

        BankService bankService = new BankService();
        bankService.addBankAccount(u1, accountForU1);
        bankService.addBankAccount(u2, accountForU2);

        Instrument upiInstrument = new UPI("1#UPI", accountForU1, "satvik@oksbi", "1234");
        Instrument debitCard = new DebitCard("satvik71@okaxis", accountForU1, "987654321", "888", "0123");
        InstrumentRepository instrumentRepository = InstrumentRepository.getInstance();
        instrumentRepository.addInstrument(upiInstrument);
        instrumentRepository.addInstrument(debitCard);

        PaymentService paymentService = new PaymentService();
        System.out.println(accountForU1);
        System.out.println(accountForU2);
        paymentService.makePayment("1", "2", upiInstrument, 10);
        System.out.println(accountForU1);
        System.out.println(accountForU2);
        paymentService.makePayment("1", "2", debitCard, 20);
        System.out.println(accountForU1);
        System.out.println(accountForU2);

    }
}