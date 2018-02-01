package com.sd.isp.domain.support;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;

@Entity
@Table(name = "support")
public class SupportDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "subject")
	private String _subject;

	@Column(name = "message" , length = 260)
	private String _message;

	
	@Column(name = "email")
	private String _email;
	
	@Column(name = "phone")
	private String _phone;
	
	@Column(name = "name")
	private String _name;
	
	public Integer getId() {
		return _id;
	}
	
	public void setId(Integer id) {
		_id = id;
	}
	
	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}
	
	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}
	
	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}
	
	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}
	
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
}