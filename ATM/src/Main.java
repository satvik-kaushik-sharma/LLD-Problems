import ATM.*;
import ATM.ATMState.Idle;
import ATM.Dispenser.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ATM atm = new ATM();
        atm.setState(new Idle(atm));

//         NOTE
        Dispenser one = new ConcreteDispenser(null, 100);
        Dispenser five = new ConcreteDispenser(one, 500);
        Dispenser two = new ConcreteDispenser(five, 2000);
        one.setAtm(atm);
        five.setAtm(atm);
        two.setAtm(atm);

        atm.setCashDispenser(two);

        ATMCard card = new ATMCard("222", "545");
        atm.getState().insertCard(card);

    }
}
