package com.example.demo.employees;

public class SalariedCommissionEmployee extends SalariedEmployee {
    private Double paidPercent;
    private Double bonusSalary;

    public SalariedCommissionEmployee(Integer id, String fullName, Double salary, Double paidPercent, Double bonusSalary) {
        super(id, fullName, salary);
        this.paidPercent = paidPercent;
        this.bonusSalary = bonusSalary;
    }

    public Double getPaidPercent() {
        return paidPercent;
    }

    public Double getBonusSalary() {
        return bonusSalary;
    }
}
