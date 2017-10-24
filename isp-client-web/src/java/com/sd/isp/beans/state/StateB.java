package com.sd.isp.beans.state;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.country.CountryB;

public class StateB extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _name;
	private CountryB _country;

	public StateB(Map<String, String> params) {
		super(params);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public CountryB getCountry() {
		return _country;
	}

	public void setCountry(CountryB country) {
		_country = country;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
	}

}
