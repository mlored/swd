package com.sd.isp.dto.user;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;
import com.sd.isp.dto.user.UserDTO;

@XmlRootElement(name = "userResult")
public class UserResult extends BaseResult<UserDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<UserDTO> getUsers() {
		return getList();
	}

	public void setUsers(List<UserDTO> dtos) {
		super.setList(dtos);
	}
}
