package com.example.demo.event.handler;

import com.example.demo.event.SalaryChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {

    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println(salaryChangeEvent.getEmployee());
        System.out.println("Prev salary value: " + salaryChangeEvent.getPrevSalary());
        System.out.println("Updated salary value: " + salaryChangeEvent.getEmployee().getSalary());
    }
}
