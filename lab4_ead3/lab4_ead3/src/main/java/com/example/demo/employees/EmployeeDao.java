package com.example.demo.employees;

import com.example.demo.database.MyDatabase;
import com.example.demo.database.TableName;
import com.example.demo.event.SalaryChangeEvent;
import com.example.demo.services.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class EmployeeDao implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;
    private MyDatabase database;
    private Scanner sc = new Scanner(System.in);

    @Autowired
    public void setDatabase(MyDatabase database) {
        this.database = database;
    }

    public void updateSalaryForAll(ArrayList<SalariedEmployee> list, TableName tableName) {
        Double percent = 0.0;
        Double newWorkingSalary = 0.0;
        Double newBaseSalary = 0.0;
        String sql2 = "";

        if (tableName == TableName.hourly_employees) {
            System.out.print("new working salary: ");
            newWorkingSalary = sc.nextDouble();
            sql2 = ", workingSalary = " + newWorkingSalary;
        } else if (tableName == TableName.salaried_commission_employees) {
            System.out.print("new base salary: ");
            newBaseSalary = sc.nextDouble();
        } else {
            System.out.print("enter percent: ");
            percent = sc.nextDouble();
        }

        for (int i = 0; i < list.size(); i++) {
            SalariedEmployee employee = list.get(i);
            Double prevSalary = employee.getSalary();
            Double newSalary = 0.0;

            if (tableName == TableName.hourly_employees) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                if (hourlyEmployee.getWorkingHours() <= 40) {
                    newSalary = hourlyEmployee.getWorkingHours() * newWorkingSalary;
                } else {
                    newSalary = newWorkingSalary * 40 + newWorkingSalary * (hourlyEmployee.getWorkingHours() - 40.0);
                }
            } else if (tableName == TableName.salaried_commission_employees) {
                SalariedCommissionEmployee salariedCommissionEmployee = (SalariedCommissionEmployee) employee;
                newSalary = salariedCommissionEmployee.getBonusSalary() + newBaseSalary;
            } else {
                newSalary = prevSalary + (prevSalary * percent) / 100.0;
            }

            employee.setSalary(newSalary);

            String sql = "UPDATE " + tableName.toString() + " SET salary = " + employee.getSalary() + sql2 + " WHERE id = " + employee.getId();
            database.updateData(sql);
            this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee, prevSalary));
        }
    }

    public void updateSalary(ArrayList<SalariedEmployee> list, TableName tableName) {
        String sql2 = "";
        Double newSalary;
        Double newWorkingSalary;
        Double saleSum;
        Double newBaseSalary;

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ") " + list.get(i).getFullName());
        }
        System.out.print("enter employee: ");
        int i = sc.nextInt();
        SalariedEmployee employee = list.get(i);
        Double prevSalary = employee.getSalary();

        if (tableName == TableName.hourly_employees) {
            System.out.print("new working salary: ");
            newWorkingSalary = sc.nextDouble();
            sql2 = ", workingSalary = " + newWorkingSalary;

            HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
            if (hourlyEmployee.getWorkingHours() <= 40) {
                newSalary = hourlyEmployee.getWorkingHours() * newWorkingSalary;
            } else {
                newSalary = newWorkingSalary * 40 + newWorkingSalary * (hourlyEmployee.getWorkingHours() - 40.0);
            }
        } else if (tableName == TableName.commission_employees) {
            System.out.print("input sale sum: ");
            saleSum = sc.nextDouble();
            CommissionEmployee commissionEmployee = (CommissionEmployee) employee;
            newSalary = saleSum * commissionEmployee.getPaidPercent() / 100;
        } else if (tableName == TableName.salaried_commission_employees) {
            System.out.print("new base salary: ");
            newBaseSalary = sc.nextDouble();
            SalariedCommissionEmployee salariedCommissionEmployee = (SalariedCommissionEmployee) employee;
            newSalary = salariedCommissionEmployee.getBonusSalary() + newBaseSalary;
        } else {
            System.out.print("enter new salary: ");
            newSalary = sc.nextDouble();
        }

        employee.setSalary(newSalary);

        String sql = "UPDATE " + tableName.toString() + " SET salary = " + employee.getSalary() + sql2 + " WHERE id = " + employee.getId();
        database.updateData(sql);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee, prevSalary));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
