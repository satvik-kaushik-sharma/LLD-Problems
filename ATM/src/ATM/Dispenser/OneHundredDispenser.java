package ATM.Dispenser;

public class OneHundredDispenser extends Dispenser{
    public OneHundredDispenser(Dispenser next) {
        super(next);
    }

    public boolean dispense(Integer amount) {
        Integer value = 100;
        int needed = amount/ value;
        int pending = amount% value;
        int have = this.atm.twoKNotes;
        boolean isSuccess = true;
        if(needed <= have) {
            isSuccess = super.dispense(amount% value);
            if(isSuccess) {
                System.out.println("100 -> " + amount/ value);
                this.atm.twoKNotes -= amount/ value;
            }
        } else {
            isSuccess = super.dispense(amount - have* value);
            if(isSuccess) {
                this.atm.twoKNotes = 0;
                System.out.println("2000 -> " + have);
            }
        }
        return isSuccess;
    }
}
