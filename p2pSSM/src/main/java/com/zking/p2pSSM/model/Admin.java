package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Admin {
    private Integer id;

    private String aname;

    private String apassword;

    public Admin(Integer id, String aname, String apassword) {
        this.id = id;
        this.aname = aname;
        this.apassword = apassword;
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }
}