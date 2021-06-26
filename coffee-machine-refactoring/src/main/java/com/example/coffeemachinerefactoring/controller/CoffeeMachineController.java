package com.example.coffeemachinerefactoring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/coffee")
public class CoffeeMachineController {

    private final CoffeeMachineService service;

    @GetMapping("/")
    public void startCoffeeMachine() {
        return service.startCoffeeMachine();
    }

    @GetMapping("/money")
    public void getMoneyReport() {
        return service.getMoneyReport();
    }

}
