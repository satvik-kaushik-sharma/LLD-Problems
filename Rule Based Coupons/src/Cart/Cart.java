package Cart;
import RuleEngine.RuleType;

import java.time.LocalDate;


public class Cart {
    private Double grossTotal;
    private Double discountedTotal;
    private Double discount;
    private LocalDate orderDate;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Cart(Double grossTotal, LocalDate orderDate) {
        this.grossTotal = grossTotal;
        this.orderDate = orderDate;
        this.discount = 0.0;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getDiscountedTotal() {
        return discountedTotal;
    }

    public void setDiscountedTotal(Double discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getGrossTotal() {
        return grossTotal;
    }

    public void setGrossTotal(Double grossTotal) {
        this.grossTotal = grossTotal;
    }

}
