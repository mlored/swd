package com.sd.isp.dto.role;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.sd.isp.dto.base.BaseDTO;

@XmlRootElement(name = "user")
public class RoleDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	private String _authority;
	
	@XmlElement
	public String getAuthority() {
		return _authority;
	}

	public void setAuthority(String _authority) {
		this._authority = _authority;
	}
}
