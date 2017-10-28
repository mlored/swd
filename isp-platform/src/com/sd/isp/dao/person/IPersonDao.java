package com.sd.isp.dao.person;

import java.util.List;

import com.sd.isp.dao.base.IBaseDao;
import com.sd.isp.domain.person.PersonDomain;

public interface IPersonDao extends IBaseDao<PersonDomain> {

	public List<PersonDomain> findByName(String textToFind);

}