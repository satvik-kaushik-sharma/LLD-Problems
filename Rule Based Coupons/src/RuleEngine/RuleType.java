package RuleEngine;

public enum RuleType {
    CartValue(0),
    Festive(1),
    MaxLimit(2);

    private final Integer orderValue;

    private RuleType(Integer orderValue) {
        this.orderValue = orderValue;
    }
}
