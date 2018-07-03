package com.sd.isp.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.role.IRoleDao;
import com.sd.isp.dao.user.IUserDao;
import com.sd.isp.dao.user.UserDaoImpl;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.domain.role.RoleDomain;
import com.sd.isp.domain.user.UserDomain;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.role.IRoleService;
import com.sd.isp.util.MailMail;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserDaoImpl, UserResult> implements IUserService {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private MailMail mailMail;
	@Autowired
	private IRoleService roleService;

	@Autowired
	private IRoleDao roleDao;
	
	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		final UserDomain userDomain = convertDtoToDomain(dto);
		final UserDomain user = userDao.save(userDomain);
		return convertDomainToDto(user);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO getById(Integer id) {
		final UserDomain userDomain = userDao.getById(id);
		final UserDTO userDTO = convertDomainToDto(userDomain);
		
		return userDTO;
	}

	@Transactional(readOnly = true)
	public UserDTO getByUsername(String username) {
		final UserDomain userDomain = userDao.getByUsername(username);
		return convertDomainToDto(userDomain);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserResult getAll() {
		final List<UserDTO> users = new ArrayList<>();
		for (UserDomain domain : userDao.findAll()) {
			final UserDTO user = convertDomainToDto(domain);
			users.add(user);
		}

		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}
	
	@Override
	@Transactional
	public UserDTO updateById(Integer id, UserDTO dto) {
		final UserDomain newDomain = convertDtoToDomain(dto);
		final UserDomain domain = userDao.getById(id);
		domain.setUsername(newDomain.getUsername());
		domain.setName(newDomain.getName());
		domain.setSurName(newDomain.getSurName());
		domain.setPassword(newDomain.getPassword());
		final UserDomain userDomain = userDao.save(domain);
		return convertDomainToDto(userDomain);
	}
	
	@Transactional
	public UserDTO delete(Integer id){
		final UserDomain domain = userDao.delete(id);
		return convertDomainToDto(domain);
	}
	
	public UserDTO convertDomainToDto(UserDomain domain) {
		final UserDTO user = new UserDTO();
		user.setId(domain.getId());
		user.setUsername(domain.getUsername());
		user.setName(domain.getName());
		user.setSurName(domain.getSurName());
		user.setPassword(domain.getPassword());
		user.setAccountLocked(domain.getAccountLocked());

		for (RoleDomain r : domain.getRoles()) {
			user.getRoles().add(roleService.convertDomainToDto(r));
		}
		
		return user;
	}

	@Override
	public UserDomain convertDtoToDomain(UserDTO dto) {
		final UserDomain user = new UserDomain();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setName(dto.getName());
		user.setSurName(dto.getSurName());
		user.setPassword(dto.getPassword());
		user.setAccountLocked(dto.getAccountLocked());
		
		return user;
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserResult find(String textToFind, int page, int maxItems) throws Exception {
		final List<UserDTO> users = new ArrayList<>();
		for (UserDomain domain : userDao.find(textToFind, page, maxItems)) {
			final UserDTO dto = convertDomainToDto(domain);
			users.add(dto);
		}
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}

}
