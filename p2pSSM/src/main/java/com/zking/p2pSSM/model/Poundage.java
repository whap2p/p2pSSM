package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Poundage {
    private Integer pID;

    private Integer uID;

    private String uname;

    private String zname;

    private String sxmoney;

    private String what;

    private Date sxtime;

    private String localaccount;

    private String bookaccount;

    private String paytype;

    public Poundage(Integer pID, Integer uID, String uname, String zname, String sxmoney, String what, Date sxtime, String localaccount, String bookaccount, String paytype) {
        this.pID = pID;
        this.uID = uID;
        this.uname = uname;
        this.zname = zname;
        this.sxmoney = sxmoney;
        this.what = what;
        this.sxtime = sxtime;
        this.localaccount = localaccount;
        this.bookaccount = bookaccount;
        this.paytype = paytype;
    }

    public Poundage() {
        super();
    }

    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public Integer getuID() {
        return uID;
    }

    public void setuID(Integer uID) {
        this.uID = uID;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }

    public String getSxmoney() {
        return sxmoney;
    }

    public void setSxmoney(String sxmoney) {
        this.sxmoney = sxmoney;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public Date getSxtime() {
        return sxtime;
    }

    public void setSxtime(Date sxtime) {
        this.sxtime = sxtime;
    }

    public String getLocalaccount() {
        return localaccount;
    }

    public void setLocalaccount(String localaccount) {
        this.localaccount = localaccount;
    }

    public String getBookaccount() {
        return bookaccount;
    }

    public void setBookaccount(String bookaccount) {
        this.bookaccount = bookaccount;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }
}