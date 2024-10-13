package ATM.ATMState;

import ATM.ATM;

import java.util.Scanner;

public class ActionSelection extends ATMState {

    public ActionSelection(ATM atm) {
        super(atm);
        System.out.println("1 for Balance Check, 2 for Cash Withdrawal, 3 for Depositing Cash");
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        this.actionSelected(number);
    }

    private void actionSelected(Integer number) {
        this.atm.setState(getNextState(number));
    }

    private ATMState getNextState(Integer number) {
        switch(number) {
            case 1:
                return new BalanceCheck(this.atm);
            case 2:
                return new CashWithdrawal(this.atm);
            default:
                System.out.println("Wrong Input, try again");
                return this;
        }
    }
}
