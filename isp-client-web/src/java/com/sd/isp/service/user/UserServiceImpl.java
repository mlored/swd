package com.sd.isp.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sd.isp.dto.role.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'users'")
    @CachePut(value=CACHE_REGION, key="'users' + #bean.id")
    public UserB save(UserB bean) {
        final UserDTO user = convertBeanToDto(bean);
        final UserDTO dto = _userResource.save(user);
        final UserB userB = convertDtoToBean(dto);
        return userB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'users'")
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
    @Cacheable(value=CACHE_REGION, key="'users' + #id")
    public UserB getById(Integer id) {
        final UserDTO dto = _userResource.getById(id);
        final UserB bean = convertDtoToBean(dto);
        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'users'"),
            @CacheEvict(value=CACHE_REGION, key = "'users' + #id")})
    public UserB delete(Integer id) {
        final UserDTO dto = _userResource.destroy(id);
        final UserB bean = convertDtoToBean(dto);
        return bean;
    }

    @Override
    public UserB convertDtoToBean(UserDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("username", dto.getUsername());
        params.put("name", dto.getName());
        params.put("surName", dto.getSurName());
        params.put("password", dto.getPassword());
        params.put("accountLocked", dto.getAccountLocked());
		final UserB user = new UserB(params);
		final Set<RoleB> roles = new HashSet<RoleB>();

		if(roles!=null){
            for (RoleDTO rol :  dto.getRoles()) {
                user.getRoles().add(_roleService.convertDtoToBean(rol));
            }
		}else{
			System.out.println("No trae roles desde el web service");
		}
		return user;
    }

    @Override
    public UserDTO convertBeanToDto(UserB bean) {
        final UserDTO dto = new UserDTO();
        dto.setId(bean.getId());
        dto.setUsername(bean.getUsername());
        dto.setName(bean.getName());
        dto.setSurName(bean.getSurName());
        dto.setPassword(passwordEncoder.encode(bean.getPassword()));
        dto.setAccountLocked(bean.getAccountLocked());

        for (RoleB roleB : bean.getRoles()) {
            dto.getRoles().add(_roleService.convertBeanToDto(roleB));
        }

		return dto;
    }

    @Override
    @CacheEvict(value=CACHE_REGION, key = "'users'")
    @CachePut(value=CACHE_REGION, key="'users' + #id")
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

    public UserB getByUsername(String username, String password) {
        final UserDTO dto = _userResource.getByUsername(username, password);
        return convertDtoToBean(dto);
    }

    public List<UserB> find (String textToFind, int maxItems, int page) {
        final UserResult result = _userResource.findWR(textToFind, maxItems, page);
        final List<UserDTO> rList = null == result.getUsers() ? new ArrayList<UserDTO>()
                : result.getUsers();

        final List<UserB> clients = new ArrayList<UserB>();
        for (UserDTO dto : rList) {
            final UserB bean = convertDtoToBean(dto);
            clients.add(bean);
        }
        return clients;
	}
}
