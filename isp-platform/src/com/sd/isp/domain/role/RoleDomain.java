package com.sd.isp.domain.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.user.UserDomain;

@Entity
@Table(name = "roles")
public class RoleDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "authority", nullable = false, length = 50, unique = true)
	private String authority;
	
	@OneToMany(mappedBy = "_role")
	private Set<UserDomain> _users = new HashSet<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public Set<UserDomain> getUsers() {
		return _users;
	}

	public void setUsers(Set<UserDomain> users) {
		this._users = users;
	}

}
