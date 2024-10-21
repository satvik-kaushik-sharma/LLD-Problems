package PaymentGateway.Instrument.ProcessingStrategy;

import PaymentGateway.Instrument.DebitCard;
import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Instrument.UPI;
import PaymentGateway.Repository.InstrumentRepository;

public class DebitCardProcessingStrategy implements ProcessingStrategy{
    InstrumentRepository instrumentRepository = InstrumentRepository.getInstance();

    @Override
    public boolean authenticate(Instrument instrumentProvided) throws Exception {
        if(!(instrumentProvided instanceof DebitCard)) throw new Exception("Internal Error");
        DebitCard dbInstrument = (DebitCard)instrumentRepository.getInstrument(instrumentProvided.getInstrumentId());
        return dbInstrument.getPin().equals(((DebitCard) instrumentProvided).getPin());
    }
}
