package ATM.ATMState;

import ATM.ATM;

import java.util.Scanner;

public class CardInserted extends ATMState{

    public CardInserted(ATM atm) {
        super(atm);
        System.out.println("Enter your PIN");
        Scanner sc = new Scanner(System.in);
        String pin = sc.nextLine();
        this.authenticateCard(pin);
    }
    @Override
    public  boolean authenticateCard(String pin) {
        boolean isCorrect = this.atm.getCard().authenticate(pin);
        if(isCorrect) {
            this.atm.setState(new ActionSelection(this.atm));
        } else {
            System.out.println("Wrong PIN, Try Again");
        }
        return isCorrect;
    }
}
