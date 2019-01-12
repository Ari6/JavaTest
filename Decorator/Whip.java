package Decorator;

import java.math.BigDecimal;

public class Whip extends CondimentDecorator {
    Beverage b;
    public Whip(Beverage b) {
        this.b = b;
    }
    public String getDescription() {
        return b.getDescription() + ", Whip";
    }
    public BigDecimal cost(){
        return  b.cost().add(new BigDecimal("0.20"));
    }
}
