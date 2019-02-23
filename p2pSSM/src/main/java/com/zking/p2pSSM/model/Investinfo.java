package com.zking.p2pSSM.model;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@ToString
public class Investinfo {
    private Integer inid;

    private Integer userid;

    private Integer brrowid;

    private BigDecimal inmoney;

    private String instatus;

    private String instyle;

    private String brrowstatus;

    private String interest;

    private String profitmodel;

    private BigDecimal profitmoney;

    private Date indate;

    private String replaydate;

    private Integer markstatus;

    public Investinfo(Integer inid, Integer userid, Integer brrowid, BigDecimal inmoney, String instatus, String instyle, String brrowstatus, String interest, String profitmodel, BigDecimal profitmoney, Date indate, String replaydate, Integer markstatus) {
        this.inid = inid;
        this.userid = userid;
        this.brrowid = brrowid;
        this.inmoney = inmoney;
        this.instatus = instatus;
        this.instyle = instyle;
        this.brrowstatus = brrowstatus;
        this.interest = interest;
        this.profitmodel = profitmodel;
        this.profitmoney = profitmoney;
        this.indate = indate;
        this.replaydate = replaydate;
        this.markstatus = markstatus;
    }

    public Investinfo() {
        super();
    }

    public Integer getInid() {
        return inid;
    }

    public void setInid(Integer inid) {
        this.inid = inid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBrrowid() {
        return brrowid;
    }

    public void setBrrowid(Integer brrowid) {
        this.brrowid = brrowid;
    }

    public BigDecimal getInmoney() {
        return inmoney;
    }

    public void setInmoney(BigDecimal inmoney) {
        this.inmoney = inmoney;
    }

    public String getInstatus() {
        return instatus;
    }

    public void setInstatus(String instatus) {
        this.instatus = instatus;
    }

    public String getInstyle() {
        return instyle;
    }

    public void setInstyle(String instyle) {
        this.instyle = instyle;
    }

    public String getBrrowstatus() {
        return brrowstatus;
    }

    public void setBrrowstatus(String brrowstatus) {
        this.brrowstatus = brrowstatus;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getProfitmodel() {
        return profitmodel;
    }

    public void setProfitmodel(String profitmodel) {
        this.profitmodel = profitmodel;
    }

    public BigDecimal getProfitmoney() {
        return profitmoney;
    }

    public void setProfitmoney(BigDecimal profitmoney) {
        this.profitmoney = profitmoney;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getReplaydate() {
        return replaydate;
    }

    public void setReplaydate(String replaydate) {
        this.replaydate = replaydate;
    }

    public Integer getMarkstatus() {
        return markstatus;
    }

    public void setMarkstatus(Integer markstatus) {
        this.markstatus = markstatus;
    }
}