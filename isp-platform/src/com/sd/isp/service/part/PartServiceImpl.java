package com.sd.isp.service.part;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.part.PartDaoImpl;
import com.sd.isp.dao.part.IPartDao;
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
	public PartDTO save(PartDTO dto) {
		final PartDomain partDomain = convertDtoToDomain(dto);
		final PartDomain part = partDao.save(partDomain);
		return convertDomainToDto(part);
	}

	@Override
	@Transactional
	public PartDTO getById(Integer id) {
		final PartDomain partDomain = partDao.getById(id);
		final PartDTO partDTO = convertDomainToDto(partDomain);
		return partDTO;
	}

	@Override
	@Transactional
	public PartResult getAll() {
		final List<PartDTO> parts = new ArrayList<>();
		for (PartDomain domain : partDao.findAll()) {
			final PartDTO part = convertDomainToDto(domain);
			parts.add(part);
		}

		final PartResult partResult = new PartResult();
		partResult.setParts(parts);
		return partResult;
	}

	@Override
	public PartDTO updateById(Integer id, PartDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
