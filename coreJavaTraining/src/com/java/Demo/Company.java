package com.java.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/25/17.
 */


public class Company {

   private String name;
   private int comp_Id;
    List<Department> departmentList;



    public Company(String name,int comp_Id)
    {
        departmentList=new ArrayList<>();
        this.comp_Id=comp_Id;
        this.name=name;
    }
    public Company()
    {





    }



    public static Company getInstance()
    {
        Company d=new Company();

         return d;
    }

    public void addDepartemnt(int dep_id,String deptname)
    {


        Department departments=new Department();
        departments.setDep_id(dep_id);
        departments.setDeptname(deptname);
        departmentList.add(departments);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComp_Id() {
        return comp_Id;
    }

    public void setComp_Id(int comp_Id) {
        this.comp_Id = comp_Id;
    }

     public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}

