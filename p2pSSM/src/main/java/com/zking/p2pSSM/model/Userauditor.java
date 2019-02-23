package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Userauditor {
    private Integer uaid;

    private Integer userid;

    private String username;

    private Integer uauditorid;

    private String uauditor;

    public Userauditor(Integer uaid, Integer userid, String username, Integer uauditorid, String uauditor) {
        this.uaid = uaid;
        this.userid = userid;
        this.username = username;
        this.uauditorid = uauditorid;
        this.uauditor = uauditor;
    }

    public Userauditor() {
        super();
    }

    public Integer getUaid() {
        return uaid;
    }

    public void setUaid(Integer uaid) {
        this.uaid = uaid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUauditorid() {
        return uauditorid;
    }

    public void setUauditorid(Integer uauditorid) {
        this.uauditorid = uauditorid;
    }

    public String getUauditor() {
        return uauditor;
    }

    public void setUauditor(String uauditor) {
        this.uauditor = uauditor;
    }
}