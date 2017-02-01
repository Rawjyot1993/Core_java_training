package com.java.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/25/17.
 */

public class Project {

     private int pro_id;
     private String pro_code;
    List<Employee> employeeList;

    public String getPro_code() {
        return pro_code;
    }

    public void setPro_code(String pro_code) {
        this.pro_code = pro_code;
    }

    public static Project addProject(int pro_id, String pro_code)
    {

        Project project=new Project();
        project.setPro_id(pro_id);
        project.setPro_code(pro_code);
        return project;
    }


    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
