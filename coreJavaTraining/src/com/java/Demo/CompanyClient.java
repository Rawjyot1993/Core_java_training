package com.java.Demo;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rawjyot on 1/25/17.
 */

public class CompanyClient {






    public static void main(String[] args) {



//Adding Departments Through Comapny Object into Department List <Departments>

     Company user1 = new Company("Appdirect",80000);
        List<Department> departments=new ArrayList<>();
        user1.addDepartemnt(123,"Hr");
        user1.addDepartemnt(234,"Admin");
        user1.addDepartemnt(456,"Finance");
        user1.addDepartemnt(789,"It");
        user1.setDepartmentList(departments);



//Adding Departments through Department Object into Department List <Departments>

     Department department=new Department();
     department.setDep_id(10);
     department.setDeptname("HR");

     Department department1=new Department();
     department1.setDep_id(12);
     department1.setDeptname("Admin");

     Department department2=new Department();
     department2.setDep_id(14);
     department2.setDeptname("Finance");

     departments.add(department);
     departments.add(department1);
     departments.add(department2);

//Iterating Departments through Department List through <ADVANCE FOR LOOP OR FOR-EACH LOOP >.

       for (Department values:departments)
        {
            System.out.println("Department");
            System.out.println("*******************************");
            System.out.println("Department-ID  Department-Name");
            System.out.print(values.getDep_id() +"\t\t\t\t");
            System.out.println(values.getDeptname());
            System.out.println("*******************************");
        }


//Adding Projects into ProjectList through Static Method <addProject>

        List<Project> projectList=new ArrayList<>();
        Project project=Project.addProject(12,"P305");
        Project project1=Project.addProject(14,"P307");
        Project project2=Project.addProject(16,"P308");
        Project project3=Project.addProject(18,"P309");
        projectList.add(project);
        projectList.add(project1);
        projectList.add(project2);
        projectList.add(project3);

//Iteration of Project with <FOR LOOP>
        for(int i=0;i<projectList.size();i++)
        {
            System.out.println(projectList.get(i).getPro_code());
            System.out.println(projectList.get(i).getPro_id());


        }

//Setting Project List into Department Class.

        Department depar_name=new Department();
        depar_name.setProjectList(projectList);

//Iterating Projects through ITERATOR  Project List.

        for (Project values: projectList)
        {
            System.out.println("Project");
            System.out.println("*******************************");
            System.out.println("Project-ID  Project-Name");
            System.out.print(values.getPro_id() + "\t\t\t");
            System.out.println(values.getPro_code());
            System.out.println("*******************************");
        }





//Creating Employee List
        List<Employee> employeeList=new ArrayList<>();

        Employee employee=Employee.addEmployee("Rawjyot",101,1500000.00,23);
        Employee employee1=Employee.addEmployee("Arsdeep",102,1500000.00,21);
        Employee employee2=Employee.addEmployee("Natesh",103,1500000.00,25);
        Employee employee3=Employee.addEmployee("Sandeep",103,1500000.00,24);
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);


//Iterating through <WHILE LOOP>


        int i=0;

        while(i<employeeList.size())
        {

            System.out.println(employeeList.get(i).getEmp_Name());
            System.out.println(employeeList.get(i).getAge());
            System.out.println(employeeList.get(i).getEmp_Id());
            System.out.println(employeeList.get(i).getSalary());
            i++;
        }



//Iterating Employee List Through   <Iterator>

        Iterator<Employee> iterator= employeeList.iterator();
        while (iterator.hasNext())
        {
            Employee elements=iterator.next();
            System.out.println(elements.getEmp_Name());
            System.out.println(elements.getEmp_Id());
            System.out.println(elements.getSalary());
            System.out.println(elements.getAge());
            System.out.println("\n");

        }


//Setting EmployeeList into Project Class.

         Project project_details=new Project();
         project_details.setEmployeeList(employeeList);


//Iterating Department List nested Iterator for Project again nested Iterator for Employee


        for (Department values: departments) {

            System.out.print(values.getDep_id() + " - > ");
            System.out.println(values.getDeptname());

            for (Project values1 : projectList) {
                System.out.print(values1.getPro_id() + " - > ");
                System.out.println(values1.getPro_code());
            }

            for (Employee values2 : employeeList) {

                System.out.print(values2.getEmp_Id() + " - > ");
                System.out.print(values2.getEmp_Name() + "- >");
                System.out.print(values2.getAge() + " - > ");
                System.out.print(values2.getSalary() + "->");

            }





        }



    }
}







