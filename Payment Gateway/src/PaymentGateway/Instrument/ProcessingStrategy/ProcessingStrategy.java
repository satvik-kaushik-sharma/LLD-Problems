package PaymentGateway.Instrument.ProcessingStrategy;

import PaymentGateway.Instrument.Instrument;

public interface ProcessingStrategy {

    public default boolean canProcessAmount(Instrument instrument, Integer amount) {
        Integer balance = instrument.getBankAccount().getBalance();
        return balance >= amount;
    }
    public default void deductAmount(Instrument instrument, Integer amount) {
        instrument.getBankAccount().setBalance((instrument.getBankAccount().getBalance() - amount));
    }

    public boolean authenticate(Instrument instrument) throws Exception;
}
