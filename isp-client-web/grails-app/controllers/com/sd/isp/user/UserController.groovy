package com.sd.isp.user;

import com.sd.isp.beans.user.UserB
import com.sd.isp.beans.role.RoleB
import com.sd.isp.service.role.IRoleService
import com.sd.isp.service.user.IUserService
import com.sd.isp.service.auth.IAuthService;
import com.sd.isp.service.auth.AuthServiceImpl;

import grails.plugin.springsecurity.annotation.Secured

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;

import login.Util

class UserController{
  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def IUserService userService
  def IRoleService roleService
  
  @Autowired def IAuthService authService

  @Secured(['ROLE_SUPERUSER','ROLE_ADMIN'])
  def index(){
	def users = userService.getAll()
	[userInstanceList: users]
  }

  @Secured(['ROLE_SUPERUSER','ROLE_ADMIN'])
  def create() {
	  [userInstance: new UserB(params)]
  }

  @Secured(['ROLE_SUPERUSER','ROLE_ADMIN'])
  def save() {
	final Set<RoleB> roles = new HashSet<RoleB>();
	for (String roleId : params.list('rolesIds')) {
	  roles.add(roleService.getById(Integer.valueOf(roleId)));
	}

	def nuevoUser = new UserB(params)
	nuevoUser.setPassword(params.username)
	  nuevoUser.setRoles(roles);

	  def userInstance = userService.save(nuevoUser)


	  if (!userInstance.getId()) {
		  render(view: "create", model: [userInstance: userInstance])
		  return
	  }

	  flash.message = message(code: 'default.created.message', args: [
		  message(code: 'user.label', default: 'User'),
		  userInstance.getId()
	  ])
	  redirect(action: "index")
  }

  @Secured(['ROLE_SUPERUSER','ROLE_ADMIN'])
  def edit(Long id) {
	def userInstance = userService.getById(id.intValue())
	if (!userInstance) {
	  flash.message = message(code: 'default.not.found.message', args: [
		message(code: 'user.label', default: 'User'),
		id
	  ])
	  redirect(action: "list")
	  return
	}
	
	[userInstance: userInstance]
  }
    
  @Secured(['ROLE_SUPERUSER', 'ROLE_ADMIN'])
  def show(Long id) {
	  def userInstance = userService.getById(id.intValue())
	  if (!userInstance) {
		  flash.message = message(code: 'default.not.found.message', args: [
			  message(code: 'user.label', default: 'Usuario'),
			  id
		  ])
		  redirect(action: "list")
		  return
	  }

	   [userInstance: userInstance]
  }
  
  @Secured(['ROLE_SUPERUSER','ROLE_ADMIN'])
  def update(Long id, Long version) {
	def userInstance = userService.getById(id.intValue())
	if (!userInstance) {
	  flash.message = message(code: 'default.not.found.message', args: [
		message(code: 'user.label', default: 'User'),
		id
	  ])
	  redirect(action: "index")
	  return
	}

	if (userInstance.getUsername()==authService.getUsername()) {
	  flash.message = "No puedes editar tu registro de usuario"
	  redirect(action: "index")
	  return
	}

	final Set<RoleB> roles = new HashSet<RoleB>();
	for (String roleId : params.list('rolesIds')) {
	  roles.add(roleService.getById(Integer.valueOf(roleId)));
	}
	def username=userInstance.getUsername()
	def password=userInstance.getPassword()
	userInstance.create(params)
	userInstance.setRoles(roles)
	userInstance.setUsername(username)
	userInstance.setPassword(password)

	userService.save(userInstance)
	flash.message = message(code: 'default.updated.message', args: [
	  message(code: 'user.label', default: 'User'),
	  userInstance.getId()
	])
	redirect(action: "index")
  }

  @Secured(['ROLE_SUPERUSER','ROLE_ADMIN'])
  def delete(Long id) {
	def userInstance = userService.getById(id.intValue())

	  if (userInstance.getUsername()==authService.getUsername()) {
	  flash.message = "No puedes eliminar tu registro de usuario"
	  redirect(action: "index")
	  return
	}

	if (!userInstance) {
	  flash.message = message(code: 'default.not.found.message', args: [
		message(code: 'user.label', default: 'User'),
		id
	  ])
	  redirect(action: "index")
	  return
	}

	try {
	  userService.delete(id.intValue())
	  flash.message = message(code: 'default.deleted.message', args: [
		message(code: 'user.label', default: 'User'),
		id
	  ])
	  redirect(action: "index")
	}
	catch (DataIntegrityViolationException e) {
	  flash.message = message(code: 'default.not.deleted.message', args: [
		message(code: 'user.label', default: 'User'),
		id
	  ])
	  redirect(action: "index")
	}
  }
}
