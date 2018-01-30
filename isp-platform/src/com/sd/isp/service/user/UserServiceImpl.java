package com.sd.isp.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.user.IUserDao;
import com.sd.isp.dao.user.UserDaoImpl;
import com.sd.isp.domain.user.UserDomain;
import com.sd.isp.dto.entry_details.EntryDetailsResult;
import com.sd.isp.dto.user.UserDTO;
import com.sd.isp.dto.user.UserResult;
import com.sd.isp.service.base.BaseServiceImpl;
import com.sd.isp.service.util.MailMail;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserDaoImpl, UserResult> implements IUserService {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private MailMail mailMail;

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		final UserDomain userDomain = convertDtoToDomain(dto);
		final UserDomain user = userDao.save(userDomain);
		return convertDomainToDto(user);
	}

	@Override
	@Transactional
	public UserDTO getById(Integer id) {
		final UserDomain userDomain = userDao.getById(id);
		final UserDTO userDTO = convertDomainToDto(userDomain);
		
		String to = "iceberg.04@gmail.com";
        String dear = "Adrian";
        String content = "Que tal?";
		
		try {
			mailMail.sendMail(to, dear, content);
		}catch( Exception e ){
			e.printStackTrace();
			System.out.println("Error");
			//logger.info("Error Sending Email: " + e.getMessage());
		}
		// FIN EJEMPLO ENVIO DE MAIL
		return userDTO;
	}

	@Override
	@Transactional
	public UserResult getAll() {
		final List<UserDTO> users = new ArrayList<>();
		for (UserDomain domain : userDao.findAll()) {
			final UserDTO user = convertDomainToDto(domain);
			users.add(user);
		}

		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}
	
	@Override
	public UserDTO updateById(Integer id, UserDTO dto) {
		final UserDomain newDomain = convertDtoToDomain(dto);
		final UserDomain domain = userDao.getById(id);
		domain.setUserName(newDomain.getUserName());
		domain.setName(newDomain.getName());
		domain.setSurName(newDomain.getSurName());
		domain.setPassword(newDomain.getPassword());
		final UserDomain userDomain = userDao.save(domain);
		return convertDomainToDto(userDomain);
	}

	@Override
	public UserDTO delete(Integer id) {
		final UserDomain domain = userDao.delete(id);
		return convertDomainToDto(domain);
	}

	@Override
	protected UserDTO convertDomainToDto(UserDomain domain) {
		final UserDTO user = new UserDTO();
		user.setId(domain.getId());
		user.setUserName(domain.getUserName());
		user.setName(domain.getName());
		user.setSurName(domain.getSurName());
		user.setPassword(domain.getPassword());
		return user;
	}

	@Override
	protected UserDomain convertDtoToDomain(UserDTO dto) {
		final UserDomain user = new UserDomain();
		user.setId(dto.getId());
		user.setUserName(dto.getUserName());
		user.setName(dto.getName());
		user.setSurName(dto.getSurName());
		user.setPassword(dto.getPassword());
		return user;
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserResult find(String textToFind, int page, int maxItems) throws Exception {
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
