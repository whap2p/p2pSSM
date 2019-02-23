package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Banks {
    private Integer bkid;

    private String bkname;

    public Banks(Integer bkid, String bkname) {
        this.bkid = bkid;
        this.bkname = bkname;
    }

    public Banks() {
        super();
    }

    public Integer getBkid() {
        return bkid;
    }

    public void setBkid(Integer bkid) {
        this.bkid = bkid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }
}