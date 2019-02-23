package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Managegroup {
    private Integer adminserial;

    private String adminname;

    private String admindescribe;

    public Managegroup(Integer adminserial, String adminname, String admindescribe) {
        this.adminserial = adminserial;
        this.adminname = adminname;
        this.admindescribe = admindescribe;
    }

    public Managegroup() {
        super();
    }

    public Integer getAdminserial() {
        return adminserial;
    }

    public void setAdminserial(Integer adminserial) {
        this.adminserial = adminserial;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdmindescribe() {
        return admindescribe;
    }

    public void setAdmindescribe(String admindescribe) {
        this.admindescribe = admindescribe;
    }
}