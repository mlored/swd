package com.sd.isp.service.buy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.buy.BuyB;
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
    public BuyB save(BuyB bean) {
        final BuyDTO service = convertBeanToDto(bean);
        final BuyDTO dto     = _buyResource.save(service);
        final BuyB   buyB    = convertDtoToBean(dto);
        return buyB;
    }

    @Override
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
    public BuyB getById(Integer id) {
        final BuyDTO dto = _buyResource.getById(id);
        final BuyB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
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

	@Override
	public BuyB update(Integer id, BuyB bean) {
		// TODO Auto-generated method stub
		return null;
	}
}