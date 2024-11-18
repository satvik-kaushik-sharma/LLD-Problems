package service;

import model.Cart;
import model.Product.Product;
import model.User;

import java.util.Map;

public class CartService {
    Map<User, Cart> cartRepo;

    public void addProduct(User user, Product product, int quantity) {
    // reserve number of Product Instance = quantity
    }

    public void removeProduct(User user, Product product, int quantity) {

    }

    public Cart getCart(User user) {
        return cartRepo.get(user);
    }
}
