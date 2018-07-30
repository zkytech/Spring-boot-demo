package com.BugManageSystem.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;

    protected Department(){}

    public Department(String department_name) {
        this.name = department_name;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartment_name() {
        return name;
    }

    public void setDepartment_name(String department_name) {
        this.name = department_name;
    }
}

