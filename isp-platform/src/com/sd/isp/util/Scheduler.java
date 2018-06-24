package com.sd.isp.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.client.IClientDao;
import com.sd.isp.dao.user.IUserDao;
import com.sd.isp.domain.user.UserDomain;
import com.sd.isp.util.MailMail;

@Service
public class Scheduler {
	
	@Autowired
	private IUserDao userDao;
	@Autowired
	private MailMail mailMail;
	
	@Value("${cron.enabled}")
    private boolean enabled;
	
	/* Este metodo se ejecuta automaticamente cada 1 minuto, renombrando todos los cliente a nombre Adrian */
	@Scheduled(cron = "${cron.expression}")
    //@Scheduled(fixedRate = 5000)
	@Transactional
	@Async
    public void execute()
    {
		
		if (enabled) {
			for (UserDomain domain : userDao.findAll()) {
				if(domain.getAccountLocked() == "true"){
					domain.setAccountLocked("false");
					mailMail.sendMail(domain.getUsername(), domain.getName(), "Usuario desbloqueado");
				}
				userDao.save(domain);
			}
		}
    }
}
