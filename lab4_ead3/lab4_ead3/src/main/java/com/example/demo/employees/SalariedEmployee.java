package com.example.demo.employees;

public class SalariedEmployee {
    private Integer id;
    private String fullName;
    private Double salary;

    public SalariedEmployee() {}

    public SalariedEmployee(Integer id, String fullName, Double salary) {
        this.id = id;
        this.fullName = fullName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "SalariedEmployee {" +
                "id = " + id +
                ", fullName = " + fullName +
                ", salary = " + salary +
                '}';
    }
}
