package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Biao {
    private Integer id;

    private String bname;

    public Biao(Integer id, String bname) {
        this.id = id;
        this.bname = bname;
    }

    public Biao() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}