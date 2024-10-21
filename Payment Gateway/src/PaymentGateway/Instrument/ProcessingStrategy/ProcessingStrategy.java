package PaymentGateway.Instrument.ProcessingStrategy;

import PaymentGateway.Instrument.Instrument;

public interface ProcessingStrategy<T extends Instrument> {

    public default boolean canProcessAmount(T instrument, Integer amount) {
        Integer balance = instrument.getBankAccount().getBalance();
        return balance >= amount;
    }
    public default void deductAmount(T instrument, Integer amount) {
        instrument.getBankAccount().setBalance((instrument.getBankAccount().getBalance() - amount));
    }

    public boolean authenticate(T instrument) throws Exception;
}
