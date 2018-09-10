package com.medneo.hdf5;

/**
 * Created by Jonathan on 09 Sep, 2018
 */
public class Series {

    private String seriesInstanceUid;
    private int seriesNumber;
    private int seriesDate;
    private int seriesTime;
    private String seriesDescription;
    private String fkStudyUID;
    private String fkPatientIdDiag;

    public Series(String seriesInstanceUid, int seriesNumber, int seriesDate, int seriesTime, String seriesDescription, String fkStudyUID, String fkPatientIdDiag) {
        this.seriesInstanceUid = seriesInstanceUid;
        this.seriesNumber = seriesNumber;
        this.seriesDate = seriesDate;
        this.seriesTime = seriesTime;
        this.seriesDescription = seriesDescription;
        this.fkStudyUID = fkStudyUID;
        this.fkPatientIdDiag = fkPatientIdDiag;
    }

    public String getSeriesInstanceUid() {
        return seriesInstanceUid;
    }

    public void setSeriesInstanceUid(String seriesInstanceUid) {
        this.seriesInstanceUid = seriesInstanceUid;
    }

    public int getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(int seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public int getSeriesDate() {
        return seriesDate;
    }

    public void setSeriesDate(int seriesDate) {
        this.seriesDate = seriesDate;
    }

    public int getSeriesTime() {
        return seriesTime;
    }

    public void setSeriesTime(int seriesTime) {
        this.seriesTime = seriesTime;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }

    public String getFkStudyUID() {
        return fkStudyUID;
    }

    public void setFkStudyUID(String fkStudyUID) {
        this.fkStudyUID = fkStudyUID;
    }

    public String getFkPatientIdDiag() {
        return fkPatientIdDiag;
    }

    public void setFkPatientIdDiag(String fkPatientIdDiag) {
        this.fkPatientIdDiag = fkPatientIdDiag;
    }
}