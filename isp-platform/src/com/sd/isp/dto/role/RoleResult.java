package com.sd.isp.dto.role;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.isp.dto.base.BaseResult;
import com.sd.isp.dto.role.RoleDTO;

@XmlRootElement(name = "roleResult")
public class RoleResult extends BaseResult<RoleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<RoleDTO> getRoles() {
		return getList();
	}

	public void setRoles(List<RoleDTO> dtos) {
		super.setList(dtos);
	}
}
