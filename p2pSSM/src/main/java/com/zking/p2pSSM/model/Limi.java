package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Limi {
    private Integer lid;

    private Integer did;

    private String mid;

    public Limi(Integer lid, Integer did, String mid) {
        this.lid = lid;
        this.did = did;
        this.mid = mid;
    }

    public Limi() {
        super();
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}