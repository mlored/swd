package com.sd.isp.rest.role;

import com.sd.isp.dto.role.RoleDTO;
import com.sd.isp.dto.role.RoleResult;
import com.sd.isp.rest.base.IBaseResource;

public interface IRoleResource extends IBaseResource<RoleDTO, RoleResult>{
    public RoleResult getAll();
}
