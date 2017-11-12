package com.sd.isp.service.buy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.buy.BuyDaoImpl;
import com.sd.isp.dao.buy.IBuyDao;
import com.sd.isp.domain.buy.BuyDomain;
import com.sd.isp.dto.buy.BuyDTO;
import com.sd.isp.dto.buy.BuyResult;
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
	@Transactional
	public BuyDTO getById(Integer id) {
		final BuyDomain buyDomain = buyDao.getById(id);
		final BuyDTO buyDTO = convertDomainToDto(buyDomain);
		return buyDTO;
	}

	@Override
	@Transactional
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
	public BuyDTO delete(Integer id) {
		final BuyDomain domain = buyDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected BuyDTO convertDomainToDto(BuyDomain domain) {
		final BuyDTO buy = new BuyDTO();
		buy.setId(domain.getId());
		buy.setDate(domain.getDate());
		buy.setNumber(domain.getNumber());
		buy.setTotal(domain.getTotal());
		buy.setType(domain.getType());
		return buy;
	}

	@Override
	protected BuyDomain convertDtoToDomain(BuyDTO dto) {
		final BuyDomain buy = new BuyDomain();
		buy.setId(dto.getId());
		buy.setDate(dto.getDate());
		buy.setNumber(dto.getNumber());
		buy.setTotal(dto.getTotal());
		buy.setType(dto.getType());
		return buy;
	}

}