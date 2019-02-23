package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Certification {
    private Integer id;

    private String cserial;

    private String cusername;

    private String crealname;

    private String cbalance;

    private String cfreeze;

    private String cdue;

    private String cpaid;

    private String ctotalmoney;

    public Certification(Integer id, String cserial, String cusername, String crealname, String cbalance, String cfreeze, String cdue, String cpaid, String ctotalmoney) {
        this.id = id;
        this.cserial = cserial;
        this.cusername = cusername;
        this.crealname = crealname;
        this.cbalance = cbalance;
        this.cfreeze = cfreeze;
        this.cdue = cdue;
        this.cpaid = cpaid;
        this.ctotalmoney = ctotalmoney;
    }

    public Certification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCserial() {
        return cserial;
    }

    public void setCserial(String cserial) {
        this.cserial = cserial;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public String getCrealname() {
        return crealname;
    }

    public void setCrealname(String crealname) {
        this.crealname = crealname;
    }

    public String getCbalance() {
        return cbalance;
    }

    public void setCbalance(String cbalance) {
        this.cbalance = cbalance;
    }

    public String getCfreeze() {
        return cfreeze;
    }

    public void setCfreeze(String cfreeze) {
        this.cfreeze = cfreeze;
    }

    public String getCdue() {
        return cdue;
    }

    public void setCdue(String cdue) {
        this.cdue = cdue;
    }

    public String getCpaid() {
        return cpaid;
    }

    public void setCpaid(String cpaid) {
        this.cpaid = cpaid;
    }

    public String getCtotalmoney() {
        return ctotalmoney;
    }

    public void setCtotalmoney(String ctotalmoney) {
        this.ctotalmoney = ctotalmoney;
    }
}