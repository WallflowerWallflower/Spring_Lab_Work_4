package com.example.demo.employees;

public class CommissionEmployee extends SalariedEmployee {
    private Double paidPercent;

    public CommissionEmployee() {}

    public CommissionEmployee(Integer id, String fullName, Double salary, Double paidPercent) {
        super(id, fullName, salary);
        this.paidPercent = paidPercent;
    }

    public Double getPaidPercent() {
        return paidPercent;
    }
}
