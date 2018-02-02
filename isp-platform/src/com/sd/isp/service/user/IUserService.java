package com.sd.isp.service.user;

import com.sd.isp.dao.user.UserDaoImpl;
import com.sd.isp.domain.user.UserDomain;
import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.service.base.IBaseService;

public interface IUserService extends IBaseService<UserDTO, UserDomain, UserDaoImpl, UserResult> {
	UserDTO getByUsername(String username);
}
