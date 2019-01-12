package Decorator;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {
    Beverage b;

    public Mocha(Beverage b) {
        this.b = b;
    }
    public String getDescription() {
        return b.getDescription() + ", Mocha";
    }
    public BigDecimal cost() {
        return  b.cost().add(new BigDecimal("0.20"));
    }
}
