package com.java.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/25/17.
 */

public class Department {


    private int dep_id;
    private String deptname;

    List<Project> projectList;



    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
