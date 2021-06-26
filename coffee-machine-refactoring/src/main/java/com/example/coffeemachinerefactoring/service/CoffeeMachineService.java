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

        scanner.close();
    }

    public void getMoneyReport() {
        System.out.println("Money report!");
    }

    private void showMenu(Scanner scanner) {
        System.out.println("<<< WELCOME TO THE REFACTORED COFFEE MACHINE >>>");
        showDrinkTypeMenu(scanner);
        showMoneyMenu(scanner);
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
}
