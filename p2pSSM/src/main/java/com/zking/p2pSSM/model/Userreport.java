package com.zking.p2pSSM.model;

import lombok.ToString;

import java.util.Date;
@ToString
public class Userreport {
    private Integer reportserial;

    private String reportinformant;

    private String reportInformer;

    private String reporttype;

    private String reportcontent;

    private Date reporttime;

    private String reportstate;

    public Userreport(Integer reportserial, String reportinformant, String reportInformer, String reporttype, String reportcontent, Date reporttime, String reportstate) {
        this.reportserial = reportserial;
        this.reportinformant = reportinformant;
        this.reportInformer = reportInformer;
        this.reporttype = reporttype;
        this.reportcontent = reportcontent;
        this.reporttime = reporttime;
        this.reportstate = reportstate;
    }

    public Userreport() {
        super();
    }

    public Integer getReportserial() {
        return reportserial;
    }

    public void setReportserial(Integer reportserial) {
        this.reportserial = reportserial;
    }

    public String getReportinformant() {
        return reportinformant;
    }

    public void setReportinformant(String reportinformant) {
        this.reportinformant = reportinformant;
    }

    public String getReportInformer() {
        return reportInformer;
    }

    public void setReportInformer(String reportInformer) {
        this.reportInformer = reportInformer;
    }

    public String getReporttype() {
        return reporttype;
    }

    public void setReporttype(String reporttype) {
        this.reporttype = reporttype;
    }

    public String getReportcontent() {
        return reportcontent;
    }

    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent;
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public String getReportstate() {
        return reportstate;
    }

    public void setReportstate(String reportstate) {
        this.reportstate = reportstate;
    }
}