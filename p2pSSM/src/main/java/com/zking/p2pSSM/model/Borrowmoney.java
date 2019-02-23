package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Borrowmoney {
    private Integer id;

    private String bserial;

    private String busername;

    private String brelname;

    private String bpass;

    private String btype;

    private String btitle;

    private String bmoney;

    private String brate;

    private String btimelimit;

    private String blimit;

    private String bstate;

    private String brecommend;

    private String bleixing;

    private String beizhu1;

    private String beizhu2;

    public Borrowmoney(Integer id, String bserial, String busername, String brelname, String bpass, String btype, String btitle, String bmoney, String brate, String btimelimit, String blimit, String bstate, String brecommend, String bleixing, String beizhu1, String beizhu2) {
        this.id = id;
        this.bserial = bserial;
        this.busername = busername;
        this.brelname = brelname;
        this.bpass = bpass;
        this.btype = btype;
        this.btitle = btitle;
        this.bmoney = bmoney;
        this.brate = brate;
        this.btimelimit = btimelimit;
        this.blimit = blimit;
        this.bstate = bstate;
        this.brecommend = brecommend;
        this.bleixing = bleixing;
        this.beizhu1 = beizhu1;
        this.beizhu2 = beizhu2;
    }

    public Borrowmoney() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBserial() {
        return bserial;
    }

    public void setBserial(String bserial) {
        this.bserial = bserial;
    }

    public String getBusername() {
        return busername;
    }

    public void setBusername(String busername) {
        this.busername = busername;
    }

    public String getBrelname() {
        return brelname;
    }

    public void setBrelname(String brelname) {
        this.brelname = brelname;
    }

    public String getBpass() {
        return bpass;
    }

    public void setBpass(String bpass) {
        this.bpass = bpass;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBmoney() {
        return bmoney;
    }

    public void setBmoney(String bmoney) {
        this.bmoney = bmoney;
    }

    public String getBrate() {
        return brate;
    }

    public void setBrate(String brate) {
        this.brate = brate;
    }

    public String getBtimelimit() {
        return btimelimit;
    }

    public void setBtimelimit(String btimelimit) {
        this.btimelimit = btimelimit;
    }

    public String getBlimit() {
        return blimit;
    }

    public void setBlimit(String blimit) {
        this.blimit = blimit;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    public String getBrecommend() {
        return brecommend;
    }

    public void setBrecommend(String brecommend) {
        this.brecommend = brecommend;
    }

    public String getBleixing() {
        return bleixing;
    }

    public void setBleixing(String bleixing) {
        this.bleixing = bleixing;
    }

    public String getBeizhu1() {
        return beizhu1;
    }

    public void setBeizhu1(String beizhu1) {
        this.beizhu1 = beizhu1;
    }

    public String getBeizhu2() {
        return beizhu2;
    }

    public void setBeizhu2(String beizhu2) {
        this.beizhu2 = beizhu2;
    }
}