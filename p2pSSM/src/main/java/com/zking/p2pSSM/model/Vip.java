package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Vip {
    private Integer vid;

    private String uname;

    private String unames;

    private Date vipdate;

    private Date vipdates;

    private Integer vipstate;

    public Vip(Integer vid, String uname, String unames, Date vipdate, Date vipdates, Integer vipstate) {
        this.vid = vid;
        this.uname = uname;
        this.unames = unames;
        this.vipdate = vipdate;
        this.vipdates = vipdates;
        this.vipstate = vipstate;
    }

    public Vip() {
        super();
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnames() {
        return unames;
    }

    public void setUnames(String unames) {
        this.unames = unames;
    }

    public Date getVipdate() {
        return vipdate;
    }

    public void setVipdate(Date vipdate) {
        this.vipdate = vipdate;
    }

    public Date getVipdates() {
        return vipdates;
    }

    public void setVipdates(Date vipdates) {
        this.vipdates = vipdates;
    }

    public Integer getVipstate() {
        return vipstate;
    }

    public void setVipstate(Integer vipstate) {
        this.vipstate = vipstate;
    }
}