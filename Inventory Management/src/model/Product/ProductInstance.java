package model.Product;

public class ProductInstance {
    private String id;
    private Product product;
    private ProductInstanceStatus status;

    public boolean isAvailable() { // not ordered yet
        return this.status.equals(ProductInstanceStatus.INVENTORY);
    }

    public void order() {
        this.status = ProductInstanceStatus.ORDERED;
    }

}
