package PaymentGateway.Instrument.ProcessingStrategy;

import PaymentGateway.Instrument.DebitCard;
import PaymentGateway.Instrument.Instrument;
import PaymentGateway.Instrument.UPI;

public class ProcessingStrategyFactory {

    public ProcessingStrategy getStrategyByInstrumentType(Instrument instrument) throws Exception {
        if(instrument instanceof DebitCard) {
            return new DebitCardProcessingStrategy();
        } else if(instrument instanceof UPI) {
            return new UPIProcessingStrategy();
        }
        throw new Exception("Instrument not supported");
    }
}
