package PaymentGateway.Instrument.ProcessingStrategy;

import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Instrument.UPI;
import PaymentGateway.Repository.InstrumentRepository;

public class UPIProcessingStrategy implements ProcessingStrategy<UPI> {
    InstrumentRepository instrumentRepository = InstrumentRepository.getInstance();

    @Override
    public boolean authenticate(UPI instrumentProvided) {
        UPI dbInstrument =  (UPI)instrumentRepository.getInstrument(instrumentProvided.getInstrumentId());
        return dbInstrument.getPin().equals((instrumentProvided).getPin());
    }
}
