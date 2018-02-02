package com.sd.isp.rest.user;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.rest.base.BaseResourceImpl;
import com.sd.isp.rest.user.IUserResource;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements IUserResource{
    public UserResourceImpl() {
        super(UserDTO.class, "/user");
    }

    @Override
    public UserResult getAll() {
        final UserResult result = getWebResource().get(UserResult.class);
        return result;
    }

	@Override
	public UserDTO getByUsername(String username) {		
		return getWebResource().path("/username/" + username).get(getDtoClass());
	}
}