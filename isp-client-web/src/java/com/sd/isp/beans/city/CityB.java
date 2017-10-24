package com.sd.isp.beans.city;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.isp.beans.base.BaseBean;
import com.sd.isp.beans.country.CountryB;
import com.sd.isp.beans.state.StateB;

public class CityB extends BaseBean {

	private static final long serialVersionUID = 7291563795921665648L;
	private String _name;
	private CountryB _country;
	private StateB _state;

	public CityB(Map<String, String> params) {
		super(params);
	}

	public CountryB getCountry() {
		return _country;
	}

	public void setCountry(CountryB country) {
		_country = country;
	}

	public StateB getState() {
		return _state;
	}

	public void setState(StateB state) {
		_state = state;
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
