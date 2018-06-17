package com.sd.isp.service.support;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.support.SupportDaoImpl;
import com.sd.isp.dao.support.ISupportDao;
import com.sd.isp.domain.support.SupportDomain;
import com.sd.isp.dto.support.SupportDTO;
import com.sd.isp.dto.support.SupportResult;
import com.sd.isp.service.base.BaseServiceImpl;


@Service
public class SupportServiceImpl extends BaseServiceImpl<SupportDTO, SupportDomain, SupportDaoImpl, SupportResult> implements ISupportService{
	@Autowired
	private ISupportDao supportDao;
	
	
	
	@Value("${mail.username:lpatologico@gmail.com}")
	private String username;
	
	@Value("${mail.password:lpatologico}")
	private String password;

	
	@Override
	@Transactional
	public SupportDTO save(SupportDTO dto) {
		
			final SupportDomain supportDomain = convertDtoToDomain(dto);
			final SupportDomain support = supportDao.save(supportDomain);
			final SupportDTO newDto = convertDomainToDto(support);
			//mailMail.sendMail(to, dear, content);
			return newDto;
		
	}

	@Override
	@Transactional(readOnly = true)
	public SupportDTO getById(Integer id) {
		final SupportDomain supportDomain = supportDao.getById(id);
		final SupportDTO supportDTO = convertDomainToDto(supportDomain);
		return supportDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public SupportResult getAll() {
		return null;
	}

	
	
	@Override
	protected SupportDTO convertDomainToDto(SupportDomain domain){
		final SupportDTO support = new SupportDTO();
		support.setId(domain.getId());
		support.setName(domain.getName());
		support.setMessage(domain.getMessage());
		support.setSubject(domain.getSubject());
		support.setPhone(domain.getPhone());
		support.setEmail(domain.getEmail());
		return support;
	}

	@Override
	protected SupportDomain convertDtoToDomain(SupportDTO dto){
		final SupportDomain support = new SupportDomain();
		support.setId(dto.getId());
		support.setName(dto.getName());
		support.setMessage(dto.getMessage());
		support.setSubject(dto.getSubject());
		support.setPhone(dto.getPhone());
		support.setEmail(dto.getEmail());
		return support;
	}

	@Override
	public SupportDTO updateById(Integer id, SupportDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupportDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupportResult find(String textToFind, int page, int maxItems) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
		

}