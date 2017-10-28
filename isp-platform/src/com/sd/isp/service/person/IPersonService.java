package com.sd.isp.service.person;

import com.sd.isp.dao.person.PersonDaoImpl;
import com.sd.isp.domain.person.PersonDomain;
import com.sd.isp.dto.person.PersonDTO;
import com.sd.isp.dto.person.PersonResult;
import com.sd.isp.service.base.IBaseService;

public interface IPersonService extends IBaseService<PersonDTO, PersonDomain, PersonDaoImpl, PersonResult> {

}