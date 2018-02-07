package com.sd.isp.dao.role;

import java.util.List;
import java.util.Map;

import com.sd.isp.dao.base.IBaseDao;
import com.sd.isp.domain.role.RoleDomain;

public interface IRoleDao extends IBaseDao<RoleDomain> {
	List<RoleDomain> findAllBy(Map<String, String> args);
}
