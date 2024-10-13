package ATM.Dispenser;

import ATM.ATM;

public abstract class Dispenser {
    public ATM atm;
    private final Dispenser next;

    public Dispenser(Dispenser next) {
        this.next = next;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public boolean dispense(Integer amount) {
        if(this.next != null) {
            return this.next.dispense(amount);
        }
        return amount == 0;
    }
}
