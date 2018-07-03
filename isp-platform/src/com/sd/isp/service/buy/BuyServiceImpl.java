package com.sd.isp.service.buy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.buy.BuyDaoImpl;
import com.sd.isp.dao.buy.IBuyDao;
import com.sd.isp.domain.buy.BuyDomain;
import com.sd.isp.dto.buy.BuyDTO;
import com.sd.isp.dto.buy.BuyResult;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class BuyServiceImpl extends BaseServiceImpl<BuyDTO, BuyDomain, BuyDaoImpl, BuyResult> implements IBuyService {

	@Autowired
	private IBuyDao buyDao;

	@Override
	@Transactional
	public BuyDTO save(BuyDTO dto) {
		final BuyDomain buyDomain = convertDtoToDomain(dto);
		final BuyDomain buy = buyDao.save(buyDomain);
		return convertDomainToDto(buy);
	}

	@Override
	@Transactional(readOnly = true)
	public BuyDTO getById(Integer id) {
		final BuyDomain buyDomain = buyDao.getById(id);
		final BuyDTO buyDTO = convertDomainToDto(buyDomain);
		return buyDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public BuyResult getAll() {
		final List<BuyDTO> buys = new ArrayList<>();
		for (BuyDomain domain : buyDao.findAll()) {
			final BuyDTO buy = convertDomainToDto(domain);
			buys.add(buy);
		}

		final BuyResult buyResult = new BuyResult();
		buyResult.setBuys(buys);
		return buyResult;
	}
	
	@Override
	@Transactional
	public BuyDTO updateById(Integer id, BuyDTO dto) {
		final BuyDomain newDomain = convertDtoToDomain(dto);
		final BuyDomain domain = buyDao.getById(id);
		domain.setDate(newDomain.getDate());
		domain.setNumber(newDomain.getNumber());
		domain.setType(newDomain.getType());
		domain.setTotal(newDomain.getTotal());
		final BuyDomain buyDomain = buyDao.save(domain);
		return convertDomainToDto(buyDomain);
	}

	@Override
	@Transactional
	public BuyDTO delete(Integer id) {
		final BuyDomain domain = buyDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	public BuyDTO convertDomainToDto(BuyDomain domain) {
		final BuyDTO buy = new BuyDTO();
		buy.setId(domain.getId());
		buy.setDate(domain.getDate());
		buy.setNumber(domain.getNumber());
		buy.setTotal(domain.getTotal());
		buy.setType(domain.getType());
		return buy;
	}

	@Override
	public BuyDomain convertDtoToDomain(BuyDTO dto) {
		final BuyDomain buy = new BuyDomain();
		buy.setId(dto.getId());
		buy.setDate(dto.getDate());
		buy.setNumber(dto.getNumber());
		buy.setTotal(dto.getTotal());
		buy.setType(dto.getType());
		return buy;
	}
	
	@Override
	@Transactional(readOnly = true)
	public BuyResult find(String textToFind, int page, int maxItems) throws Exception {
		/*final List<EmployeeDTO> employees = new ArrayList<>();
		for (EmployeeDomain domain : employeeDao.find(textToFind, page, maxItems)) {
			final EmployeeDTO dto = convertDomainToDto(domain);
			employees.add(dto);
		}
		final EmployeeResult employeeResult = new EmployeeResult();
		employeeResult.setEmployees(employees);
		return employeeResult;*/
		return null;
	}

}
