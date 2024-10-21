package PaymentGateway.Repository;

import PaymentGateway.Instrument.Instrument;

import java.util.HashMap;
import java.util.Map;

public class InstrumentRepository {
    private static InstrumentRepository instance;
    Map<String, Instrument> instrumentsData;

    private InstrumentRepository() {
        this.instrumentsData = new HashMap<>();
    }

    public static InstrumentRepository getInstance() {
        if(InstrumentRepository.instance == null) {
            InstrumentRepository.instance = new InstrumentRepository();
        }
        return InstrumentRepository.instance;
    }

    public void addInstrument(Instrument instrument) {
        this.instrumentsData.put(instrument.getInstrumentId(), instrument);
    }

    public Instrument getInstrument(String instrumentId) {
        if(instrumentsData.containsKey(instrumentId)) return instrumentsData.get(instrumentId);
        return null;
    }
}
