package com.zkytech.DataBaseIO_Example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    protected User(){}

    public User(String name, String email){
        this.name=name;
        this.email=email;
    }

    @Override
    public String toString(){
        return String.format(
                "User[id=%d, name='%s', email='%s']",id,name,email);
    }
}
