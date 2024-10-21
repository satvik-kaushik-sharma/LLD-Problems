package PaymentGateway.Instrument.ProcessingStrategy;

import PaymentGateway.Instrument.DebitCard;
import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Instrument.UPI;
import PaymentGateway.Repository.InstrumentRepository;

public class DebitCardProcessingStrategy implements ProcessingStrategy<DebitCard>{
    InstrumentRepository instrumentRepository = InstrumentRepository.getInstance();

    @Override
    public boolean authenticate(DebitCard instrumentProvided) throws Exception {
        DebitCard dbInstrument = (DebitCard)instrumentRepository.getInstrument(instrumentProvided.getInstrumentId());
        return dbInstrument.getPin().equals((instrumentProvided).getPin());
    }
}
