package com.sd.isp.user

import com.sd.isp.beans.user.UserB;
import com.sd.isp.role.Role;

class User {
	String  userName
	String  name
	String  surName
	String  password
	static belongsTo = [role: Role]
	
	static constraints = {
		userName		blank:false, size:3..50
		name			blank: false, size:3..50
		surName			blank:false, size:1..50
		password		blank:false, size:1..10
	}
	
	public User(UserB user){
		this.id			= user.getId()
		this.userName	= user.getUserName()
		this.name		= user.getName()
		this.surName	= user.getSurName()
		this.password	= user.getPassword()
		this.role		= new Role(user.getRole())
	}
	
}

