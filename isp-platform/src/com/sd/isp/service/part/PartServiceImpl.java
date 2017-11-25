package com.sd.isp.service.part;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.part.IPartDao;
import com.sd.isp.dao.part.PartDaoImpl;
import com.sd.isp.domain.part.ItemDomain;
import com.sd.isp.domain.part.PartDomain;
import com.sd.isp.dto.part.PartDTO;
import com.sd.isp.dto.part.PartResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class PartServiceImpl extends BaseServiceImpl<PartDTO, PartDomain, PartDaoImpl, PartResult> implements IPartService {

	@Autowired
	private IPartDao partDao;

	@Override
	@Transactional
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'part_getAll'"),
                       @CacheEvict(value="isp-platform-cache", key="'part_getById_'+#dto.getId()")})*/
   // @CachePut(value = "isp-platform-cache",key="'part_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@CachePut(value = "isp-platform-cache",key="'part_save'")
	public PartDTO save(PartDTO dto) {
		final PartDomain partDomain = convertDtoToDomain(dto);
		final PartDomain part =  partDao.save(partDomain);
		return convertDomainToDto(part);
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'part_' + #id'")
	//@Cacheable(value="isp-platform-cache", key="'part_'+#root.methodName+'_'+#id")
	public PartDTO getById(Integer id) {
		final PartDomain partDomain = (PartDomain) partDao.getById(id);
		final PartDTO partDTO = convertDomainToDto(partDomain);
		return partDTO;
	}

	@Override
	@Transactional
	@Cacheable(value = "isp-platform-cache", key = "'part_getAll'")
	public PartResult getAll() {
		final List<PartDTO> parts = new ArrayList<>();
		for (PartDomain domain : partDao.findAll()) {
			final PartDTO part = convertDomainToDto( domain);
			parts.add(part);
		}

		final PartResult partResult = new PartResult();
		partResult.setParts(parts);
		return partResult;
	}

	@Override
	public PartDTO updateById(Integer id, PartDTO dto) {
		final PartDomain newDomain = convertDtoToDomain(dto);
		final PartDomain domain = (PartDomain) partDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setDescription(newDomain.getDescription());
		domain.setPrice(newDomain.getPrice());
		domain.setQuantity(newDomain.getQuantity());
		final PartDomain partDomain = (PartDomain) partDao.save(domain);
		return convertDomainToDto(partDomain);
	}

	@Override
	/*@Caching(evict = { @CacheEvict(value="isp-platform-cache", key="'part_getAll'"),
	   		           @CacheEvict(value="isp-platform-cache", key="'part_getById_'+#dto.getId()")})*/
	public PartDTO delete(Integer id) {
		final PartDomain domain = (PartDomain) partDao.delete(id);
		return convertDomainToDto(domain);
	}
	
	@Override
	protected PartDTO convertDomainToDto(PartDomain domain) {
		final PartDTO part = new PartDTO();
		part.setId(domain.getId());
		part.setName(domain.getName());
		part.setDescription(domain.getDescription());
		part.setPrice(domain.getPrice());
		part.setQuantity(domain.getQuantity());
		return part;
	}

	@Override
	protected PartDomain convertDtoToDomain(PartDTO dto) {
		final PartDomain part = new PartDomain();
		part.setId(dto.getId());
		part.setName(dto.getName());
		part.setDescription(dto.getDescription());
		part.setPrice(dto.getPrice());
		part.setQuantity(dto.getQuantity());
		return part;
	}

}
