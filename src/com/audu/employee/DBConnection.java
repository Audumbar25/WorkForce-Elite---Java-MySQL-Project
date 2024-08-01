package com.audu.employee;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection createDBConnection() {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get connection
            String url = "jdbc:mysql://localhost:3306/employeeDB";
            String username = "root";
            String password = "Audumbar@12345";
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}
