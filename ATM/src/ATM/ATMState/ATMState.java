package ATM.ATMState;

import ATM.ATM;
import ATM.ATMCard;
import ATM.State;

public abstract class ATMState {

    ATM atm;
    public ATMState(ATM atm) {
        this.atm = atm;
    }
    public void insertCard(ATMCard card) throws Exception {
        throw new Exception("Invalid State");
    }

    public  boolean authenticateCard(String pin) throws  Exception{
        throw new Exception("Invalid State");
    }

    public  boolean selectAction(State state) throws  Exception{
        throw new Exception("Invalid State");
    }

    public  boolean withdrawCash(Integer amount) throws  Exception{
        throw new Exception("Invalid State");
    }

    public  Integer checkBalance() throws  Exception{
        throw new Exception("Invalid State");
    }

    public  boolean depositCash(Integer amount) throws  Exception{
        throw new Exception("Invalid State");
    }

    public  boolean dispenseCash(String pin) throws  Exception{
        throw new Exception("Invalid State");
    }
}
