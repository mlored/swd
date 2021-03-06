package com.sd.isp.role



import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.role.RoleB
import com.sd.isp.service.role.IRoleService

import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

@Transactional(readOnly = true)
class RoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	IRoleService roleService
	
	def create() {
		[roleInstance: new RoleB(params)]
	}
	
	@Transactional
	def save() {
		def rolerInstance = new RoleB(params)
		def newRole = roleService.save(roleInstance)
		if (!newRole?.getId()) {
			render(view: "create", model: [roleInstance: roleInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
				message(code: 'role.label', default: 'Role'),
				newUser.getId()
		])
		redirect(action: "index")
	}
	
	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def roles = roleService.getAll()
		[roleInstanceList: users, roleInstanceTotal: roles?.size()]
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

 @Transactional
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
	
    @Transactional
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
