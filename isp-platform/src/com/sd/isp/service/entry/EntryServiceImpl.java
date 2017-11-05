package com.sd.isp.service.entry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.entry.EntryDaoImpl;
import com.sd.isp.dao.entry.IEntryDao;
import com.sd.isp.domain.entry.EntryDomain;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class EntryServiceImpl extends BaseServiceImpl<EntryDTO, EntryDomain, EntryDaoImpl, EntryResult> implements IEntryService {

	@Autowired
	private IEntryDao entryDao;

	@Override
	@Transactional
	public EntryDTO save(EntryDTO dto) {
		final EntryDomain entryDomain = convertDtoToDomain(dto);
		final EntryDomain entry = entryDao.save(entryDomain);
		return convertDomainToDto(entry);
	}

	@Override
	@Transactional
	public EntryDTO getById(Integer id) {
		final EntryDomain entryDomain = entryDao.getById(id);
		final EntryDTO entryDTO = convertDomainToDto(entryDomain);
		return entryDTO;
	}

	@Override
	@Transactional
	public EntryResult getAll() {
		final List<EntryDTO> entries = new ArrayList<>();
		for (EntryDomain domain : entryDao.findAll()) {
			final EntryDTO entry = convertDomainToDto(domain);
			entries.add(entry);
		}

		final EntryResult entriesResult = new EntryResult();
		entriesResult.setEntry(entries);
		return entriesResult;
	}
	
	@Override
	public EntryDTO updateById(Integer id, EntryDTO dto) {
		final EntryDomain newDomain = convertDtoToDomain(dto);
		final EntryDomain domain = entryDao.getById(id);
		domain.setDate(newDomain.getDate());
		domain.setNumber(newDomain.getNumber());
		domain.setDiagnostic(newDomain.getDiagnostic());
		final EntryDomain entryDomain = entryDao.save(domain);
		return convertDomainToDto(entryDomain);
	}

	@Override
	public EntryDTO delete(Integer id) {
		final EntryDomain domain = entryDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected EntryDTO convertDomainToDto(EntryDomain domain) {
		final EntryDTO entry = new EntryDTO();
		entry.setId(domain.getId());
		entry.setDate(domain.getDate());
		entry.setNumber(domain.getNumber());
		entry.setDiagnostic(domain.getDiagnostic());
		return entry;
	}

	@Override
	protected EntryDomain convertDtoToDomain(EntryDTO dto) {
		final EntryDomain entry = new EntryDomain();
		entry.setId(dto.getId());
		entry.setDate(dto.getDate());
		entry.setNumber(dto.getNumber());
		entry.setDiagnostic(dto.getDiagnostic());
		return entry;
	}

}