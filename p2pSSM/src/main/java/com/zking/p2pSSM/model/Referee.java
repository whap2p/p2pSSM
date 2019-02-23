package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Referee {
    private Integer id;

    private String rid;

    private String recommid;

    private String rapplicant;

    private Integer rsponsorid;

    private String rsponsorname;

    private Double rmoney;

    private Date rtime;

    private String rman;

    public Referee(Integer id, String rid, String recommid, String rapplicant, Integer rsponsorid, String rsponsorname, Double rmoney, Date rtime, String rman) {
        this.id = id;
        this.rid = rid;
        this.recommid = recommid;
        this.rapplicant = rapplicant;
        this.rsponsorid = rsponsorid;
        this.rsponsorname = rsponsorname;
        this.rmoney = rmoney;
        this.rtime = rtime;
        this.rman = rman;
    }

    public Referee() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRecommid() {
        return recommid;
    }

    public void setRecommid(String recommid) {
        this.recommid = recommid;
    }

    public String getRapplicant() {
        return rapplicant;
    }

    public void setRapplicant(String rapplicant) {
        this.rapplicant = rapplicant;
    }

    public Integer getRsponsorid() {
        return rsponsorid;
    }

    public void setRsponsorid(Integer rsponsorid) {
        this.rsponsorid = rsponsorid;
    }

    public String getRsponsorname() {
        return rsponsorname;
    }

    public void setRsponsorname(String rsponsorname) {
        this.rsponsorname = rsponsorname;
    }

    public Double getRmoney() {
        return rmoney;
    }

    public void setRmoney(Double rmoney) {
        this.rmoney = rmoney;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public String getRman() {
        return rman;
    }

    public void setRman(String rman) {
        this.rman = rman;
    }
}