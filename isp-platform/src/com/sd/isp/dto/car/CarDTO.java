package com.sd.isp.dto.car;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "car")
public class CarDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _mark;
	//private String _model;
	//private String _number;
	//private String _color;

	@XmlElement
	public String getMark() {
		return _mark;
	}

	public void setMark(String mark) {
		_mark = mark;
	}

	/*@XmlElement
	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
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
*/
}
