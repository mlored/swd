package com.sd.isp.service.auth;

import grails.plugin.springsecurity.userdetails.GrailsUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sd.isp.beans.role.RoleB;
import com.sd.isp.beans.user.UserB;
import com.sd.isp.service.user.IUserService;

@Service("authService")
public class AuthServiceImpl implements IAuthService {
	@Autowired
	IUserService _userService;
	public AuthServiceImpl(){
	}

	public String getUsername(){
		GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDetails.getUsername();
	}

	public String getPassword(){
		GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDetails.getPassword();
	}
	
	public RoleB getRole(){
		UserB user = _userService.getByUsername(getUsername());
		return user.getRole();
	}

	public String getName() {
		UserB user = _userService.getByUsername(getUsername());
		return user.getName();
	}
}
