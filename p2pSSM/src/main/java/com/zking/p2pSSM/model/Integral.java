package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Integral {
    private Integer cuserid;

    private String cuname;

    private String cunames;

    private Integer credit;

    private Integer member;

    public Integral(Integer cuserid, String cuname, String cunames, Integer credit, Integer member) {
        this.cuserid = cuserid;
        this.cuname = cuname;
        this.cunames = cunames;
        this.credit = credit;
        this.member = member;
    }

    public Integral() {
        super();
    }

    public Integer getCuserid() {
        return cuserid;
    }

    public void setCuserid(Integer cuserid) {
        this.cuserid = cuserid;
    }

    public String getCuname() {
        return cuname;
    }

    public void setCuname(String cuname) {
        this.cuname = cuname;
    }

    public String getCunames() {
        return cunames;
    }

    public void setCunames(String cunames) {
        this.cunames = cunames;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }
}