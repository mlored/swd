package com.sd.isp.service
import static org.springframework.http.HttpStatus.*
import com.sd.isp.beans.service.ServiceB
import com.sd.isp.service.service.IServiceService;
import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

@Transactional(readOnly = true)
class ServiceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    IServiceService serviceService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        def services = serviceService.getAll()
        [serviceInstanceList: services, serviceInstanceTotal: services?.size()]
    }
	
	/*def show(Long id) {
		 def serviceInstance = serviceService.getById(id.intValue())
		 if (!serviceInstance) {
			 flash.message = message(code: 'default.not.found.message', args: [
					 message(code: 'service.label', default: 'Service'),
					 id
			 ])
			 redirect(action: "list")
			 return
		 }
	
		 [serviceInstance: serviceInstance]
	}*/

    def create() {
        respond new Service(params)
    }

    @Transactional
    def save(){
        def serviceInstance = new ServiceB(params)
        def newService = serviceService.save(serviceInstance)
        if (!newService?.getId()) {
            render(view: "create", model: [serviceInstance: serviceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'service.label', default: 'Service'),
                newService.getId()
        ])
        redirect(action: "index")

    }

    def edit(Long id) {
        def serviceInstance = serviceService.getById(id.intValue())
        if (!serviceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [serviceInstance: serviceInstance]
        //respond serviceInstance
    }

    @Transactional
    def update(Long id) {
        def serviceB= new ServiceB(params)
        def serviceInstance = serviceService.update(id.intValue(), serviceB)
        if (serviceInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
            return
        }

        /*if (!serviceInstance.save(flush: true)) {
            render(view: "edit", model: [serviceInstance: serviceInstance])
            return
        }*/

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'service.label', default: 'Service'),
                serviceInstance.id
        ])
        redirect(action: "list")
    }

    @Transactional
    def delete(Long id) {
        def serviceInstance = serviceService.getById(id.intValue())
        if (!serviceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
            return
        }

        try {
            serviceService.delete(serviceInstance?.id)
            serviceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "show", id: id)
        }
        /*if (serviceInstance == null) {
            notFound()
            return
        }

        serviceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Service.label', default: 'Service'), serviceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'service.label', default: 'Service'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
