package com.sd.isp.dto.car;

import java.util.List;

import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.dto.base.BaseDTO;
import com.sd.isp.dto.entry.EntryDTO;

@XmlRootElement(name = "car")
public class CarDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _mark;
	private String _model;
	private Integer _year;
	private String _color;
    private List<EntryDTO> _entries;

    @XmlElement
	public List<EntryDTO> getEntries() {
		return _entries;
	}

	public void setEntries(List<EntryDTO> entries) {
		_entries = entries;
	}

	@XmlElement
	public String getMark() {
		return _mark;
	}

	public void setMark(String mark) {
		_mark = mark;
	}

	@XmlElement
	public Integer getYear() {
		return _year;
	}

	public void setYear(Integer year) {
		_year = year;
	}
	
	@XmlElement
	public String getModel() {
		return _model;
	}

	public void setModel(String model) {
		_model = model;
	}
	
	@XmlElement
	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}
}
