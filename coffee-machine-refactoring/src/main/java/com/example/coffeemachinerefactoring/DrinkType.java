package com.example.coffeemachinerefactoring;

public enum DrinkType {
    COFFEE(0.5),
    CHOCOLATE(0.6),
    TEA(0.4);

    public final double price;

    private DrinkType(double price) {
        this.price = price;
    }
}
