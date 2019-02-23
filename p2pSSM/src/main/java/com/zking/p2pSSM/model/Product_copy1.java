package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Product_copy1 {
    private Integer id;

    private Long pmoney;

    private String pincome;

    private Date ptime;

    private Integer ptype;

    private String pway;

    private Date pcount;

    private String progress;

    private String psaveway;

    private String prateben;

    private Date ppublishtime;

    private String pname;

    private Long ptotalmoney;

    private String prange;

    private String puse;

    private String pstate;

    private String picture;

    private Integer pproduce;

    private String pdesc;

    private String psafe;

    private Integer did;

    public Product_copy1(Integer id, Long pmoney, String pincome, Date ptime, Integer ptype, String pway, Date pcount, String progress, String psaveway, String prateben, Date ppublishtime, String pname, Long ptotalmoney, String prange, String puse, String pstate, String picture, Integer pproduce, String pdesc, String psafe, Integer did) {
        this.id = id;
        this.pmoney = pmoney;
        this.pincome = pincome;
        this.ptime = ptime;
        this.ptype = ptype;
        this.pway = pway;
        this.pcount = pcount;
        this.progress = progress;
        this.psaveway = psaveway;
        this.prateben = prateben;
        this.ppublishtime = ppublishtime;
        this.pname = pname;
        this.ptotalmoney = ptotalmoney;
        this.prange = prange;
        this.puse = puse;
        this.pstate = pstate;
        this.picture = picture;
        this.pproduce = pproduce;
        this.pdesc = pdesc;
        this.psafe = psafe;
        this.did = did;
    }

    public Product_copy1() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPmoney() {
        return pmoney;
    }

    public void setPmoney(Long pmoney) {
        this.pmoney = pmoney;
    }

    public String getPincome() {
        return pincome;
    }

    public void setPincome(String pincome) {
        this.pincome = pincome;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public String getPway() {
        return pway;
    }

    public void setPway(String pway) {
        this.pway = pway;
    }

    public Date getPcount() {
        return pcount;
    }

    public void setPcount(Date pcount) {
        this.pcount = pcount;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getPsaveway() {
        return psaveway;
    }

    public void setPsaveway(String psaveway) {
        this.psaveway = psaveway;
    }

    public String getPrateben() {
        return prateben;
    }

    public void setPrateben(String prateben) {
        this.prateben = prateben;
    }

    public Date getPpublishtime() {
        return ppublishtime;
    }

    public void setPpublishtime(Date ppublishtime) {
        this.ppublishtime = ppublishtime;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getPtotalmoney() {
        return ptotalmoney;
    }

    public void setPtotalmoney(Long ptotalmoney) {
        this.ptotalmoney = ptotalmoney;
    }

    public String getPrange() {
        return prange;
    }

    public void setPrange(String prange) {
        this.prange = prange;
    }

    public String getPuse() {
        return puse;
    }

    public void setPuse(String puse) {
        this.puse = puse;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPproduce() {
        return pproduce;
    }

    public void setPproduce(Integer pproduce) {
        this.pproduce = pproduce;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPsafe() {
        return psafe;
    }

    public void setPsafe(String psafe) {
        this.psafe = psafe;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}