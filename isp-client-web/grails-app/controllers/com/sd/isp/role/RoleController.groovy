package com.sd.isp.role

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.role.RoleB
import com.sd.isp.service.role.IRoleService
import com.sd.isp.service.role.RoleServiceImpl

import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

@Secured(["ROLE_ADMIN"])
class RoleController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	IRoleService roleService
	
	def create() {
		[roleInstance: new RoleB(params)]
	}
	
	def save() {
		def roleInstance = new RoleB(params)
		def newRole = roleService.save(roleInstance)
		if (!newRole?.getId()) {
			render(view: "create", model: [roleInstance: roleInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
				message(code: 'role.label', default: 'Role'),
				newRole.getId()
		])
		redirect(action: "index")
	}
	
	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def text = params.text
		roleService=new RoleServiceImpl()
		def roles = roleService.getAll()

		if(null != text && !"".equals(text)){

			roles = roleService.find(text)



		}else{
			roles = roleService.getAll()
		}

		[roleInstanceList: roles, roleInstanceTotal: roles?.size()]
	}

/*    def show(Role roleInstance) {
        respond roleInstance
    }
*/

    def edit(Long id) {
		def roleInstance = roleService.getById(id.intValue())
		if (!roleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'role.label', default: 'Role'),
					id
			])
			redirect(action: "list")
			return
		}
		[roleInstance: roleInstance]
	}

    def update(Long id) {
        def roleInstance = roleService.getById(id.intValue())
        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'role.label', default: 'Role'),
                    id
            ])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (roleInstance.version > version) {
                roleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [
                                message(code: 'role.label', default: 'Role')] as Object[],
                        "Another role has updated this User while you were editing")
                render(view: "edit", model: [roleInstance: roleInstance])
                return
            }
        }

        roleInstance.properties = params

        if (!roleInstance.save(flush: true)) {
            render(view: "edit", model: [roleInstance: roleInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'role.label', default: 'Role'),
                roleInstance.id
        ])
        redirect(action: "show", id: roleInstance.id)
    }
	
    def delete(Long id) {
        def roleInstance = roleService.getById(id.intValue())
        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'role.label', default: 'Role'),
                    id
            ])
            redirect(action: "list")
            return
        }
		
		try {
			roleService.delete(roleInstance?.id)
			roleInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'role.label', default: 'Role'),
					id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
					message(code: 'role.label', default: 'Role'),
					id
			])
			redirect(action: "show", id: id)
		}
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
