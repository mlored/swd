package com.sd.isp.service.auth;

//import grails.plugin.springsecurity.userdetails.GrailsUser;

//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("AuthService")
public class AuthServiceImpl implements IAuthService {
		
	public AuthServiceImpl(){		
	}	
	
	public String getUsername(){
		//GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//return userDetails.getUsername();
        return "";
	}	
	
	public String getPassword(){
		//GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//return userDetails.getPassword();
        return "";
	}
}
