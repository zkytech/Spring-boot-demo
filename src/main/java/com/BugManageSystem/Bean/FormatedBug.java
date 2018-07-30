package com.BugManageSystem.Bean;

import com.BugManageSystem.Service.GetType;
import com.BugManageSystem.SpringUtils;
import java.text.SimpleDateFormat;
import java.util.*;

public class FormatedBug {
    private GetType getType = SpringUtils.getBean(GetType.class);
    public Long id;
    public String bugname;
    public String bugtype;
    public List<String> url;
    public List<String> ip;
    public String bugrank;
    public String description;
    public Integer submituser;
    public String date;
    public List ip_and_url;
    public String checkstatus;
    protected FormatedBug(){};
    public FormatedBug(Long id, String bugname, Integer bugtype, String url, String ip, Integer bugrank, String description, Integer submituser, Long date, Integer checkstatus) {
        this.id = id;
        this.bugname = bugname;
        this.bugtype= getType.getTypenameById(bugtype);
        this.url =Arrays.asList(url.split("\\|\\|\\|"));
        this.ip = Arrays.asList(ip.split("\\|\\|\\|"));
        System.out.println("size of url:"+this.url.size());
        switch (bugrank){
            case 0:this.bugrank="低危";break;
            case 1:this.bugrank="中危";break;
            case 2:this.bugrank="高危";break;
        }
        this.description = description;
        this.submituser = submituser;
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.date = sdf.format(new Date(date));
        switch (checkstatus){
            case 0:this.checkstatus="待审核";break;
            case 1:this.checkstatus="已审核";break;
            case 2:this.checkstatus="已拒绝";break;
        }

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

    public String getBugtype() {
        return bugtype;
    }

    public void setBugtype(Integer bugtype) {
        this.bugtype= getType.getTypenameById(bugtype);
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(String url) { this.url =Arrays.asList(url.split("\\|\\|\\|")); }

    public List<String> getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = Arrays.asList(ip.split("\\|\\|\\|"));
    }

    public String getBugrank() {
        return bugrank;
    }

    public void setBugrank(Integer bugrank) {
        switch (bugrank){
            case 0:this.bugrank="低危";break;
            case 1:this.bugrank="中危";break;
            case 2:this.bugrank="高危";break;
        }
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.date = sdf.format(new Date(date));
    }
}
