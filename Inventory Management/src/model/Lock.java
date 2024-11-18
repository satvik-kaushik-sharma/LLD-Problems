package model;

import model.Product.ProductInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Lock {
    static int ttl = 10;
    User lockedBy;
    LocalTime issuedAt;
    ProductInstance productInstance;

    public Lock(User lockedBy, ProductInstance productInstance) {
        this.lockedBy = lockedBy;
        this.productInstance = productInstance;
        this.issuedAt = LocalTime.now();
    }

    public boolean isLockExpired() {
        LocalTime now = LocalTime.now();
        long minutesElapsed = ChronoUnit.MINUTES.between(issuedAt, now);
        return minutesElapsed > ttl;
    }

    public static int getTtl() {
        return ttl;
    }

    public static void setTtl(int ttl) {
        Lock.ttl = ttl;
    }

    public User getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(User lockedBy) {
        this.lockedBy = lockedBy;
    }

    public LocalTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public ProductInstance getInstance() {
        return productInstance;
    }

    public void setInstance(ProductInstance instance) {
        this.productInstance = instance;
    }
}
