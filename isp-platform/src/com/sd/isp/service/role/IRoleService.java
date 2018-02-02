package com.sd.isp.service.role;

import java.util.Map;

import com.sd.isp.dao.role.RoleDaoImpl;
import com.sd.isp.domain.role.RoleDomain;
import com.sd.isp.dto.role.RoleDTO;
import com.sd.isp.dto.role.RoleResult;
import com.sd.isp.service.base.IBaseService;

public interface IRoleService extends IBaseService<RoleDTO, RoleDomain, RoleDaoImpl, RoleResult> {
	RoleResult getAllBy(Map<String, String> args);
}
