package PaymentGateway.Instrument.ProcessingStrategy;

import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Instrument.UPI;
import PaymentGateway.Repository.InstrumentRepository;

public class UPIProcessingStrategy implements ProcessingStrategy {
    InstrumentRepository instrumentRepository = InstrumentRepository.getInstance();

    @Override
    public boolean authenticate(Instrument instrumentProvided) throws Exception {
        if(!(instrumentProvided instanceof UPI)) throw new Exception("Internal Error");
        UPI dbInstrument =  (UPI)instrumentRepository.getInstrument(instrumentProvided.getInstrumentId());
        return dbInstrument.getPin().equals(((UPI) instrumentProvided).getPin());
    }
}
