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

    def show(Service serviceInstance) {
        respond serviceInstance
    }

    def create() {
        respond new Service(params)
    }

    //@Transactional
    def save(){
        def serviceInstance = new ServiceB(params)
        //serviceInstance.set
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
        /*if (serviceInstance == null) {
            notFound()
            return
        }

        if (serviceInstance.hasErrors()) {
            respond serviceInstance.errors, view:'create'
            return
        }

        serviceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'service.label', default: 'Service'), serviceInstance.id])
                redirect serviceInstance
            }
            '*' { respond serviceInstance, [status: CREATED] }
        }*/
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
        /*if (serviceInstance == null) {
            notFound()
            return
        }

        if (serviceInstance.hasErrors()) {
            respond serviceInstance.errors, view:'edit'
            return
        }

        serviceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Service.label', default: 'Service'), serviceInstance.id])
                redirect serviceInstance
            }
            '*'{ respond serviceInstance, [status: OK] }
        }*/
        def serviceInstance = serviceService.getById(id.intValue())
        if (!serviceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'service.label', default: 'Service'),
                    id
            ])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (serviceInstance.version > version) {
                serviceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [
                                message(code: 'service.label', default: 'Service')] as Object[],
                        "Another user has updated this Service while you were editing")
                render(view: "edit", model: [serviceInstance: serviceInstance])
                return
            }
        }

        serviceInstance.properties = params

        if (!serviceInstance.save(flush: true)) {
            render(view: "edit", model: [serviceInstance: serviceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'service.label', default: 'Service'),
                serviceInstance.id
        ])
        redirect(action: "show", id: serviceInstance.id)
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
