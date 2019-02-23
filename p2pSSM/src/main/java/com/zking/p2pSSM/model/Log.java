package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Log {
    private Integer id;

    private String laccount;

    private String logtype;

    private String lremark;

    private Date lprocesstime;

    public Log(Integer id, String laccount, String logtype, String lremark, Date lprocesstime) {
        this.id = id;
        this.laccount = laccount;
        this.logtype = logtype;
        this.lremark = lremark;
        this.lprocesstime = lprocesstime;
    }

    public Log() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLaccount() {
        return laccount;
    }

    public void setLaccount(String laccount) {
        this.laccount = laccount;
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype;
    }

    public String getLremark() {
        return lremark;
    }

    public void setLremark(String lremark) {
        this.lremark = lremark;
    }

    public Date getLprocesstime() {
        return lprocesstime;
    }

    public void setLprocesstime(Date lprocesstime) {
        this.lprocesstime = lprocesstime;
    }
}