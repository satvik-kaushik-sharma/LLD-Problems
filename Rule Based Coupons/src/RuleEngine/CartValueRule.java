package RuleEngine;

import Cart.Cart;

public class CartValueRule<T extends Cart> extends Rule<T>{

    public CartValueRule(RuleType type) {
        super(type);
    }
    @Override
    public boolean isApplicable(T cart) {
        return cart.getGrossTotal() >= 100;
    }

    @Override
    public void apply(T cart) {
        cart.setDiscount(cart.getDiscount()+5);
    }
}
