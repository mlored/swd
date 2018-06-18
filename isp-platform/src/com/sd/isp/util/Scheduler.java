package com.sd.isp.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.client.IClientDao;
import com.sd.isp.domain.client.ClientDomain;
import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.service.cliente.IClientService;

@Service
public class Scheduler {
	
	@Autowired
	private IClientDao clientDao;
	
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
			for (ClientDomain domain : clientDao.findAll()) {
				domain.setName("Adrian");
				clientDao.save(domain);
			}
	        //System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
		}
    }
}
