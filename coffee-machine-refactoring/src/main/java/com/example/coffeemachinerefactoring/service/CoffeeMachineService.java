package com.example.coffeemachinerefactoring.service;

import com.example.coffeemachinerefactoring.MakeDrinkMachine;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CoffeeMachineService {

    private final MakeDrinkMachine makeDrinkMachine = new MakeDrinkMachine();

    public void startCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("<<< WELCOME TO THE REFACTORED COFFEE MACHINE! >>>");
        System.out.println();
        showMenu(scanner);

        scanner.close();
    }

    public void getMoneyReport() {
        makeDrinkMachine.showMoneyReport();
    }

    private void showMenu(Scanner scanner) {
        showDrinkTypeMenu(scanner);
        showMoneyMenu(scanner);
        showSugarMenu(scanner);
        showExtraHotMenu(scanner);

        if (!makeDrinkMachine.isEndOfOrder()) {
            makeDrinkMachine.showOrder();
        }

        newOrder(scanner);
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
        if (!makeDrinkMachine.isEndOfOrder()) {
            System.out.println("<<< Would you like some sugar in your drink? >>>");
            System.out.println("<<< (Type Y for YES or anything else for NO) >>>");

            String wantsSugar = scanner.next();

            if (wantsSugar.equalsIgnoreCase("Y")) {
                System.out.println("<<< How much extra sugar do you want? >>>");
                System.out.println("<<< (Today we add 1 or 2 extra sugar cubes) >>>");

                int typedSugar = scanner.nextInt();

                makeDrinkMachine.validateExtraSugar(typedSugar);
            }
        }
    }

    private void showExtraHotMenu(Scanner scanner) {
        if (!makeDrinkMachine.isEndOfOrder()) {
            System.out.println("<<< Would you like your drink to be extra hot? >>>");
            System.out.println("<<< (Type Y for YES or anything else for NO) >>>");

            String wantsExtraHot = scanner.next();

            if (wantsExtraHot.equalsIgnoreCase("Y")) {
                makeDrinkMachine.makeDrinkExtraHot();
            }
        }
    }

    private void newOrder(Scanner scanner) {
        System.out.println();
        System.out.println("<<< Would you like to order another drink? >>>");
        System.out.println("<<< (Type Y for YES or anything else for NO) >>>");

        String typedOption = scanner.next();
        if (typedOption.equalsIgnoreCase("Y")) {
            showMenu(scanner);
        } else {
            System.out.println();
            System.out.println("<<< THANK YOU FOR USING THE REFACTORED COFFEE MACHINE! >>>");
            System.out.println("<<< HAVE A NICE DAY! >>>");
        }
    }
}
