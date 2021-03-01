package com.example.demo;

import com.example.demo.services.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        PayrollSystem payrollSystem = context.getBean("payrollSystem", PayrollSystem.class);
        payrollSystem.start();
    }
}
