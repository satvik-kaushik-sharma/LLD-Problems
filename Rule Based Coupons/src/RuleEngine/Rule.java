package RuleEngine;

public abstract class Rule<T> {
    private RuleType type;

    public Rule(RuleType type) {
        this.type = type;
    }

    public abstract boolean isApplicable(T entity);

    public abstract void apply(T entity);

    @Override
    public String toString() {
        return "Rule{" +
                "type=" + type +
                '}';
    }

    public RuleType getType() {
        return type;
    }

    public void setType(RuleType type) {
        this.type = type;
    }

}
