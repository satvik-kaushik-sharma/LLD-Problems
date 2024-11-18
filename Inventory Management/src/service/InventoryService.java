package service;

import model.Product.Product;
import model.Product.ProductInstance;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    List<Product> inventory;
    LockService lockService = new LockService();

    public List<ProductInstance> reserveProducts(User user, Product product, int quantity) throws Exception {
        List<ProductInstance> availableInstances = product
                .getProductInstances()
                .stream()
                .filter(productInstance ->
//                        Passive checking of expired locks
                        (productInstance.isAvailable()) && !lockService.isLocked(productInstance)
                )
                .toList();
        if(quantity > availableInstances.size()) {
            throw new Exception("Insufficient stock");
        }

//        which product instances are to be selected can be abstracted away using strategy pattern -> the oldest manufacturing date etc
        List<ProductInstance> reservedInstances = new ArrayList<ProductInstance>();

//        todo add locks
        for(int i=0;i<quantity;i++) {
            reservedInstances.add(availableInstances.get(i));
        }
        lockService.lock(user, reservedInstances);

        return reservedInstances;
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public void setInventory(List<Product> inventory) {
        this.inventory = inventory;
    }
}
