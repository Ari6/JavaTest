package Decorator;

import java.math.BigDecimal;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }
    public BigDecimal cost() {
        return new BigDecimal("0.99");
    }
}
