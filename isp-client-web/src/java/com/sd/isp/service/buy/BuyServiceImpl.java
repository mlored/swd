package com.sd.isp.service.buy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.buy.BuyB;
import com.sd.isp.beans.client.ClientB;
import com.sd.isp.dto.buy.BuyDTO;
import com.sd.isp.dto.buy.BuyResult;
import com.sd.isp.rest.buy.IBuyResource;
import com.sd.isp.service.base.BaseServiceImpl;

@Service("buyService")
public class BuyServiceImpl extends BaseServiceImpl<BuyB, BuyDTO>
        implements IBuyService {

    @Autowired
    private IBuyResource _buyResource;


    public BuyServiceImpl() {
    }

    @Override
    @CacheEvict(value=CACHE_REGION,key = "'buys'")
    @CachePut(value=CACHE_REGION, key="'buys' + #buyB.id")
    public BuyB save(BuyB buyB) {
        final BuyDTO service = convertBeanToDto(buyB);
        final BuyDTO dto     = _buyResource.save(service);
        final BuyB   newBuyB    = convertDtoToBean(dto);
        return newBuyB;
    }

    @Override
    @Cacheable(value=CACHE_REGION, key="'buys'")
	public List<BuyB> getAll() {
		final BuyResult result = _buyResource.getAll();
		final List<BuyDTO> cList = null == result.getBuys() ? new ArrayList<BuyDTO>()
				: result.getBuys();

		final List<BuyB> buys = new ArrayList<BuyB>();
		for (BuyDTO dto : cList) {
			final BuyB bean = convertDtoToBean(dto);
			buys.add(bean);
		}
		return buys;
	}

    @Override
    @Cacheable(value=CACHE_REGION, key="'buys' + #id")
    public BuyB getById(Integer id) {
        final BuyDTO dto = _buyResource.getById(id);
        final BuyB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @CacheEvict(value=CACHE_REGION, key = "'buys'")
    @CachePut(value=CACHE_REGION, key="'buys' + #id")
    public BuyB update(Integer id,  BuyB buyB) {
        final BuyDTO buy   = convertBeanToDto(buyB);
        final BuyDTO dto   = _buyResource.update(id, buy);
        final BuyB bean    = convertDtoToBean(dto);

        return bean;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value=CACHE_REGION, key = "'buys'"),
            @CacheEvict(value=CACHE_REGION, key = "'buys' + #id")})
    public BuyB delete(Integer id) {
        return null;
    }

    @Override
    protected BuyB convertDtoToBean(BuyDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("date", dto.getDate().toString());
        params.put("number", String.valueOf(dto.getNumber()));
        params.put("total", String.valueOf(dto.getTotal()));

        final BuyB buyB = new BuyB(params);

        return buyB;
    }

    @Override
    protected BuyDTO convertBeanToDto(BuyB bean) {
        final BuyDTO dto = new BuyDTO();
        dto.setId(bean.getId());
        dto.setDate(bean.getDate());
        dto.setNumber(bean.getNumber());
        dto.setTotal(bean.getTotal());
        return dto;
    }
    
    public List<BuyB> find (String textToFind, int maxItems, int page) {
		/*final ServiceResult result = _serviceResource.find(textToFind, maxItems, page);
		final List<ServiceDTO> rList = null == result.getServices() ? new ArrayList<ServiceDTO>()
				: result.getServices();

		final List<ServiceB> services = new ArrayList<ServiceB>();
		for (ServicetDTO dto : rList) {
			final ServiceB bean = convertDtoToBean(dto);
			services.add(bean);
		}*/
		return null;
	}
}