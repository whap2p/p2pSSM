package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Inactiveuser {
    private Integer iid;

    private String iuname;

    private String idmailbox;

    private Date iCreatetime;

    public Inactiveuser(Integer iid, String iuname, String idmailbox, Date iCreatetime) {
        this.iid = iid;
        this.iuname = iuname;
        this.idmailbox = idmailbox;
        this.iCreatetime = iCreatetime;
    }

    public Inactiveuser() {
        super();
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getIuname() {
        return iuname;
    }

    public void setIuname(String iuname) {
        this.iuname = iuname;
    }

    public String getIdmailbox() {
        return idmailbox;
    }

    public void setIdmailbox(String idmailbox) {
        this.idmailbox = idmailbox;
    }

    public Date getiCreatetime() {
        return iCreatetime;
    }

    public void setiCreatetime(Date iCreatetime) {
        this.iCreatetime = iCreatetime;
    }
}