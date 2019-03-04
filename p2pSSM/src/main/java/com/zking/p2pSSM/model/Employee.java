package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Employee {
    private Integer eid;

    private String ename;

    private String esex;

    private Date ebirth;

    private String eidcard;

    private String ephone;

    private String email;

    private Integer edeptno;

    private String epostno;

    private Date etime;

    private Integer estatus;

    private String epassword;

    private String esalt;
    public Employee(Integer eid, String ename, String esex, Date ebirth, String eidcard, String ephone, String email, Integer edeptno, String epostno, Date etime, Integer estatus, String epassword,String esalt) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.ebirth = ebirth;
        this.eidcard = eidcard;
        this.ephone = ephone;
        this.email = email;
        this.edeptno = edeptno;
        this.epostno = epostno;
        this.etime = etime;
        this.estatus = estatus;
        this.epassword = epassword;
        this.esalt=esalt;
    }

    public Employee() {
        super();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Date getEbirth() {
        return ebirth;
    }

    public void setEbirth(Date ebirth) {
        this.ebirth = ebirth;
    }

    public String getEidcard() {
        return eidcard;
    }

    public void setEidcard(String eidcard) {
        this.eidcard = eidcard;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdeptno() {
        return edeptno;
    }

    public void setEdeptno(Integer edeptno) {
        this.edeptno = edeptno;
    }

    public String getEpostno() {
        return epostno;
    }

    public void setEpostno(String epostno) {
        this.epostno = epostno;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getEsalt() {
        return esalt;
    }

    public void setEsalt(String esalt) {
        this.esalt = esalt;
    }
}