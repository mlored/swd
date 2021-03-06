package com.sd.isp.rest.user;

import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IUserResource extends IBaseResource<UserDTO, UserResult>{
    public UserResult getAll();
	public UserDTO getByUsername(String username);
    public UserDTO getByUsername(String username, String password);
}
