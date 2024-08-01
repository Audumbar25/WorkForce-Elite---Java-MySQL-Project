package com.audu.employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoIntrf dao = new EmployeeDaoImpl();

        System.out.println("Welcome to WorkForce Elite");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee Based on ID\n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n" +
                    "6. Exit");
            System.out.println("\nEnter Choice: ");

            int ch = sc.nextInt();
            System.out.println("\n");
            switch (ch) {
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.println("Enter Salary: ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();
                    emp.setId(id);

                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;

                case 2:
                    dao.showAllEmployee();
                    break;

                case 3:
                    System.out.println("Enter ID to show the details: ");
                    int empid = sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;

                case 4:
                    System.out.println("Enter ID to update the details:");
                    int empId = sc.nextInt();

                    System.out.println("Do you want to update the name? (yes/no)");
                    String updateName = sc.next();
                    String nameUpdate = null;
                    if (updateName.equalsIgnoreCase("yes")) {
                        System.out.println("Enter the new name:");
                        nameUpdate = sc.next();
                    }

                    System.out.println("Do you want to update the salary? (yes/no)");
                    String updateSalary = sc.next();
                    Double salaryUpdate = null;
                    if (updateSalary.equalsIgnoreCase("yes")) {
                        System.out.println("Enter the new salary:");
                        salaryUpdate = sc.nextDouble();
                    }

                    System.out.println("Do you want to update the age? (yes/no)");
                    String updateAge = sc.next();
                    int ageUpdate = -1;
                    if (updateAge.equalsIgnoreCase("yes")) {
                        System.out.println("Enter the new age:");
                        ageUpdate = sc.nextInt();
                    }

                    // Call separate methods to update each field
                    if (nameUpdate != null) {
                        dao.updateEmployee(empId, nameUpdate);
                    }
                    if (salaryUpdate != null) {
                        dao.updateEmployeeSalary(empId, salaryUpdate);
                    }
                    if (ageUpdate != -1) {
                        dao.updateEmployeeAge(empId, ageUpdate);
                    }
                    break;

                case 5:
                    System.out.println("Enter the ID to delete:");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using our application.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter a valid choice!");
            }
        } while (true);
    }
}
