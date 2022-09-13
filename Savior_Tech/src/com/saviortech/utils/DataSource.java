/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author freec
 */
public class DataSource {

    private static DataSource instance;
    private Connection cnx;

    private final String URL = "jdbc:mysql://localhost:3306/savior_tech_db?useTimezone=true&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
//    private final String URL = "jdbc:mysql://db4free.net/:3306/savior_tech_db?useTimezone=true&serverTimezone=UTC";
//    private final String USERNAME = "saviortech";
//    private final String PASSWORD = "stpassword";

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to MySQL DB Successfully !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static DataSource getIstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getCnx() {
        System.out.println("LOADING...");
        return cnx;
    }
}
