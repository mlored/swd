package com.sd.isp.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.user.UserB;
import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.rest.user.IUserResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.user.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO>
        implements IUserService {

    @Autowired
    private IUserResource _userResource;


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
        params.put("userName", dto.getUserName());
        params.put("name", dto.getName());
        params.put("surName", dto.getSurName());
        params.put("password", dto.getPassword());

        final UserB userB = new UserB(params);

        return userB;
    }

    @Override
    protected UserDTO convertBeanToDto(UserB bean) {
        final UserDTO dto = new UserDTO();
        dto.setId(bean.getId());
        dto.setUserName(bean.getUserName());
        dto.setName(bean.getName());
        dto.setSurName(bean.getSurName());
        dto.setPassword(bean.getPassword());

        return dto;
    }

	@Override
	public UserB update(Integer id, UserB bean) {
		// TODO Auto-generated method stub
		return null;
	}
}
