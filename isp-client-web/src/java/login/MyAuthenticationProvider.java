package login;

import com.sd.isp.service.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import grails.plugin.springsecurity.userdetails.GrailsUser;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;

import com.sd.isp.beans.role.RoleB;
import com.sd.isp.beans.user.UserB;
import com.sd.isp.service.user.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class MyAuthenticationProvider implements AuthenticationProvider {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private IUserService _userService;

	@Autowired
	private IAuthService authService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String username = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());			
		UserB user = _userService.getByUsername(username, password);
		if(user!=null){
			if (passwordEncoder.matches(password, user.getPassword())) {
				List<GrantedAuthority> authorities = getUserRoles(user);
				if(authorities != null){
					Boolean enabled=Boolean.valueOf(user.getAccountLocked());
					GrailsUser userDetails = new GrailsUser(username, password, enabled, true, true, true, authorities, 1);
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
					token.setDetails(authentication.getDetails());
					return token;
				}throw new BadCredentialsException("Log in failed: El usuario no tiene ningun rol");
			}else throw new BadCredentialsException("Log in failed: Password incorrecto"); 			
		}
		return auth;
	}
	
	private List getUserRoles(UserB user) {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();		
		final Set<RoleB> roles = user.getRoles();
		if(roles!=null){
			System.out.print("Roles del usuario "+user.getUsername()+" ");
			for (RoleB roleB : roles) {
				list.add(new GrantedAuthorityImpl(roleB.getAuthority()));
				System.out.print(roleB.getAuthority()+" ");
			}
		}
		return list;
	}

	@Override
	public boolean supports(Class<?> arg0) {		
		return true;
	}
	
}
