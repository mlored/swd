package com.sd.isp.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.role.RoleDomain;

@Entity
@Table(name = "users")
public class UserDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "username", nullable = false, length = 50, unique = true)
	private String username;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "surName", nullable = false, length = 50)
	private String surName;

	@Column(name = "password", nullable = false, length = 60)
	private String password;
	
	@Column(name = "enabled", nullable = true)
	private Boolean enabled;
	
	@Column(name = "account_locked", nullable = true)
	private Boolean accountLocked;
	
	@Column(name = "password_expired", nullable = true)
	private Boolean passwordExpired;

	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
		    name="users_roles",
		    joinColumns= @JoinColumn(name="user_id", referencedColumnName="id"),
		    inverseJoinColumns= @JoinColumn(name="role_id", referencedColumnName="id")
    )
	private Set<RoleDomain> role;
	
	public Set<RoleDomain> getRole(){
		return role;
	}
	
	public void setRole(Set<RoleDomain> role){
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String _password/*, Integer userId*/) {
	/*	if(userId==null){
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(_password);
			
			this.password = hashedPassword;
		}else{
			this.password = _password;
		}
		*/
		this.password = _password;
	}


	public String getAccountLocked() {
		return accountLocked.toString();
	}

	public void setAccountLocked(String _accountLocked) {
		this.accountLocked = Boolean.valueOf(_accountLocked);
	}

	public String getPasswordExpired() {
		return passwordExpired.toString();
	}

	public void setPasswordExpired(String _passwordExpired) {
		this.passwordExpired = Boolean.valueOf(_passwordExpired);
	}
	
}
