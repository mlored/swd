package com.sd.isp.service.user;

import com.sd.isp.beans.user.UserB;
import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.service.base.IBaseService;

public interface IUserService extends IBaseService<UserB, UserDTO> {
	public UserB getByUsername(String username);
}
