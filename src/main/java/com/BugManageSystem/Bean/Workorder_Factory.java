package com.BugManageSystem.Bean;

import com.BugManageSystem.Entity.Workorder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Workorder_Factory {
    // 根据从网页接收的表单生产Workorder
    private String bugname;
    private Integer bugtype;
    private Integer bugrank;
    private Long bugid;
    private List<String> ip;
    private List<String> url;
    private List<Integer> handler;
    private List<Integer> soc_recorded;
    private List<String> comment;
    private Long date;


    protected Workorder_Factory(){}

    public Workorder_Factory(String bugname, Integer bugtype, Integer bugrank, Long bugid, List<String> ip, List<String> url, List<Integer> department, List<Integer> handler, List<Integer> soc_recorded, List<String> comment) {
        this.bugname = bugname;
        this.bugtype = bugtype;
        this.bugrank = bugrank;
        this.bugid = bugid;
        this.ip = ip;
        this.url = url;
        this.handler = handler;
        this.soc_recorded = soc_recorded;
        this.comment = comment;
        this.date = new Date().getTime();
    }

    public List<Workorder> getWorkorders(){
        List<Workorder> workorders = new ArrayList<>();
        for(int i = 0; i<ip.size();i++){
            workorders.add(new Workorder(bugname,bugtype,bugrank,bugid,ip.get(i), url.get(i),handler.get(i),soc_recorded.get(i),comment.get(i),date));
        }
        return workorders;
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


    public List<String> getIp() {
        return ip;
    }

    public void setIp(List<String> ip) {
        this.ip = ip;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<Integer> getHandler() {
        return handler;
    }

    public void setHandler(List<Integer> handler) {
        this.handler = handler;
    }

    public List<Integer> getSoc_recorded() {
        return soc_recorded;
    }

    public void setSoc_recorded(List<Integer> soc_recorded) {
        this.soc_recorded = soc_recorded;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date){
        this.date=date;
    }



}
