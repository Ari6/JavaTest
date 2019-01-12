package Decorator;

import java.math.BigDecimal;

public class HouseBlend extends Beverage  {
    public HouseBlend() {
        description = "House blend";
    }

    public BigDecimal cost() {
        return new BigDecimal("0.89");
    }
}
