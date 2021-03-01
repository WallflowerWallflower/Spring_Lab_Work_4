package com.example.demo.event;

import com.example.demo.employees.SalariedEmployee;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {
    private SalariedEmployee employee;
    private Double prevSalary;

    public SalaryChangeEvent(Object source, SalariedEmployee employee, Double oldSalary) {
        super(source);
        this.employee = employee;
        this.prevSalary = oldSalary;
    }

    public SalariedEmployee getEmployee() {
        return employee;
    }

    public Double getPrevSalary() {
        return prevSalary;
    }
}
