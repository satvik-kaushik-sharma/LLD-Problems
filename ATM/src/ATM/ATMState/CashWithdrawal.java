package ATM.ATMState;

import ATM.ATM;

import java.util.Scanner;

public class CashWithdrawal extends ATMState{

    public CashWithdrawal(ATM atm) {
        super(atm);
        System.out.println("Enter Amount to withdraw");
        Scanner sc = new Scanner(System.in);
        Integer amount = sc.nextInt();
        if(amount == -1) {
            this.atm.setState(new Idle(this.atm));
        }
        if(this.atm.getCashDispenser().dispense(amount)) {
            this.atm.getCard().setBalance(this.atm.getCard().getBalance() - amount);
        } else {
            System.out.println("ATM Error");
        }
        System.out.println("Your Balance: " + this.atm.getCard().getBalance());
    }
}
