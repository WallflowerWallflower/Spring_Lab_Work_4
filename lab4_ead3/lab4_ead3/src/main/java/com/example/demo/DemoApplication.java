package com.example.demo;

import com.example.demo.services.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        PayrollSystem payrollSystem = context.getBean("payrollSystem", PayrollSystem.class);
        payrollSystem.start();
    }

}
