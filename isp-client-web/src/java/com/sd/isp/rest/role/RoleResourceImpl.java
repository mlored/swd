package com.sd.isp.rest.role;

import org.springframework.stereotype.Repository;

import com.sd.isp.dto.role.RoleDTO;
import com.sd.isp.dto.role.RoleResult;
import com.sd.isp.rest.base.BaseResourceImpl;
import com.sd.isp.rest.role.IRoleResource;

@Repository("roleResource")
public class RoleResourceImpl extends BaseResourceImpl<RoleDTO> implements IRoleResource{
    public RoleResourceImpl() {
        super(RoleDTO.class, "/role");
    }

    @Override
    public RoleResult getAll() {
        final RoleResult result = getWebResource().get(RoleResult.class);
        return result;
    }
    
    @Override
	public RoleDTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}
}