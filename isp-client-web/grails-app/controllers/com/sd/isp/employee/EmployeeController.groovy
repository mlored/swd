package com.sd.isp.employee
import static org.springframework.http.HttpStatus.*

import com.sd.isp.beans.employee.EmployeeB
import com.sd.isp.service.employee.IEmployeeService;

import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

@Transactional(readOnly = true)
class EmployeeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	IEmployeeService employeeService
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		redirect(action: "list", params: params)
    }
	
	def list(Integer max) {
		def employees = employeeService.getAll()

		[employeeInstanceList: employees, employeeInstanceTotal: employees?.size()]
	}

    /* def show(Long id) {
        def employeeInstance = employeeService.getById(id.intValue())
        if (!employeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'employee.label', default: 'Country'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [employeeInstance: employeeInstance]
    }*/

    def create() {
        [employeeInstance: new EmployeeB(params)]
    }

    @Transactional
	def save() {
		def employeeInstance = new EmployeeB(params)
		def newEmployee = employeeService.save(employeeInstance)
		if (!newEmployee?.getId()) {
			render(view: "create", model: [employeeInstance: employeeInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
				message(code: 'employee.label', default: 'Employee'),
				newEmployee.getId()
		])
		 redirect(action: "index")
	}

    def edit(Employee employeeInstance) {
        respond employeeInstance
    }

    @Transactional
    def update(Employee employeeInstance) {
        if (employeeInstance == null) {
            notFound()
            return
        }

        if (employeeInstance.hasErrors()) {
            respond employeeInstance.errors, view:'edit'
            return
        }

        employeeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Employee.label', default: 'Employee'), employeeInstance.id])
                redirect employeeInstance
            }
            '*'{ respond employeeInstance, [status: OK] }
        }
    }

    @Transactional
	def delete(Long id) {
		def employeeInstance = Employee.get(id)
		if (!employeeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'employee.label', default: 'Employee'),
				id
			])
			redirect(action: "list")
			return
		}
		try {
			employeeInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'employee.label', default: 'Employee'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'employee.label', default: 'Employee'),
				id
			])
			redirect(action: "show", id: id)
		}
		
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
