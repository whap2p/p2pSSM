package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Feedback {
    private Integer id;

    private String fid;

    private String fname;

    private Date ftime;

    private String fconent;

    public Feedback(Integer id, String fid, String fname, Date ftime, String fconent) {
        this.id = id;
        this.fid = fid;
        this.fname = fname;
        this.ftime = ftime;
        this.fconent = fconent;
    }

    public Feedback() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    public String getFconent() {
        return fconent;
    }

    public void setFconent(String fconent) {
        this.fconent = fconent;
    }
}