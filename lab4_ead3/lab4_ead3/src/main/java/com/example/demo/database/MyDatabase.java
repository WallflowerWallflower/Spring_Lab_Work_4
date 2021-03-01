package com.example.demo.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
public class MyDatabase {
    @Value("${my.database.url}")
    private String url;
    @Value("${my.database.username}")
    private String username;
    @Value("${my.database.password}")
    private String password;
    private Connection connect;

    public MyDatabase() {}

    public MyDatabase(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() throws Exception {
        connect = DriverManager.getConnection(url, username, password);
    }

    public void close() throws Exception {
        connect.close();
    }

    @PostConstruct
    public void init() {
        System.out.println("Init work");
        try {
            connect();
        } catch (Exception ex) {
            System.out.println("SQL ERROR!");
            System.out.println(ex);
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            close();
        } catch (Exception ex) {
            System.out.println("SQL ERROR!");
            System.out.println(ex);
        }
    }

    public ResultSet getData(String sql) {
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException sqlEx) {
            System.out.println("SQL ERROR!");
            System.out.println(sqlEx);
        }
        return resultSet;
    }

    public void updateData(String sql) {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlEx) {
            System.out.println("SQL ERROR!");
            System.out.println(sqlEx);
        }
    }
}
