package com.sd.isp.service.sell;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.sell.ISellDao;
import com.sd.isp.dao.sell.SellDaoImpl;
import com.sd.isp.domain.sell.SellDomain;
import com.sd.isp.dto.sell.SellDTO;
import com.sd.isp.dto.sell.SellResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class SellServiceImpl extends BaseServiceImpl<SellDTO, SellDomain, SellDaoImpl, SellResult> implements ISellService {

	@Autowired
	private ISellDao sellDao;

	@Override
	@Transactional
	public SellDTO save(SellDTO dto) {
		final SellDomain sellDomain = convertDtoToDomain(dto);
		final SellDomain sell = sellDao.save(sellDomain);
		return convertDomainToDto(sell);
	}

	@Override
	@Transactional
	public SellDTO getById(Integer id) {
		final SellDomain sellDomain = sellDao.getById(id);
		final SellDTO sellDTO = convertDomainToDto(sellDomain);
		return sellDTO;
	}

	@Override
	@Transactional
	public SellResult getAll() {
		final List<SellDTO> sells = new ArrayList<>();
		for (SellDomain domain : sellDao.findAll()) {
			final SellDTO sell = convertDomainToDto(domain);
			sells.add(sell);
		}

		final SellResult sellResult = new SellResult();
		sellResult.setSells(sells);
		return sellResult;
	}
	
	@Override
	public SellDTO updateById(Integer id, SellDTO dto) {
		final SellDomain newDomain = convertDtoToDomain(dto);
		final SellDomain domain = sellDao.getById(id);
		domain.setDate(newDomain.getDate());
		domain.setNumber(newDomain.getNumber());
		domain.setType(newDomain.getType());
		domain.setTotal(newDomain.getTotal());
		final SellDomain sellDomain = sellDao.save(domain);
		return convertDomainToDto(sellDomain);
	}

	@Override
	public SellDTO delete(Integer id) {
		final SellDomain domain = sellDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected SellDTO convertDomainToDto(SellDomain domain) {
		final SellDTO sell = new SellDTO();
		sell.setId(domain.getId());
		sell.setDate(domain.getDate());
		sell.setNumber(domain.getNumber());
		sell.setTotal(domain.getTotal());
		sell.setType(domain.getType());
		return sell;
	}

	@Override
	protected SellDomain convertDtoToDomain(SellDTO dto) {
		final SellDomain sell = new SellDomain();
		sell.setId(dto.getId());
		sell.setDate(dto.getDate());
		sell.setNumber(dto.getNumber());
		sell.setTotal(dto.getTotal());
		sell.setType(dto.getType());
		return sell;
	}

}