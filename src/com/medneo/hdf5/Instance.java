package com.medneo.hdf5;

import java.util.Date;

/**
 * Created by Jonathan on 23 Sep, 2018
 */
public class Instance {

    private String sop_class_uid;
    private String sop_instance_uid;
    private int instance_creation_date;
    private int instance_creation_time;
    private String series_instance_uid;
    private String study_instance_uid;
    private int instance_number;
    //TODO Have to confirm how to get the corresponding image_id, series_id and study_id used below.
    private int image_id;
    private int series_id;
    private int study_id;

    public Instance(String sop_class_uid, String sop_instance_uid, int instance_creation_date, int instance_creation_time, String series_instance_uid, String study_instance_uid, int instance_number, int image_id, int series_id, int study_id) {
        this.sop_class_uid = sop_class_uid;
        this.sop_instance_uid = sop_instance_uid;
        this.instance_creation_date = instance_creation_date;
        this.instance_creation_time = instance_creation_time;
        this.series_instance_uid = series_instance_uid;
        this.study_instance_uid = study_instance_uid;
        this.instance_number = instance_number;
        this.image_id = image_id;
        this.series_id = series_id;
        this.study_id = study_id;
    }

    public String getSop_class_uid() {
        return sop_class_uid;
    }

    public void setSop_class_uid(String sop_class_uid) {
        this.sop_class_uid = sop_class_uid;
    }

    public String getSop_instance_uid() {
        return sop_instance_uid;
    }

    public void setSop_instance_uid(String sop_instance_uid) {
        this.sop_instance_uid = sop_instance_uid;
    }

    public int getInstance_creation_date() {
        return instance_creation_date;
    }

    public void setInstance_creation_date(int instance_creation_date) {
        this.instance_creation_date = instance_creation_date;
    }

    public int getInstance_creation_time() {
        return instance_creation_time;
    }

    public void setInstance_creation_time(int instance_creation_time) {
        this.instance_creation_time = instance_creation_time;
    }

    public String getSeries_instance_uid() {
        return series_instance_uid;
    }

    public void setSeries_instance_uid(String series_instance_uid) {
        this.series_instance_uid = series_instance_uid;
    }

    public String getStudy_instance_uid() {
        return study_instance_uid;
    }

    public void setStudy_instance_uid(String study_instance_uid) {
        this.study_instance_uid = study_instance_uid;
    }

    public int getInstance_number() {
        return instance_number;
    }

    public void setInstance_number(int instance_number) {
        this.instance_number = instance_number;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getSeries_id() {
        return series_id;
    }

    public void setSeries_id(int series_id) {
        this.series_id = series_id;
    }

    public int getStudy_id() {
        return study_id;
    }

    public void setStudy_id(int study_id) {
        this.study_id = study_id;
    }
}