package com.sd.isp.user

import com.sd.isp.beans.user.UserB
import com.sd.isp.beans.role.RoleB
import com.sd.isp.service.role.IRoleService
import com.sd.isp.service.user.IUserService
import com.sd.isp.service.auth.IAuthService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class UserController{
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    IUserService userService
    IRoleService roleService

    //@Autowired def IAuthService authService

    def index(){
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        def users = userService.getAll()
        [userInstanceList: users, userInstanceTotal: users?.size()]
    }

    def create() {
        [userInstance: new UserB(params) , roleInstance:new RoleB(params),  roles:roleService.getAll()]
    }

    def save() {
        def nuevoRole = new RoleB (params)
        Set<RoleB> roles = new HashSet<>()

        for (String roleId : params.list('rolesIds')) {
          roles.add(roleService.getById(Integer.valueOf(params.roleId)));
        }

        def nuevoUser = new UserB(params)
        nuevoUser.setRoles(params.get("authority"))
        nuevoUser.setPassword(params.get("password"))
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

    @Secured(['ROLE_ADMIN', 'ROLE_SECRETARIO', 'ROLE_MECANICO'])
    def getByUsername(String username){
        def userInstance =  userService.find(username,10,0) //userService.getByUsername(username)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'user.label', default: 'Usuario'),
                    id
            ])
            redirect(action: "list")
            return
        }

        def userMatch = null
        userInstance.each {
            if (it.username == username){
                userMatch = it
            }
        }
        String result = "false"
        if (!userMatch) {
            result = "true"
        }
        response.setContentType("text/json;charset=UTF-8");
        render result
    }

    def update(Long id) {
        def userB= new UserB(params)
        def userInstance = userService.update(id.intValue(), userB)
        if (userInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'user.label', default: 'User'),
                    id
            ])
            redirect(action: "list")
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'user.label', default: 'User'),
                userInstance.id
        ])
        redirect(action: "list")
    }

    def delete(Long id) {
        def userInstance = userService.getById(id.intValue())

        //if (userInstance.getUsername()==authService.getUsername()) {
        //	flash.message = "No puedes eliminar tu registro de usuario"
        redirect(action: "index")
        return
        //}

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
