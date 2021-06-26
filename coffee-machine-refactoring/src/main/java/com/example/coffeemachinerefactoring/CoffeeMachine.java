package com.example.coffeemachinerefactoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoffeeMachine {

    private DrinkType drinkType;
    private float money;
    private int sugar;
    private boolean extraHot;


    public void validate(String chosenDrinkType) {
        switch (chosenDrinkType.toUpperCase()) {
            case "COFFEE":
                drinkType = DrinkType.COFFEE;
                System.out.println(getDrinkType());
                break;
            case "CHOCOLATE":
                drinkType = DrinkType.CHOCOLATE;
                System.out.println(getDrinkType());
                break;
            case "TEA":
                drinkType = DrinkType.TEA;
                System.out.println(getDrinkType());
                break;
            default:
                System.out.println("The drink type should be tea, coffee or chocolate.");
        }
    }
}
