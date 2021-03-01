package com.example.demo;

import com.example.demo.services.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class PayrollSystem {
    private Scanner scanner = new Scanner(System.in);
    private SalaryCalculatorService service;

    @Autowired
    public void setService(SalaryCalculatorService service) {
        this.service = service;
    }

    private void changeSalarySalaried() {
        showFunctionMenu();
        int k = scanner.nextInt();

        if (k == 1) {
            service.updateSalarySalariedForAll();
        } else if (k == 2) {
            service.updateSalarySalaried();
        } else {
            System.out.println("Try again!");
        }
    }

    private void changeSalaryHourly() {
        showFunctionMenu();
        int k = scanner.nextInt();

        if (k == 1) {
            service.updateSalaryHourlyForAll();
        } else if (k == 2) {
            service.updateSalaryHourly();
        } else {
            System.out.println("Try again!");
        }
    }

    private void changeSalaryCommission() {
        service.updateSalaryCommission();
    }

    private void changeSalarySalariedCommission() {
        showFunctionMenu();
        int k = scanner.nextInt();

        if (k == 1) {
            service.updateSalarySalariedCommissionForAll();
        } else if (k == 2) {
            service.updateSalarySalariedCommission();
        } else {
            System.out.println("Try again!");
        }
    }

    private void showMenu() {
        System.out.println("change salary Salaried employees - 1");
        System.out.println("change salary Hourly employees - 2");
        System.out.println("change salary Commission employees - 3");
        System.out.println("change salary Salaried-Commission employees - 4");
        System.out.println("EXIT - 0");
    }

    private void showFunctionMenu() {
        System.out.println("all employees - 1");
        System.out.println("only one employee - 2");
        System.out.print("input: ");
    }

    public void start() {
        while (true) {
            showMenu();
            System.out.print("input: ");
            int k = scanner.nextInt();

            if (k == 1) {
                changeSalarySalaried();
            } else if (k == 2) {
                changeSalaryHourly();
            } else if (k == 3) {
                changeSalaryCommission();
            } else if (k == 4) {
                changeSalarySalariedCommission();
            } else if (k == 0) {
              break;
            } else {
                System.out.println("Try again, input only 1 - 4");
            }
        }
    }
}
