package com.sd.isp.service.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.person.PersonDaoImpl;
import com.sd.isp.dao.person.IPersonDao;
import com.sd.isp.domain.person.PersonDomain;
import com.sd.isp.dto.person.PersonDTO;
import com.sd.isp.dto.person.PersonResult;
import com.sd.isp.service.base.BaseServiceImpl;

@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonDTO, PersonDomain, PersonDaoImpl, PersonResult> implements IPersonService {

	@Autowired
	private IPersonDao personDao;

	@Override
	@Transactional
	public PersonDTO save(PersonDTO dto) {
		final PersonDomain personDomain = convertDtoToDomain(dto);
		final PersonDomain person = personDao.save(personDomain);
		return convertDomainToDto(person);
	}

	@Override
	@Transactional
	public PersonDTO getById(Integer id) {
		final PersonDomain personDomain = personDao.getById(id);
		final PersonDTO personDTO = convertDomainToDto(personDomain);
		return personDTO;
	}

	@Override
	@Transactional
	public PersonResult getAll() {
		final List<PersonDTO> persons = new ArrayList<>();
		for (PersonDomain domain : personDao.findAll()) {
			final PersonDTO person = convertDomainToDto(domain);
			persons.add(person);
		}

		final PersonResult personResult = new PersonResult();
		personResult.setPersons(persons);
		return personResult;
	}
	
	@Override
	public PersonDTO updateById(Integer id, PersonDTO dto) {
		final PersonDomain newDomain = convertDtoToDomain(dto);
		final PersonDomain domain = personDao.getById(id);
		domain.setName(newDomain.getName());
		domain.setSurName(newDomain.getSurName());
		domain.setRUC(newDomain.getRUC());
		domain.setCellphone(newDomain.getCellphone());
		domain.setAddress(newDomain.getAddress());
		final PersonDomain personDomain = personDao.save(domain);
		return convertDomainToDto(personDomain);
	}

	@Override
	public PersonDTO delete(Integer id) {
		final PersonDomain domain = personDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected PersonDTO convertDomainToDto(PersonDomain domain) {
		final PersonDTO person = new PersonDTO();
		person.setId(domain.getId());
		person.setName(domain.getName());
		person.setSurName(domain.getSurName());
		person.setRUC(domain.getRUC());
		person.setCellphone(domain.getCellphone());
		person.setAddress(domain.getAddress());
		return person;
	}

	@Override
	protected PersonDomain convertDtoToDomain(PersonDTO dto) {
		final PersonDomain person = new PersonDomain();
		person.setId(dto.getId());
		person.setName(dto.getName());
		person.setSurName(dto.getSurName());
		person.setRUC(dto.getRUC());
		person.setCellphone(dto.getCellphone());
		person.setAddress(dto.getAddress());
		return person;
	}

}
