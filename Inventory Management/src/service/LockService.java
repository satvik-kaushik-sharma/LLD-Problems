package service;

import model.Lock;
import model.Product.ProductInstance;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockService {
    Map<ProductInstance, Lock> locks = new HashMap<>();

    public boolean isValid(User user, ProductInstance productInstance) {
        if(locks.containsKey(productInstance)) {
            Lock lock = locks.get(productInstance);
            return !lock.isLockExpired() && lock.getLockedBy().equals(user);
        }
        return false;
    };

    public boolean isLocked(ProductInstance productInstance) {
        if(locks.containsKey(productInstance)) {
            Lock lock = locks.get(productInstance);
            if(!lock.isLockExpired()) {
                return true;
            }
        }
        return false;
    }

    public void lock(User user, List<ProductInstance> productInstances) throws Exception {
        for(ProductInstance productInstance: productInstances) {
            if (isLocked(productInstance)) throw new Exception("Already Locked");
            Lock lock = new Lock(user, productInstance);
            locks.put(productInstance, lock);
        }
    }

    public void unlock(List<ProductInstance> productInstances) {
        for(ProductInstance productInstance: productInstances) {
            locks.remove(productInstance);
        }
    }
}
