import Cart.Cart;
import RuleEngine.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart(700.0, LocalDate.of(2012, 12 , 5));
        List<Rule<Cart>> rules = new ArrayList<>();
        rules.add(new MaxDiscountRule(RuleType.MaxLimit));
        rules.add(new ChristmasRule(RuleType.Festive));
        rules.add(new CartValueRule(RuleType.CartValue));

        RuleEngine engine = new RuleEngine(rules);
        engine.run(cart);

//        System.out.println(cart.getDiscount());
    }
}