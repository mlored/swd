package com.sd.isp.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.role.RoleB;
import com.sd.isp.beans.service.ServiceB;
import com.sd.isp.dto.role.RoleDTO;
import com.sd.isp.dto.role.RoleResult;
import com.sd.isp.rest.role.IRoleResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.role.IRoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<RoleB, RoleDTO>
        implements IRoleService {

    @Autowired
    private IRoleResource _roleResource;


    public RoleServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'roles'")
    @CachePut(value=CACHE_REGION, key="'roles' + #bean.id")
    public RoleB save(RoleB bean) {
        final RoleDTO role = convertBeanToDto(bean);
        final RoleDTO dto = _roleResource.save(role);
        final RoleB roleB = convertDtoToBean(dto);
        return roleB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'roles'")
    public List<RoleB> getAll() {
        final RoleResult result = _roleResource.getAll();
        final List<RoleDTO> rList = null == result.getRoles() ? new ArrayList<RoleDTO>()
                : result.getRoles();

        final List<RoleB> roles = new ArrayList<RoleB>();
        for (RoleDTO dto : rList) {
            final RoleB bean = convertDtoToBean(dto);
            roles.add(bean);
        }
        return roles;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'roles' + #id")
    public RoleB getById(Integer id) {
        final RoleDTO dto = _roleResource.getById(id);
        final RoleB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'roles'"),
            @CacheEvict(value=CACHE_REGION, key = "'roles' + #id")})
    public RoleB delete(Integer id) {
        final RoleDTO dto = _roleResource.destroy(id);
        final RoleB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected RoleB convertDtoToBean(RoleDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("authority", dto.getAuthority());

        final RoleB roleB = new RoleB(params);

        return roleB;
    }

    @Override
    protected RoleDTO convertBeanToDto(RoleB bean) {
        final RoleDTO dto = new RoleDTO();
        dto.setId(bean.getId());
        dto.setAuthority(bean.getAuthority());

        return dto;
    }

    @Override
    @CacheEvict(value=CACHE_REGION, key = "'roles'")
    @CachePut(value=CACHE_REGION, key="'roles' + #id")
	public RoleB update(Integer id,  RoleB roleB) {
    	final RoleDTO role   = convertBeanToDto(roleB);
        final RoleDTO dto     = _roleResource.update(id, role);
        final RoleB bean      = convertDtoToBean(dto);

        return bean;
    }
    public List<RoleB> find (String textToFind, int maxItems, int page) {
		/*final ServiceResult result = _serviceResource.find(textToFind, maxItems, page);
		final List<ServiceDTO> rList = null == result.getServices() ? new ArrayList<ServiceDTO>()
				: result.getServices();

		final List<ServiceB> services = new ArrayList<ServiceB>();
		for (ServicetDTO dto : rList) {
			final ServiceB bean = convertDtoToBean(dto);
			services.add(bean);
		}*/
		return null;
	}
}
