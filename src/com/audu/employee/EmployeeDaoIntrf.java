package com.audu.employee;

public interface EmployeeDaoIntrf {

    public void createEmployee(Employee emp);

    public void showAllEmployee();

    public void showEmployeeBasedOnID(int id);

    public void updateEmployee(int id,String name);

    public void deleteEmployee(int id);

    public void updateEmployeeSalary(int empId, Double salary);

    public void updateEmployeeAge(int empId, int age);
}
