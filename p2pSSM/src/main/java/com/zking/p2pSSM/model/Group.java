package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Group {
    private Integer id;

    private Integer gnumber;

    private String group;

    private String gmembership;

    private String gremark;

    private String gaddpeople;

    private String gstate;

    public Group(Integer id, Integer gnumber, String group, String gmembership, String gremark, String gaddpeople, String gstate) {
        this.id = id;
        this.gnumber = gnumber;
        this.group = group;
        this.gmembership = gmembership;
        this.gremark = gremark;
        this.gaddpeople = gaddpeople;
        this.gstate = gstate;
    }

    public Group() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGnumber() {
        return gnumber;
    }

    public void setGnumber(Integer gnumber) {
        this.gnumber = gnumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGmembership() {
        return gmembership;
    }

    public void setGmembership(String gmembership) {
        this.gmembership = gmembership;
    }

    public String getGremark() {
        return gremark;
    }

    public void setGremark(String gremark) {
        this.gremark = gremark;
    }

    public String getGaddpeople() {
        return gaddpeople;
    }

    public void setGaddpeople(String gaddpeople) {
        this.gaddpeople = gaddpeople;
    }

    public String getGstate() {
        return gstate;
    }

    public void setGstate(String gstate) {
        this.gstate = gstate;
    }
}