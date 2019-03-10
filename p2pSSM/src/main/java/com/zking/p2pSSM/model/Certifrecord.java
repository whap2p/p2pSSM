package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Certifrecord {
    private Integer crid;

    private Integer cruserid;

    private String crusername;

    private Integer craiid;

    private String crainame;

    private String craitype;

    private String crispass;

    private Date crdate;

    private String crauditor;

    private Integer crintegral;

    private String crviewpoint;

    private String crimg;

    private Date crupldate;
    private Integer checkpend;//待审核
    public Certifrecord(Integer crid, Integer cruserid, String crusername, Integer craiid, String crainame, String craitype, String crispass, Date crdate, String crauditor, Integer crintegral, String crviewpoint, String crimg, Date crupldate) {
        this.crid = crid;
        this.cruserid = cruserid;
        this.crusername = crusername;
        this.craiid = craiid;
        this.crainame = crainame;
        this.craitype = craitype;
        this.crispass = crispass;
        this.crdate = crdate;
        this.crauditor = crauditor;
        this.crintegral = crintegral;
        this.crviewpoint = crviewpoint;
        this.crimg = crimg;
        this.crupldate = crupldate;
    }

    public Certifrecord() {
        super();
    }

    public Integer getCrid() {
        return crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Integer getCruserid() {
        return cruserid;
    }

    public void setCruserid(Integer cruserid) {
        this.cruserid = cruserid;
    }

    public String getCrusername() {
        return crusername;
    }

    public void setCrusername(String crusername) {
        this.crusername = crusername;
    }

    public Integer getCraiid() {
        return craiid;
    }

    public void setCraiid(Integer craiid) {
        this.craiid = craiid;
    }

    public String getCrainame() {
        return crainame;
    }

    public void setCrainame(String crainame) {
        this.crainame = crainame;
    }

    public String getCraitype() {
        return craitype;
    }

    public void setCraitype(String craitype) {
        this.craitype = craitype;
    }

    public String getCrispass() {
        return crispass;
    }

    public void setCrispass(String crispass) {
        this.crispass = crispass;
    }

    public Date getCrdate() {
        return crdate;
    }

    public void setCrdate(Date crdate) {
        this.crdate = crdate;
    }

    public String getCrauditor() {
        return crauditor;
    }

    public void setCrauditor(String crauditor) {
        this.crauditor = crauditor;
    }

    public Integer getCrintegral() {
        return crintegral;
    }

    public void setCrintegral(Integer crintegral) {
        this.crintegral = crintegral;
    }

    public String getCrviewpoint() {
        return crviewpoint;
    }

    public void setCrviewpoint(String crviewpoint) {
        this.crviewpoint = crviewpoint;
    }

    public String getCrimg() {
        return crimg;
    }

    public void setCrimg(String crimg) {
        this.crimg = crimg;
    }

    public Date getCrupldate() {
        return crupldate;
    }

    public void setCrupldate(Date crupldate) {
        this.crupldate = crupldate;
    }
    public Integer getCheckpend() {
        return checkpend;
    }

    public void setCheckpend(Integer checkpend) {
        this.checkpend = checkpend;
    }
}