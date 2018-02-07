package com.sd.isp.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.role.RoleB;
import com.sd.isp.beans.user.UserB;
import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.rest.user.IUserResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.role.IRoleService;
import com.sd.isp.service.user.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO>
        implements IUserService {

    @Autowired
    private IUserResource _userResource;
    
    @Autowired
	private IRoleService _roleService;

    public UserServiceImpl() {
    }

    @Override
    public UserB save(UserB bean) {
        final UserDTO user = convertBeanToDto(bean);
        final UserDTO dto = _userResource.save(user);
        final UserB userB = convertDtoToBean(dto);
        return userB;
    }

    @Override
    @Cacheable(value="isp-client-web-cache", key="'user_getAll'")
    public List<UserB> getAll() {
        final UserResult result = _userResource.getAll();
        final List<UserDTO> uList = null == result.getUsers() ? new ArrayList<UserDTO>()
                : result.getUsers();

        final List<UserB> users = new ArrayList<UserB>();
        for (UserDTO dto : uList) {
            final UserB bean = convertDtoToBean(dto);
            users.add(bean);
        }
        return users;
    }

    @Override
    public UserB getById(Integer id) {
        final UserDTO dto = _userResource.getById(id);
        final UserB bean = convertDtoToBean(dto);
        return bean;
    }

    @Override
    public UserB delete(Integer id) {
        final UserDTO dto = _userResource.destroy(id);
        final UserB bean = convertDtoToBean(dto);
        return bean;
    }

    @Override
    protected UserB convertDtoToBean(UserDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("username", dto.getUsername());
        params.put("name", dto.getName());
        params.put("surName", dto.getSurName());
        params.put("password", dto.getPassword());
        params.put("accountLocked", dto.getAccountLocked());
		final UserB user = new UserB(params);
		final Set<RoleB> roles = new HashSet<RoleB>();
		List<Integer> rolesIds = dto.getRoles();
		if(rolesIds!=null){
			if(rolesIds.size()>0){
				for (Integer roleId : rolesIds) {
					roles.add(_roleService.getById(roleId));
				}
				user.setRoles(roles);
			}
		}else{
			System.out.println("No trae roles desde el web service");
		}
		return user;
    }

    @Override
    protected UserDTO convertBeanToDto(UserB bean) {
        final UserDTO dto = new UserDTO();
        dto.setId(bean.getId());
        dto.setUsername(bean.getUsername());
        dto.setName(bean.getName());
        dto.setSurName(bean.getSurName());
        dto.setPassword(bean.getPassword());
        dto.setAccountLocked(bean.getAccountLocked());
		final List<Integer> rolesIds = new ArrayList<Integer>();
		Set<RoleB> roles = bean.getRoles();
		if(roles!=null){
			for (RoleB roleB : roles) {
				rolesIds.add(roleB.getId());
			}
			dto.setRolesIds(rolesIds);
		}else{
			System.out.println("No se especifico roles en el cliente!!");
		}
		return dto;
    }

    @Override
	public UserB update(Integer id,  UserB userB) {
    	final UserDTO user   = convertBeanToDto(userB);
        final UserDTO dto     = _userResource.update(id, user);
        final UserB bean      = convertDtoToBean(dto);

        return bean;
    }
    
	@Override
	public UserB getByUsername(String username) {
		final UserDTO dto = _userResource.getByUsername(username);
		return convertDtoToBean(dto);
	}
}
