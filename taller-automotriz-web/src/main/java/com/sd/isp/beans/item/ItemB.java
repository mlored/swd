package com.sd.isp.beans.item;

import com.sd.isp.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class ItemB  extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String _name;
    private String _description;
    private Integer _price;
    private Integer _quantity;

    public ItemB(Map<String, String> params) {
        super(params);
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public Integer getPrice() {
        return _price;
    }

    public void setPrice(Integer _price) {
        this._price = _price;
    }

    public Integer getQuantity() {
        return _quantity;
    }

    public void setQuantity(Integer _quantity) {
        this._quantity = _quantity;
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        setName(params.get("name"));
        setDescription(params.get("description"));
        if (!StringUtils.isBlank(params.get("price")))
            setPrice(Integer.valueOf(params.get("price")));
        if (!StringUtils.isBlank(params.get("price")))
            setQuantity(Integer.valueOf(params.get("quantity")));
    }
}
