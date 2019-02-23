package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Dope {
    private Integer did;

    private Integer dprimkey;

    private String dtitle;

    private String details;

    private Date dtime;

    public Dope(Integer did, Integer dprimkey, String dtitle, String details, Date dtime) {
        this.did = did;
        this.dprimkey = dprimkey;
        this.dtitle = dtitle;
        this.details = details;
        this.dtime = dtime;
    }

    public Dope() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getDprimkey() {
        return dprimkey;
    }

    public void setDprimkey(Integer dprimkey) {
        this.dprimkey = dprimkey;
    }

    public String getDtitle() {
        return dtitle;
    }

    public void setDtitle(String dtitle) {
        this.dtitle = dtitle;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }
}