package com.BugManageSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String bugtype;

    protected Types(){}
    public Types(String bugtype) {
        this.bugtype = bugtype;
    }

    public String getBugtype() {
        return bugtype;
    }

    @Override
    public String toString(){
        return String.format("Types[id=%d, bugType=%s]",id,bugtype);
    }
}
