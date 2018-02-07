package com.sd.isp.dto.support;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "support")
public class SupportDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _email;
	private String _phone;
	private String _subject;
	private String _message;
	private String _name;

	@XmlElement
	public String getSubject() {
		return _subject;
	}
	
	public void setSubject(String subject) {
		_subject = subject;
	}
	
	@XmlElement
	public String getMessage() {
		return _message;
	}
	
	public void setMessage(String message) {
		_message = message;
	}
	
	@XmlElement
	public String getPhone() {
		return _phone;
	}
	
	public void setPhone(String phone) {
		_phone = phone;
	}
	
	@XmlElement
	public String getEmail() {
		return _email;
	}
	
	public void setEmail(String email) {
		_email = email;
	}
	
	@XmlElement
	public String getName() {
		return _name;
	}
	
	public void setName(String userName) {
		_name = userName;
	}
}
