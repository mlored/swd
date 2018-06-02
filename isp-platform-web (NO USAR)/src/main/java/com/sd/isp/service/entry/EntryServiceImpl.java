package com.sd.isp.service.entry;

import com.sd.isp.beans.entry.EntryB;
import com.sd.isp.dto.entry.EntryDTO;
import com.sd.isp.dto.entry.EntryResult;
import com.sd.isp.rest.entry.IEntryResource;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.car.ICarService;
//import com.sd.isp.service.client.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;


@Service("entryService")
public class EntryServiceImpl extends BaseServiceImpl<EntryB, EntryDTO>
        implements IEntryService {

    @Autowired
    private IEntryResource entryResource;
    @Autowired
    private ICarService carResource;
  //  @Autowired
  //  private com.sd.isp.service.client.IClientService clientResource;


    public EntryServiceImpl() {
    }

    @Override
    public EntryB save(EntryB bean) {
        final EntryDTO entry = convertBeanToDto(bean);
        final EntryDTO dto = entryResource.save(entry);
        final EntryB entryB = convertDtoToBean(dto);
        return entryB;
    }

    @Override
    //@Cacheable(value="isp-client-web-cache", key="'entry_getAll'")
    public List<EntryB> getAll() {
        final EntryResult result = entryResource.getAll();
        final List<EntryDTO> cList = null == result.getEntry() ? new ArrayList<EntryDTO>()
                : result.getEntry();
        final List<EntryB> entries = new ArrayList<EntryB>();
        for (EntryDTO dto : cList) {

            final EntryB bean = convertDtoToBean(dto);
            bean.setCar(carResource.getById(dto.getCarId()));
           // bean.setCliente(clientResource.getById(dto.getClientId()));
            entries.add(bean);
        }
        return entries;
    }

    @Override
    public EntryB getById(Integer id) {
        final EntryDTO dto = entryResource.getById(id);
        final EntryB bean = convertDtoToBean(dto);
        bean.setCar(carResource.getById(dto.getCarId()));
        //bean.setCliente(clientResource.getById(dto.getClientId()));

        return bean;
    }

    @Override
	public EntryB update(Integer id,  EntryB entryB) {
    	final EntryDTO entry   = convertBeanToDto(entryB);
        final EntryDTO dto     = entryResource.update(id, entry);
        final EntryB bean      = convertDtoToBean(dto);

        return bean;
    }

    @Override

    public EntryB delete(Integer id) {
        final EntryDTO dto = entryResource.destroy(id);
        final EntryB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected EntryB convertDtoToBean(EntryDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("date", String.valueOf(dto.getDate()));
        params.put("number", String.valueOf(dto.getNumber()));
        params.put("diagnostic", dto.getDiagnostic());
        params.put("carId", String.valueOf(dto.getCarId()));
        params.put("clientId", String.valueOf(dto.getClientId()));

        final EntryB entryB = new EntryB(params);

        entryB.setCarId(dto.getCarId());
        entryB.setClientId(dto.getClientId());
        //entryB.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDate()));
        return entryB;
    }

    @Override
    protected EntryDTO convertBeanToDto(EntryB bean) {
        final EntryDTO dto = new EntryDTO();
        dto.setId(bean.getId());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";

        try {
            dto.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(bean.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dto.setNumber(bean.getNumber());
        dto.setDiagnostic(bean.getDiagnostic());
        dto.setCarId(bean.getCarId());
        dto.setClientId(bean.getClientId());

        return dto;
    }
    public List<EntryB> find (String textToFind, int maxItems, int page) {
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
