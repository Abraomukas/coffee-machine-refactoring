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
                System.out.println(message);
        }
    }

    public void validaTePrice(double typedMoney) {
        if (typedMoney < drinkType.price) {
            message = "The " + drinkType.toString().toLowerCase() + " costs " + drinkType.price + ".";
            System.out.println(message);
        } else {
            money = typedMoney;
        }
    }

    public void validateExtraSugar(int typedSugar) {
        if (typedSugar > 2) {
            message = "The number of extra sugar cubes should be either 1 or 2.";
            System.out.println(message);
        } else {
            sugar = typedSugar;
        }
    }

    public void makeDrinkExtraHot() {
        extraHot = true;
    }

    public void showOrder() {
        message = "You have ordered a " + drinkType.toString().toLowerCase();

        if (sugar > 0) {
            message += " with " + sugar + " extra sugar cubes (stick included).";
        }

        if (extraHot) {
            message += " Extra hot.";
        }

        System.out.println(message);
    }
}
