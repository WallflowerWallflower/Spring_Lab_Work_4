package com.example.demo.employees;

public class HourlyEmployee extends SalariedEmployee {
    private Integer workingHours;
    private Double workingSalary;

    public HourlyEmployee() {}

    public HourlyEmployee(Integer id, String fullName, Double salary, Integer workingHours, Double workingSalary) {
        super(id, fullName, salary);
        this.workingHours = workingHours;
        this.workingSalary = workingSalary;
    }

    public Double getWorkingSalary() {
        return workingSalary;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }
}
