package Decorator;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {
    Beverage b;
    public Soy(Beverage b) {
        this.b = b;
    }

    @Override
    public String getDescription() {
        return b.getDescription() + ", Soy";
    }

    @Override
    public int getSize() {
        return b.getSize();
    }

    public BigDecimal cost(){
        if(getSize() == Beverage.TALL) {
            return new BigDecimal("0.10").add(b.cost());
        } else {
            if(getSize() == Beverage.GRANDE) {
                return new BigDecimal("0.15").add(b.cost());
            } else {
                if(getSize() == Beverage.VENTI) {
                    return new BigDecimal("0.20").add(b.cost());
                }
            }
        }
        return BigDecimal.ZERO;
    }

}
