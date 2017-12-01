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
		//respond new Employee(params)
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

     def edit(Long id) {
        def employeeInstance = employeeService.getById(id.intValue())
        if (!employeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'employee.label', default: 'Employee'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [employeeInstance: employeeInstance]
    }

	 def update(Long id) {
		 def employeeB= new EmployeeB(params)
		 def employeeInstance = employeeService.update(id.intValue(), employeeB)
		 if (employeeInstance == null) {
			 flash.message = message(code: 'default.not.found.message', args: [
					 message(code: 'employee.label', default: 'Part'),
					 id
			 ])
			 redirect(action: "list")
			 return
		 }

		 /*if (!employeeInstance.save(flush: true)) {
			 render(view: "edit", model: [employeeInstance: employeeInstance])
			 return
		 }*/
 
		 flash.message = message(code: 'default.updated.message', args: [
				 message(code: 'employee.label', default: 'Part'),
				 employeeInstance.id
		 ])
		 redirect(action: "list")
	 }

    @Transactional
	def delete(Long id) {
		
		try {
			employeeService.delete(id.intValue())
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'part.label', default: 'Part'),
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
