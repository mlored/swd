package com.sd.isp.beans.car;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class CarB extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String _mark;
    private String _model;
    private Integer _year;
    private String _color;

    public CarB(Map<String, String> params) {
        super(params);
    }

    public String getMark() {
        return _mark;
    }

    public void setMark(String mark) {
        _mark = mark;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        _model = model;
    }

    public Integer getYear() {
        return _year;
    }

    public void setYear(Integer year) {
        _year = year;
    }

    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        _color = color;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        setMark(params.get("mark"));
        setModel(params.get("model"));
        if (!StringUtils.isBlank(params.get("year")) )
            setYear(Integer.valueOf(params.get("year")));
        setColor(params.get("color"));

    }

}