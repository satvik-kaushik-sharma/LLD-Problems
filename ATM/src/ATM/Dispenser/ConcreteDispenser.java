package ATM.Dispenser;

public class ConcreteDispenser extends Dispenser{
    private final Integer value;
    public ConcreteDispenser(Dispenser next, Integer value) {
        super(next);
        this.value = value;
    }

    public boolean dispense(Integer amount) {
        int needed = amount/ value;
        int pending = amount% value;
        int have = this.atm.twoKNotes;
        boolean isSuccess = true;
        if(needed <= have) {
            isSuccess = super.dispense(amount% value);
            if(isSuccess) {
                System.out.println(value + " -> " + amount/ value);
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
