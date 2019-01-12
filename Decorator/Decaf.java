package Decorator;

import java.math.BigDecimal;

public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }
    public BigDecimal cost() {
        return new BigDecimal("1.05");
    }
}
