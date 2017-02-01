package com.java.Demo;

import java.util.List;

/**
 * Created by rawjyot on 1/25/17.
 */

public class Employee {

    private String emp_Name;
    private int emp_Id;
    private double salary;
    private int age;
    Address local=new Address();






    public static Employee addEmployee(String emp_Name,int emp_Id,double salary,int age)
    {

        Employee employee=new Employee();
        employee.setEmp_Name(emp_Name);
        employee.setEmp_Id(emp_Id);
        employee.setSalary(salary);
        employee.setAge(age);

       return employee;
    }


    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }






}
