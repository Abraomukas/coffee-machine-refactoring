package com.example.coffeemachinerefactoring.service;

import com.example.coffeemachinerefactoring.CoffeeMachine;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CoffeeMachineService {

    private CoffeeMachine coffeeMachine;

    public void startCoffeeMachine() {
        coffeeMachine = new CoffeeMachine();
        showMenu();
    }

    public void getMoneyReport() {
        System.out.println("Money report!");
    }

    private void showMenu() {
        System.out.println("<<< WELCOME TO THE REFACTORED COFFEE MACHINE >>>");
        showDrinkTypeMenu();
        showMoneyMenu();
    }

    private void showDrinkTypeMenu() {
        System.out.println("<<< Please type your order: >>>");
        System.out.println("<<< (Today we have coffee, chocolate and tea) >>>");

        Scanner scanner = new Scanner(System.in);
        String chosenDrinkType = scanner.next();
        scanner.close();

        coffeeMachine.validate(chosenDrinkType);
    }

    private void showMoneyMenu() {
    }
}
