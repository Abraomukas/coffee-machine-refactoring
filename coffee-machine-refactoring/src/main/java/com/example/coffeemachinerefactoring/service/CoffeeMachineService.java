package com.example.coffeemachinerefactoring.service;

import com.example.coffeemachinerefactoring.MakeDrinkMachine;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CoffeeMachineService {

    private MakeDrinkMachine makeDrinkMachine;

    public void startCoffeeMachine() {
        makeDrinkMachine = new MakeDrinkMachine();
        Scanner scanner = new Scanner(System.in);

        showMenu(scanner);
        makeDrinkMachine.showOrder();

        scanner.close();
    }

    public void getMoneyReport() {
        System.out.println("Money report!");
    }

    private void showMenu(Scanner scanner) {
        System.out.println("<<< WELCOME TO THE REFACTORED COFFEE MACHINE >>>");
        showDrinkTypeMenu(scanner);
        showMoneyMenu(scanner);
        showSugarMenu(scanner);
        showExtraHotMenu(scanner);
    }

    private void showDrinkTypeMenu(Scanner scanner) {
        System.out.println("<<< Please type your order: >>>");
        System.out.println("<<< (Today we have coffee, chocolate and tea) >>>");

        String typedDrinkType = scanner.next();

        makeDrinkMachine.validateDrinkType(typedDrinkType);
    }

    private void showMoneyMenu(Scanner scanner) {
        System.out.println("<<< Please insert your payment: >>>");

        double typedMoney = scanner.nextDouble();

        makeDrinkMachine.validaTePrice(typedMoney);
    }

    private void showSugarMenu(Scanner scanner) {
        System.out.println("<<< Would you like some sugar in your drink? >>>");
        System.out.println("<<< (Type Y for YES or N for NO) >>>");

        String wantsSugar = scanner.next();

        if (wantsSugar.toUpperCase().equals("Y")) {
            System.out.println("<<< How much extra sugar do you want? >>>");
            System.out.println("<<< (Today we add 1 or 2 extra sugar cubes) >>>");

            int typedSugar = scanner.nextInt();

            makeDrinkMachine.validateExtraSugar(typedSugar);
        }
    }

    private void showExtraHotMenu(Scanner scanner) {
        System.out.println("<<< Would you like your drink to be extra hot? >>>");
        System.out.println("<<< (Type Y for YES or N for NO) >>>");

        String wantsExtraHot = scanner.next();

        if (wantsExtraHot.toUpperCase().equals("Y")) {
            makeDrinkMachine.makeDrinkExtraHot();
        }
    }
}
