package com.sd.isp.rest.user;

import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO, UserResult> implements IUserResource{
    public UserResourceImpl() {
        super(UserDTO.class, "/user", UserResult.class);
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

    @Override
    public UserDTO getByUsername(String username, String password) {
        getWebResource().addFilter(new HTTPBasicAuthFilter(username, password));
        return getWebResource().path("/username/" + username).get(getDtoClass());
    }

}