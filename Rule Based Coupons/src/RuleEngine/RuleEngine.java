package RuleEngine;

import Cart.Cart;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class RuleEngine<T extends Cart> {
    List<Rule<T>> rules;

    public RuleEngine(List<Rule<T>> rules) {
        this.rules = rules;
//        System.out.println(this.rules);
        this.rules.sort(Comparator.comparing(Rule::getType));
//        System.out.println(this.rules);
    }

    @Override
    public String toString() {
        return "RuleEngine{" +
                "rules=" + Arrays.toString(rules.toArray())+
                '}';
    }

    public void run(T cart) {
        for(Rule<T> rule: rules) {
            if(rule.isApplicable(cart)) {
                rule.apply(cart);
                System.out.println(cart.getDiscount());
            }
        }
        cart.setDiscountedTotal(cart.getGrossTotal()*cart.getDiscount()/100);
    }
}
