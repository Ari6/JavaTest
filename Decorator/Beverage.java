package Decorator;

import java.math.BigDecimal;

public abstract class Beverage {
    static int TALL = 5;
    static int GRANDE = 10;
    static int VENTI = 15;

    String description = "Unknown Beverage";
    int size;

    public String getDescription() {
        return description;
    }
    public abstract BigDecimal cost();

    public int getSize(){
        return size;
    }

    public void setSize(int size) {
        size = size;
    };
}
