package com.sd.isp.domain.location.state;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;

@Entity
@Table(name = "state")
public class StateDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "countryId")
	private Integer _countryId;

	@Column(name = "name")
	private String _name;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Integer getCountryId() {
		return _countryId;
	}

	public void setCountryId(Integer countryId) {
		_countryId = countryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

}
