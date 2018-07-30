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
    private Long id;
    private String bugname;
    private Integer bugtype;
    private String url;
    private String ip;
    private Integer bugrank;
    private String description;
    private Integer submituser;
    private Long date;
    private Integer checkstatus;
    protected Bug(){};

    public Bug(String bugname, Integer bugtype, String url, String ip, Integer bugrank, String description, Integer submituser, Integer checkstatus) {
        this.bugname = bugname;
        this.bugtype = bugtype;
        this.url = url;
        this.ip = ip;
        this.bugrank = bugrank;
        this.description = description;
        this.submituser = submituser;
        this.checkstatus = checkstatus;
        this.date=new Date().getTime();
    }


    public Integer getcheckstatus() {
        return checkstatus;
    }

    public void setcheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
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
        return new FormatedBug(id, bugname, bugtype, url, ip, bugrank, description, submituser, date, checkstatus);
    }
}
