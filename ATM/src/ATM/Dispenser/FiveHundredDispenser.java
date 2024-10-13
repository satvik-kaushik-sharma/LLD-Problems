package ATM.Dispenser;

public class FiveHundredDispenser extends Dispenser{
    public FiveHundredDispenser(Dispenser next) {
        super(next);
    }

    public boolean dispense(Integer amount) {
        Integer value = 500;
        int needed = amount/ value;
        int pending = amount% value;
        int have = this.atm.twoKNotes;
        boolean isSuccess = true;
        if(needed <= have) {
            isSuccess = super.dispense(amount% value);
            if(isSuccess) {
                this.atm.twoKNotes -= amount/ value;
                System.out.println("500 -> " + amount/ value);
            }
        } else {
            isSuccess = super.dispense(amount - have* value);
            if(isSuccess) {
                this.atm.twoKNotes = 0;
                System.out.println("500 -> " + have);
            }
        }
        return isSuccess;
    }
}
