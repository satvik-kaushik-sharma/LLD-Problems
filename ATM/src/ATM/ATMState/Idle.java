package ATM.ATMState;

import ATM.ATM;
import ATM.ATMCard;

import java.util.Scanner;

public class Idle extends ATMState{
    public Idle(ATM atm) {
        super(atm);
        System.out.println("Insert Card");
    }
    @Override
    public void insertCard(ATMCard card) throws Exception {
        this.atm.setCard(card);
        this.atm.setState(new CardInserted(this.atm));
    }
}
