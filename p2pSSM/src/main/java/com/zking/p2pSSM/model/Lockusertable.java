package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Lockusertable {
    private Integer lockingserial;

    private String lockingnumber;

    private String lockingname;

    private Integer lockingiphone;

    private String lockingid;

    private Date lockingdate;

    public Lockusertable(Integer lockingserial, String lockingnumber, String lockingname, Integer lockingiphone, String lockingid, Date lockingdate) {
        this.lockingserial = lockingserial;
        this.lockingnumber = lockingnumber;
        this.lockingname = lockingname;
        this.lockingiphone = lockingiphone;
        this.lockingid = lockingid;
        this.lockingdate = lockingdate;
    }

    public Lockusertable() {
        super();
    }

    public Integer getLockingserial() {
        return lockingserial;
    }

    public void setLockingserial(Integer lockingserial) {
        this.lockingserial = lockingserial;
    }

    public String getLockingnumber() {
        return lockingnumber;
    }

    public void setLockingnumber(String lockingnumber) {
        this.lockingnumber = lockingnumber;
    }

    public String getLockingname() {
        return lockingname;
    }

    public void setLockingname(String lockingname) {
        this.lockingname = lockingname;
    }

    public Integer getLockingiphone() {
        return lockingiphone;
    }

    public void setLockingiphone(Integer lockingiphone) {
        this.lockingiphone = lockingiphone;
    }

    public String getLockingid() {
        return lockingid;
    }

    public void setLockingid(String lockingid) {
        this.lockingid = lockingid;
    }

    public Date getLockingdate() {
        return lockingdate;
    }

    public void setLockingdate(Date lockingdate) {
        this.lockingdate = lockingdate;
    }
}