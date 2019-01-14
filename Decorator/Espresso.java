package Decorator;

import java.math.BigDecimal;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }
    public BigDecimal cost() {
        return new BigDecimal("1.99");
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
