package com.sd.isp.service.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.role.IRoleDao;
import com.sd.isp.dao.role.RoleDaoImpl;
import com.sd.isp.domain.role.RoleDomain;
import com.sd.isp.dto.role.RoleDTO;
import com.sd.isp.dto.role.RoleResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDomain, RoleDaoImpl, RoleResult> implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	@Transactional
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'role_getAll'"),
	                   @CacheEvict(value="isp-platform-cache", key="'role_getById_'+#dto.getId()")})*/
   // @CachePut(value = "isp-platform-cache",key="'role_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@CachePut(value = "isp-platform-cache",key="'role_save'")
	public RoleDTO save(RoleDTO dto) {
		final RoleDomain roleDomain = convertDtoToDomain(dto);
		final RoleDomain role = roleDao.save(roleDomain);
		return convertDomainToDto(role);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "isp-platform-cache", key = "'role_' + #id'")
  //@Cacheable(value="isp-platform-cache", key="'role_'+#root.methodName+'_'+#id")
	public RoleDTO getById(Integer id) {
		final RoleDomain roleDomain = roleDao.getById(id);
		return convertDomainToDto(roleDomain);
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'role_getAll'")
	public RoleResult getAll() {
		final List<RoleDTO> roles = new ArrayList<>();
		for (RoleDomain domain : roleDao.findAll()) {
			final RoleDTO role = convertDomainToDto(domain);
			roles.add(role);
		}

		final RoleResult roleResult = new RoleResult();
		roleResult.setRoles(roles);
		return roleResult;
	}
	
	@Override
	@Cacheable(value="isp-platform-cache", key="'role_'+#root.methodName+'_'+#args")
	@Transactional(readOnly = true)
	public RoleResult getAllBy(Map<String, String> args) {
		final List<RoleDTO> roles = new ArrayList<>();
		for (RoleDomain domain : roleDao.findAllBy(args)) {
			final RoleDTO dto = convertDomainToDto(domain);
			roles.add(dto);
		}
		final RoleResult roleResult = new RoleResult();
		roleResult.setRoles(roles);
		return roleResult;
	}
	
	@Override
	public RoleDTO updateById(Integer id, RoleDTO dto) {
		final RoleDomain newDomain = convertDtoToDomain(dto);
		final RoleDomain domain    = roleDao.getById(id);
		domain.setAuthority(newDomain.getAuthority());
		final RoleDomain roleDomain = roleDao.save(domain);
		return convertDomainToDto(roleDomain);
	}

	@Override
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'role_getAll'"),
                       @CacheEvict(value="isp-platform-cache", key="'role_getById_'+#dto.getId()")})*/
	public RoleDTO delete(Integer id) {
		final RoleDomain domain = roleDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected RoleDTO convertDomainToDto(RoleDomain domain) {
		final RoleDTO role = new RoleDTO();
		role.setId(domain.getId());
		role.setAuthority(domain.getAuthority());
		return role;
	}

	@Override
	protected RoleDomain convertDtoToDomain(RoleDTO dto) {
		final RoleDomain role = new RoleDomain();
		role.setId(dto.getId());
		role.setAuthority(dto.getAuthority());
		return role;
	}

}
