package RuleEngine;

import Cart.Cart;

public class MaxDiscountRule<T extends Cart> extends Rule<T>{

    Double maxDiscount = 8.0;

    public MaxDiscountRule(RuleType type) {
        super(type);
    }

    @Override
    public boolean isApplicable(T cart) {
        return cart.getDiscount() > maxDiscount;
    }

    @Override
    public void apply(T cart) {
        cart.setDiscount(maxDiscount);
    }
}


