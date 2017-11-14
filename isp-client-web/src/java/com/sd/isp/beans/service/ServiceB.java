package com.sd.isp.beans.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class ServiceB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String _name;
    private String _description;
    private String _price;
    private String _quantity;

    public ServiceB(Map<String, String> params) {
        super(params);
    }
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }
    public String getDescription() {
        return _description;
    }
    public void setDescription(String description) {
        _description = description;
    }
    public String getPrice() {
        return _price;
    }
    public void setPrice(String price) {
        _price = price;
    }
    public String getQuantity() {
        return _quantity;
    }
    public void setQuantity(String quantity) {
        _quantity = quantity;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        setName(params.get("name"));
        setDescription(params.get("description"));
        setPrice(params.get("price"));
        setQuantity(params.get("quantity"));


    }

}

