package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Creditlimit {
    private Integer clid;

    private Integer cluserid;

    private String clusername;

    private String crbankcard;

    private Double cllimit;

    public Creditlimit(Integer clid, Integer cluserid, String clusername, String crbankcard, Double cllimit) {
        this.clid = clid;
        this.cluserid = cluserid;
        this.clusername = clusername;
        this.crbankcard = crbankcard;
        this.cllimit = cllimit;
    }

    public Creditlimit() {
        super();
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public Integer getCluserid() {
        return cluserid;
    }

    public void setCluserid(Integer cluserid) {
        this.cluserid = cluserid;
    }

    public String getClusername() {
        return clusername;
    }

    public void setClusername(String clusername) {
        this.clusername = clusername;
    }

    public String getCrbankcard() {
        return crbankcard;
    }

    public void setCrbankcard(String crbankcard) {
        this.crbankcard = crbankcard;
    }

    public Double getCllimit() {
        return cllimit;
    }

    public void setCllimit(Double cllimit) {
        this.cllimit = cllimit;
    }
}