package com.sd.isp.user



import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.user.UserB
import com.sd.isp.service.user.IUserService
import com.sd.isp.service.role.IRoleService

import grails.transaction.Transactional

import org.springframework.dao.DataIntegrityViolationException

@Transactional(readOnly = true)
class UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	IUserService userService
	IRoleService roleService
	
	def create() {
		[userInstance: new UserB(params)]
	}
	
	@Transactional
	def save() {
		def userInstance = new UserB(params)
		def newUser = userService.save(userInstance)
		if (!newUser?.getId()) {
			render(view: "create", model: [userInstance: userInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
				message(code: 'user.label', default: 'User'),
				newUser.getId()
		])
		redirect(action: "index")
	}
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

	def list(Integer max) {
		def users = userService.getAll()
		[userInstanceList: users, userInstanceTotal: users?.size()]
	}
	
/*    def show(User userInstance) {
        respond userInstance
    }
*/

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

    @Transactional
    def update(Long id) {
        def userInstance = userService.getById(id.intValue())
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'user.label', default: 'User'),
                    id
            ])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [
                                message(code: 'car.label', default: 'User')] as Object[],
                        "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'user.label', default: 'User'),
                userInstance.id
        ])
        redirect(action: "show", id: userInstance.id)
    }
    @Transactional
    def delete(Long id) {
        def userInstance = userService.getById(id.intValue())
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'user.label', default: 'User'),
                    id
            ])
            redirect(action: "list")
            return
        }
		
		try {
			userService.delete(userInstance?.id)
			userInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'user.label', default: 'User'),
					id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
					message(code: 'user.label', default: 'User'),
					id
			])
			redirect(action: "show", id: id)
		}
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
