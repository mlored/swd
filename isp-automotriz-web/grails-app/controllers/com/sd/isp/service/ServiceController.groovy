package com.sd.isp.service

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ServiceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Service.list(params), model:[serviceCount: Service.count()]
    }

    def show(Service service) {
        respond service
    }

    def create() {
        respond new Service(params)
    }

    @Transactional
    def save(Service service) {
        if (service == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (service.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond service.errors, view:'create'
            return
        }

        service.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'service.label', default: 'Service'), service.id])
                redirect service
            }
            '*' { respond service, [status: CREATED] }
        }
    }

    def edit(Service service) {
        respond service
    }

    @Transactional
    def update(Service service) {
        if (service == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (service.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond service.errors, view:'edit'
            return
        }

        service.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'service.label', default: 'Service'), service.id])
                redirect service
            }
            '*'{ respond service, [status: OK] }
        }
    }

    @Transactional
    def delete(Service service) {

        if (service == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        service.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'service.label', default: 'Service'), service.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
