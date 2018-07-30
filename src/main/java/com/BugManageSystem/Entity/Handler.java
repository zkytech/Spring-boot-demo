package com.BugManageSystem.Entity;

import javax.persistence.*;

@Entity
public class Handler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String phone;
    public String email;
    public Integer department;

    protected Handler() {
    }

    public Handler(String name, String phone, String email, Integer department) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.department=department;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }
}
