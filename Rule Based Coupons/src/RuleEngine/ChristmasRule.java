package RuleEngine;

import Cart.Cart;

public class ChristmasRule<T extends Cart> extends Rule<T>{

    public ChristmasRule(RuleType type) {
        super(type);
    }

    @Override
    public boolean isApplicable(T cart) {
        return cart.getOrderDate().getMonthValue() == 12;
    }

    @Override
    public void apply(T cart) {
        cart.setDiscount(cart.getDiscount()+10);
    }
}
