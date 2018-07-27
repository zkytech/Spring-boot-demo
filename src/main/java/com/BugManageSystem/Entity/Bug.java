package com.BugManageSystem.Entity;

import com.BugManageSystem.Bean.FormatedBug;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String bugname;
    public Integer bugtype;
    public String url;
    public String ip;
    public Integer bugrank;
    public String description;
    public Integer submituser;
    public Long date;
    protected Bug(){};

    public Bug(String bugname, Integer bugtype, String url, String ip, Integer bugrank, String description, Integer submituser) {
        this.bugname = bugname;
        this.bugtype = bugtype;
        this.url = url;
        this.ip = ip;
        this.bugrank = bugrank;
        this.description = description;
        this.submituser = submituser;
        this.date=new Date().getTime();
    }


    public String getBugname() {
        return bugname;
    }

    public void setBugname(String bugname) {
        this.bugname = bugname;
    }

    public Integer getBugtype() {
        return bugtype;
    }

    public void setBugtype(Integer bugtype) {
        this.bugtype = bugtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getBugrank() {
        return bugrank;
    }

    public void setBugrank(Integer bugrank) {
        this.bugrank = bugrank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSubmituser() {
        return submituser;
    }

    public void setSubmituser(Integer submituser) {
        this.submituser = submituser;
    }

    public Long getDate() {
        return date;
    }

    public Long getId(){return id;}

    @Override
    public String toString(){
        return String.format("bug[id=%d, bugname=%s, bugtype=%d, url=%s, ip=%s, bugrank=%d, description=%s, submituser=%d, date=%d]",id, bugname, bugtype,url,ip, bugrank,description, submituser,date);
    }

    public FormatedBug getFormatedBug(){
        return new FormatedBug(id, bugname, bugtype, url, ip, bugrank, description, submituser, date);
    }
}
