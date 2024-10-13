package ATM.ATMState;

import ATM.ATM;

public class BalanceCheck extends ATMState{

    public BalanceCheck(ATM atm) {
        super(atm);
        System.out.println("Your Bank Balance is: " + atm.getCard().getBalance());
        this.atm.setState(new Idle(this.atm));
    }

}
