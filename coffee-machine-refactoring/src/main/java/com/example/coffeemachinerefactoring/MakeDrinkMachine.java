package com.example.coffeemachinerefactoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MakeDrinkMachine {

    private DrinkType drinkType;
    private double money;
    private int sugar;
    private boolean extraHot;
    private String message;
    private boolean endOfOrder;


    public void validateDrinkType(String typedDrinkType) {
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
                message = "The " + drinkType.toString().toLowerCase() + " costs " + drinkType.price + ".";
                System.out.println(message);
                endOfOrder = true;
            } else {
                money = typedMoney;
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
                message += " with " + sugar + " extra sugar cubes (stick included).";
            }

            if (extraHot) {
                message += " Extra hot.";
            }
        }

        System.out.println(message);
    }
}
