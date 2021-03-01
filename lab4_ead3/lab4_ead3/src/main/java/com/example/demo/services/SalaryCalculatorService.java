package com.example.demo.services;

import com.example.demo.database.MyDatabase;
import com.example.demo.database.TableName;
import com.example.demo.employees.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class SalaryCalculatorService {
    private MyDatabase database;
    private EmployeeDao employeeDao;

    @Autowired
    public void setDatabase(MyDatabase database) {
        this.database = database;
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void updateSalarySalariedForAll() {
        String sql = "SELECT * FROM " + TableName.salaried_employees.toString();
        ArrayList<SalariedEmployee> list = new ArrayList<>();
        ResultSet resultSet = database.getData(sql);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                Double salary = resultSet.getDouble("salary");
                list.add(new SalariedEmployee(id, name, salary));
            }
        } catch (SQLException sqlE) {
            System.out.println("ERROR!");
            System.out.println(sqlE);
        }

        employeeDao.updateSalaryForAll(list, TableName.salaried_employees);
    }

    public void updateSalarySalaried() {
        String sql = "SELECT * FROM " + TableName.salaried_employees.toString();
        ArrayList<SalariedEmployee> list = new ArrayList<>();
        ResultSet resultSet = database.getData(sql);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                Double salary = resultSet.getDouble("salary");
                list.add(new SalariedEmployee(id, name, salary));
            }
        } catch (SQLException sqlE) {
            System.out.println("ERROR!");
            System.out.println(sqlE);
        }

        employeeDao.updateSalary(list, TableName.salaried_employees);
    }

    public void updateSalaryHourlyForAll() {
        String sql = "SELECT * FROM " + TableName.hourly_employees.toString();
        ArrayList<SalariedEmployee> list = new ArrayList<>();
        ResultSet resultSet = database.getData(sql);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                Double salary = resultSet.getDouble("salary");
                Integer workingHours = resultSet.getInt("workingHours");
                Double workingSalary = resultSet.getDouble("workingSalary");
                list.add(new HourlyEmployee(id, name, salary, workingHours, workingSalary));
            }
        } catch (SQLException sqlE) {
            System.out.println("ERROR!");
            System.out.println(sqlE);
        }

        employeeDao.updateSalaryForAll(list, TableName.hourly_employees);
    }

    public void updateSalaryHourly() {
        String sql = "SELECT * FROM " + TableName.hourly_employees.toString();
        ArrayList<SalariedEmployee> list = new ArrayList<>();
        ResultSet resultSet = database.getData(sql);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                Double salary = resultSet.getDouble("salary");
                Integer workingHours = resultSet.getInt("workingHours");
                Double workingSalary = resultSet.getDouble("workingSalary");
                list.add(new HourlyEmployee(id, name, salary, workingHours, workingSalary));
            }
        } catch (SQLException sqlE) {
            System.out.println("ERROR!");
            System.out.println(sqlE);
        }

        employeeDao.updateSalary(list, TableName.hourly_employees);
    }

    public void updateSalaryCommission() {
        String sql = "SELECT * FROM " + TableName.commission_employees.toString();
        ArrayList<SalariedEmployee> list = new ArrayList<>();
        ResultSet resultSet = database.getData(sql);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                Double salary = resultSet.getDouble("salary");
                Double paidPercent = resultSet.getDouble("paidPercent");
                list.add(new CommissionEmployee(id, name, salary, paidPercent));
            }
        } catch (SQLException sqlE) {
            System.out.println("ERROR!");
            System.out.println(sqlE);
        }

        employeeDao.updateSalary(list, TableName.commission_employees);
    }

    public void updateSalarySalariedCommissionForAll() {
        String sql = "SELECT * FROM " + TableName.salaried_commission_employees.toString();
        ArrayList<SalariedEmployee> list = new ArrayList<>();
        ResultSet resultSet = database.getData(sql);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                Double salary = resultSet.getDouble("salary");
                Double paidPercent = resultSet.getDouble("paidPercent");
                Double bonusSalary = resultSet.getDouble("bonusSalary");
                list.add(new SalariedCommissionEmployee(id, name, salary, paidPercent, bonusSalary));
            }
        } catch (SQLException sqlE) {
            System.out.println("ERROR!");
            System.out.println(sqlE);
        }

        employeeDao.updateSalaryForAll(list, TableName.salaried_commission_employees);
    }

    public void updateSalarySalariedCommission() {
        String sql = "SELECT * FROM " + TableName.salaried_commission_employees.toString();
        ArrayList<SalariedEmployee> list = new ArrayList<>();
        ResultSet resultSet = database.getData(sql);

        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("full_name");
                Double salary = resultSet.getDouble("salary");
                Double paidPercent = resultSet.getDouble("paidPercent");
                Double bonusSalary = resultSet.getDouble("bonusSalary");
                list.add(new SalariedCommissionEmployee(id, name, salary, paidPercent, bonusSalary));
            }
        } catch (SQLException sqlE) {
            System.out.println("ERROR!");
            System.out.println(sqlE);
        }

        employeeDao.updateSalary(list, TableName.salaried_commission_employees);
    }
}
