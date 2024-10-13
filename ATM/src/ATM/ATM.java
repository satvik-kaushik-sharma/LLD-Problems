package ATM;

import ATM.ATMState.ATMState;
import ATM.Dispenser.Dispenser;
import ATM.Dispenser.FiveHundredDispenser;
import ATM.Dispenser.OneHundredDispenser;
import ATM.Dispenser.TwoThousandDispenser;

public class ATM {
    ATMState state;
    ATMCard card;
    Dispenser cashDispenser;
    public Integer twoKNotes = 30;
    public Integer fiveHundredNotes = 22;
    public Integer oneHundredNotes = 11;

    public ATM() {
//        this.state = ;
    }

    public void setCashDispenser(Dispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    public ATMState getState() {
        return state;
    }

    public ATMCard getCard() {
        return card;
    }

    public void setCard(ATMCard card) {
        this.card = card;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public Dispenser getCashDispenser() {
        return cashDispenser;
    }

}
