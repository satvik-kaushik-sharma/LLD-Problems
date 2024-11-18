package service;

import model.Cart;
import model.Order;
import model.User;

import java.util.Map;

public class OrderService {
    Map<User, Order> orderRepo;

    public Order createOrder(User user) throws Exception {
//        fetch cart
//        check locks - for all product instances
//        if valid for all
    //        create order
    //        update product instance status
    //        remove locks
    //        return order
//        if invalid lock
//            try to InventoryService::reserveProducts for invalid lock
//            if all reserved successfully -> replace in cart, place order
//            if not ->
//            either remove invalid ones from cart and place order
//            or throw "Not Available error"
//            or remove invalid ones from cart
    }

}
