package com.sd.isp.beans.country;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;

public class CountryB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _name;

	public CountryB(Map<String, String> params) {
		super(params);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
	}

}
