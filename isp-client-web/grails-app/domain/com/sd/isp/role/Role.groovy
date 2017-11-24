package com.sd.isp.role

import com.sd.isp.beans.role.RoleB
import com.sd.isp.user.User

class Role {
	String  name
	static hasMany = [users: User]
	
	static constraints = {
		name			blank: false, size:3..50
	}
	
	public Role(RoleB role){
		this.id			= role.getId()
		this.name		= role.getName()
	}
}
