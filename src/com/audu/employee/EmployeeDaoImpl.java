package com.audu.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        String query = "insert into employee values (?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, emp.getId());
            pstm.setString(2, emp.getName());
            pstm.setDouble(3, emp.getSalary());
            pstm.setInt(4, emp.getAge());
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Employee Inserted Successfully..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "select * from employee";
        System.out.println("Employee Details : ");
        System.out.println("------------------------------------------------------");
        System.out.format("%-10s%-20s%-15s%-10s\n", "ID", "Name", "Salary", "Age");
        System.out.println("------------------------------------------------------");

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%-10d%-20s%-15.2f%-10d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4)
                );
            }
            System.out.println("------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDBConnection();
        String query = "select * from employee where id=" + id;
        System.out.println("Employee Details : ");
        System.out.println("------------------------------------------------------");
        System.out.format("%-10s%-20s%-15s%-10s\n", "ID", "Name", "Salary", "Age");
        System.out.println("------------------------------------------------------");

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%-10d%-20s%-15.2f%-10d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4)
                );
            }
            System.out.println("------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "update employee set name=? where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Details updated successfully!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployeeSalary(int id, Double salary) {
        con = DBConnection.createDBConnection();
        String query = "UPDATE employee SET salary=? WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setDouble(1, salary);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee salary updated successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployeeAge(int id, int age) {
        con = DBConnection.createDBConnection();
        String query = "UPDATE employee SET age=? WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, age);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee age updated successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "delete from employee where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Deleted Successfully!!! " + id);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
