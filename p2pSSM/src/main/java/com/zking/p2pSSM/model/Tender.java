package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Tender {
    private Integer id;

    private String biaoid;

    private Integer uid;

    private Date ttime;

    public Tender(Integer id, String biaoid, Integer uid, Date ttime) {
        this.id = id;
        this.biaoid = biaoid;
        this.uid = uid;
        this.ttime = ttime;
    }

    public Tender() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiaoid() {
        return biaoid;
    }

    public void setBiaoid(String biaoid) {
        this.biaoid = biaoid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }
}