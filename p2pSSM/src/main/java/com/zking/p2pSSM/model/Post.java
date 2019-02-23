package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Post {
    private Integer id;

    private String pname;

    private Date ptime;

    private Integer pstatus;

    private String pdescribe;

    public Post(Integer id, String pname, Date ptime, Integer pstatus, String pdescribe) {
        this.id = id;
        this.pname = pname;
        this.ptime = ptime;
        this.pstatus = pstatus;
        this.pdescribe = pdescribe;
    }

    public Post() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Integer getPstatus() {
        return pstatus;
    }

    public void setPstatus(Integer pstatus) {
        this.pstatus = pstatus;
    }

    public String getPdescribe() {
        return pdescribe;
    }

    public void setPdescribe(String pdescribe) {
        this.pdescribe = pdescribe;
    }
}