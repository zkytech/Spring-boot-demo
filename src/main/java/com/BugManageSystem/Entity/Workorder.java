package com.BugManageSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bugname;
    private Integer bugtype;
    private Integer bugrank;
    private Long bugid;
    private String ip;
    private String url;
    private Integer handler;
    private Integer soc_recorded;
    private String comment;
    private Long date;

    protected Workorder(){}

    public Workorder(String bugname, Integer bugtype, Integer bugrank, Long bugid, String ip, String url, Integer handler, Integer soc_recorded, String comment, Long date) {
        this.bugname = bugname;
        this.bugtype = bugtype;
        this.bugrank = bugrank;
        this.bugid = bugid;
        this.ip = ip;
        this.url = url;
        this.handler = handler;
        this.soc_recorded = soc_recorded;
        this.comment = comment;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getBugrank() {
        return bugrank;
    }

    public void setBugrank(Integer bugrank) {
        this.bugrank = bugrank;
    }

    public Long getBugid() {
        return bugid;
    }

    public void setBugid(Long bugid) {
        this.bugid = bugid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHandler() {
        return handler;
    }

    public void setHandler(Integer handler) {
        this.handler = handler;
    }

    public Integer getSoc_recorded() {
        return soc_recorded;
    }

    public void setSoc_recorded(Integer soc_recorded) {
        this.soc_recorded = soc_recorded;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
