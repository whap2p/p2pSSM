package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Details {
    private Integer did;

    private String dname;

    private String dcontent;

    private Integer dtype;

    private Integer pid;

    public Details(Integer did, String dname, String dcontent, Integer dtype, Integer pid) {
        this.did = did;
        this.dname = dname;
        this.dcontent = dcontent;
        this.dtype = dtype;
        this.pid = pid;
    }

    public Details() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDcontent() {
        return dcontent;
    }

    public void setDcontent(String dcontent) {
        this.dcontent = dcontent;
    }

    public Integer getDtype() {
        return dtype;
    }

    public void setDtype(Integer dtype) {
        this.dtype = dtype;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}