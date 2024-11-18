package model;

import model.Product.ProductInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    User user;
//    Map<String, Integer> productIdToCountMap = new HashMap<>();
    List<ProductInstance> cartItems;

    public Cart(User user) {
        this.user = user;
    }

}
