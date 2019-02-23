package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Bankcard {
    private Integer bID;

    private Integer uID;

    private String uname;

    private String zname;

    private String sfz;

    private String khh;

    private String cardid;

    private Date tjtime;

    private String statu;

    public Bankcard(Integer bID, Integer uID, String uname, String zname, String sfz, String khh, String cardid, Date tjtime, String statu) {
        this.bID = bID;
        this.uID = uID;
        this.uname = uname;
        this.zname = zname;
        this.sfz = sfz;
        this.khh = khh;
        this.cardid = cardid;
        this.tjtime = tjtime;
        this.statu = statu;
    }

    public Bankcard() {
        super();
    }

    public Integer getbID() {
        return bID;
    }

    public void setbID(Integer bID) {
        this.bID = bID;
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

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getKhh() {
        return khh;
    }

    public void setKhh(String khh) {
        this.khh = khh;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public Date getTjtime() {
        return tjtime;
    }

    public void setTjtime(Date tjtime) {
        this.tjtime = tjtime;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
}