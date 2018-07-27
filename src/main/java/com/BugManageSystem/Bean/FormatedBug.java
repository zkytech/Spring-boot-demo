package com.BugManageSystem.Bean;

import com.BugManageSystem.Service.GetType;
import com.BugManageSystem.SpringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FormatedBug {
    private GetType getType = SpringUtils.getBean(GetType.class);
    public Long id;
    public String bugname;
    public String bugtype;
    public String url;
    public String ip;
    public String bugrank;
    public String description;
    public Integer submituser;
    public String date;
    protected FormatedBug(){};
    public FormatedBug(Long id, String bugname, Integer bugtype, String url, String ip, Integer bugrank, String description, Integer submituser, Long date) {


        this.id = id;
        this.bugname = bugname;

        System.out.println(getType.getTypenameById(bugtype));
        this.bugtype= getType.getTypenameById(bugtype);
        this.url = url;
        this.ip = ip;
        switch (bugrank){
            case 0:this.bugrank="低危";
            case 1:this.bugrank="中危";
            case 2:this.bugrank="高危";
        }
        this.description = description;
        this.submituser = submituser;
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.date = sdf.format(new Date(date));

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

//    public void setBugtype(Integer bugtype) {
//        Types types_s = typesRepository.findTypesById(bugtype);
//        this.bugtype = bugtype;
//    }

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

    public String getBugrank() {
        return bugrank;
    }

    public void setBugrank(Integer bugrank) {
        switch (bugrank){
            case 0:this.bugrank="低危";
            case 1:this.bugrank="中危";
            case 2:this.bugrank="高危";
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
