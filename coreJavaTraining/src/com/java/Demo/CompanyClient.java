package com.java.Demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rawjyot on 1/25/17.
 */

public class CompanyClient {


    public static void main(String[] args) {


     Company user1 = new Company("Appdirect",80000);
      List<Department> departments=new ArrayList<>();



/*
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

     */



        user1.addDepartemnt(123,"Hr");
        user1.addDepartemnt(234,"Admin");
        user1.addDepartemnt(456,"Finance");
        user1.addDepartemnt(789,"It");












        user1.setDepartmentList(departments);

      /*  for (Department values:departments)
        {
            System.out.println("Department");
            System.out.println("*******************************");
            System.out.println("Department-ID  Department-Name");
            System.out.print(values.getDep_id() +"\t\t\t\t");
            System.out.println(values.getDeptname());
            System.out.println("*******************************");
        }*/



        List<Project> projectList=new ArrayList<>();

        Project project=Project.addProject(12,"P305");
        Project project1=Project.addProject(14,"P307");
        Project project2=Project.addProject(16,"P308");
        Project project3=Project.addProject(18,"P309");
        projectList.add(project);
        projectList.add(project1);
        projectList.add(project2);
        projectList.add(project3);


        Department depar_name=new Department();
        depar_name.setProjectList(projectList);


       /* for (Project values: projectList)
        {
            System.out.println("Project");
            System.out.println("*******************************");
            System.out.println("Project-ID  Project-Name");
            System.out.print(values.getPro_id() + "\t\t\t");
            System.out.println(values.getPro_code());
            System.out.println("*******************************");
        }*/






        List<Employee> employeeList=new ArrayList<>();


        Employee employee=Employee.addEmployee("Rawjyot",101,1500000.00,23);
        Employee employee1=Employee.addEmployee("Arsdeep",102,1500000.00,21);
        Employee employee2=Employee.addEmployee("Natesh",103,1500000.00,25);
        Employee employee3=Employee.addEmployee("Sandeep",103,1500000.00,24);
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

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

         Project project_details=new Project();
         project_details.setEmployeeList(employeeList);





        /*for (Employee values:employeeList
             ) {
            System.out.println("Employee Data");
            System.out.println("*******************************");
            System.out.println("Employee - Id:"+values.getEmp_Id()+"   Employee-Name:"+values.getEmp_Name()+"   Employee-Salary:"+values.getSalary()+"   Employee-Age:"+values.getAge());
            System.out.println("*******************************");


        }*/
       // Company user2=new Company();

      /*  for (Department values: departments)
        {

            System.out.print(values.getDep_id() +" - > ");
            System.out.println(values.getDeptname());

            for (Project values1 : projectList)
            {
                System.out.print(values1.getPro_id() +" - > ");
                System.out.println(values1.getPro_code());
            }

             for(Employee values2 : employeeList)
             {

                 System.out.print(values2.getEmp_Id() +" - > ");
                 System.out.print(values2.getEmp_Name() + "- >");
                 System.out.print(values2.getAge() +" - > ");
                 System.out.print(values2.getSalary() + "->");

             }*/





         for (Department department: user1.getDepartmentList())
         {


             System.out.println(department.getDeptname());
             System.out.println(department.getDep_id());



         }





        }



    }



