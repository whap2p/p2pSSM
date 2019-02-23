package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Approveitem {
    private Integer aiid;

    private String ainame;

    private String aitype;

    private String aistate;

    public Approveitem(Integer aiid, String ainame, String aitype, String aistate) {
        this.aiid = aiid;
        this.ainame = ainame;
        this.aitype = aitype;
        this.aistate = aistate;
    }

    public Approveitem() {
        super();
    }

    public Integer getAiid() {
        return aiid;
    }

    public void setAiid(Integer aiid) {
        this.aiid = aiid;
    }

    public String getAiname() {
        return ainame;
    }

    public void setAiname(String ainame) {
        this.ainame = ainame;
    }

    public String getAitype() {
        return aitype;
    }

    public void setAitype(String aitype) {
        this.aitype = aitype;
    }

    public String getAistate() {
        return aistate;
    }

    public void setAistate(String aistate) {
        this.aistate = aistate;
    }
}