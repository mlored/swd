package com.sd.isp.service.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public RoleDTO save(RoleDTO dto) {
		final RoleDomain roleDomain = convertDtoToDomain(dto);
		final RoleDomain role = roleDao.save(roleDomain);
		return convertDomainToDto(role);
	}

	@Override
	@Transactional
	public RoleDTO getById(Integer id) {
		final RoleDomain roleDomain = roleDao.getById(id);
		final RoleDTO roleDTO = convertDomainToDto(roleDomain);
		return roleDTO;
	}

	@Override
	@Transactional
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
	public RoleDTO updateById(Integer id, RoleDTO dto) {
		final RoleDomain newDomain = convertDtoToDomain(dto);
		final RoleDomain domain    = roleDao.getById(id);
		domain.setName(newDomain.getName());
		final RoleDomain roleDomain = roleDao.save(domain);
		return convertDomainToDto(roleDomain);
	}

	@Override
	public RoleDTO delete(Integer id) {
		final RoleDomain domain = roleDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected RoleDTO convertDomainToDto(RoleDomain domain) {
		final RoleDTO role = new RoleDTO();
		role.setId(domain.getId());
		role.setName(domain.getName());
		return role;
	}

	@Override
	protected RoleDomain convertDtoToDomain(RoleDTO dto) {
		final RoleDomain role = new RoleDomain();
		role.setId(dto.getId());
		role.setName(dto.getName());
		return role;
	}

}
