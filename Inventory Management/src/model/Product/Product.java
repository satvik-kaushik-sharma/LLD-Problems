package model.Product;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private List<ProductInstance> productInstances;
    private String price;

    public Product(String id, String name, List<ProductInstance> productInstances, String price) {
        this.id = id;
        this.name = name;
        this.productInstances = productInstances;
        this.price = price;
    }

    public List<ProductInstance> getProductInstances() {
        return productInstances;
    }

    public void setProductInstances(List<ProductInstance> productInstances) {
        this.productInstances = productInstances;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
