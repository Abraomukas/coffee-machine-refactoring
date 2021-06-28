package com.example.coffeemachinerefactoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MakeDrinkMachine {

    private DrinkType drinkType;
    private double money;
    private double totalTeaEarnings;
    private double totalCoffeeEarnings;
    private double totalChocolateEarnings;
    private int sugar;
    private boolean extraHot;
    private String message;
    private boolean endOfOrder;


    public void validateDrinkType(String typedDrinkType) {
        endOfOrder = false;
        extraHot = false;
        sugar = 0;
        switch (typedDrinkType.toUpperCase()) {
            case "COFFEE":
                drinkType = DrinkType.COFFEE;
                break;
            case "CHOCOLATE":
                drinkType = DrinkType.CHOCOLATE;
                break;
            case "TEA":
                drinkType = DrinkType.TEA;
                break;
            default:
                message = "The drink type should be tea, coffee or chocolate.";
                endOfOrder = true;
                System.out.println(message);
        }
    }

    public void validaTePrice(double typedMoney) {
        if (!endOfOrder) {
            if (typedMoney < drinkType.price) {
                endOfOrder = true;
                message = "The " + drinkType.toString().toLowerCase() + " costs " + drinkType.price + ".";
                System.out.println(message);
            } else {
                double change = typedMoney - drinkType.price;
                if (change == 0) {
                    money = typedMoney;
                } else {
                    money = drinkType.price;
                    System.out.println("Here is your change: " + change);
                }
                increaseEarningsOf(drinkType);
            }
        }
    }

    public void validateExtraSugar(int typedSugar) {
        if (!endOfOrder) {
            if (typedSugar > 2) {
                message = "The number of extra sugar cubes should be either 1 or 2.";
                System.out.println(message);
            } else {
                sugar = typedSugar;
            }
        }
    }

    public void makeDrinkExtraHot() {
        if (!endOfOrder) {
            extraHot = true;
        }
    }

    public void showOrder() {
        if (!endOfOrder) {
            message = "You have ordered a " + drinkType.toString().toLowerCase();

            if (sugar > 0) {
                message += ". With " + sugar + " extra sugar cubes (stick included)";
            }

            if (extraHot) {
                message += ". Extra hot";
            }

            System.out.println(message);
        }
    }

    private void increaseEarningsOf(DrinkType drinkType) {
        switch (drinkType) {
            case TEA:
                totalTeaEarnings += drinkType.price;
                break;
            case COFFEE:
                totalCoffeeEarnings += drinkType.price;
                break;
            case CHOCOLATE:
                totalChocolateEarnings += drinkType.price;
                break;
        }
    }

    public void showMoneyReport() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println("<<< MONEY REPORT >>>");
        System.out.println("DRINK\t\tMONEY");
        System.out.println(DrinkType.TEA + "\t\t\t" + decimalFormat.format(totalTeaEarnings));
        System.out.println(DrinkType.COFFEE + "\t\t" + decimalFormat.format(totalCoffeeEarnings));
        System.out.println(DrinkType.CHOCOLATE + "\t" + decimalFormat.format(totalChocolateEarnings));
    }
}
