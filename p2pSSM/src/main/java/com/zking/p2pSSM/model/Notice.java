package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Notice {
    private Integer noticeid;

    private String noticetitle;

    private String noticetype;

    private String noticepicture;

    private String noticecontent;

    private Date noticelasttime;

    private Integer noticelastmodifier;

    public Notice(Integer noticeid, String noticetitle, String noticetype, String noticepicture, String noticecontent, Date noticelasttime, Integer noticelastmodifier) {
        this.noticeid = noticeid;
        this.noticetitle = noticetitle;
        this.noticetype = noticetype;
        this.noticepicture = noticepicture;
        this.noticecontent = noticecontent;
        this.noticelasttime = noticelasttime;
        this.noticelastmodifier = noticelastmodifier;
    }

    public Notice() {
        super();
    }

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticetitle() {
        return noticetitle;
    }

    public void setNoticetitle(String noticetitle) {
        this.noticetitle = noticetitle;
    }

    public String getNoticetype() {
        return noticetype;
    }

    public void setNoticetype(String noticetype) {
        this.noticetype = noticetype;
    }

    public String getNoticepicture() {
        return noticepicture;
    }

    public void setNoticepicture(String noticepicture) {
        this.noticepicture = noticepicture;
    }

    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent;
    }

    public Date getNoticelasttime() {
        return noticelasttime;
    }

    public void setNoticelasttime(Date noticelasttime) {
        this.noticelasttime = noticelasttime;
    }

    public Integer getNoticelastmodifier() {
        return noticelastmodifier;
    }

    public void setNoticelastmodifier(Integer noticelastmodifier) {
        this.noticelastmodifier = noticelastmodifier;
    }
}