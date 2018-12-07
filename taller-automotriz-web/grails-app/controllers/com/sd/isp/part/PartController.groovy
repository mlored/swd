package com.sd.isp.part

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PartController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Part.list(params), model:[partCount: Part.count()]
    }

    def show(Part part) {
        respond part
    }

    def create() {
        respond new Part(params)
    }

    @Transactional
    def save(Part part) {
        if (part == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (part.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond part.errors, view:'create'
            return
        }

        part.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'part.label', default: 'Part'), part.id])
                redirect part
            }
            '*' { respond part, [status: CREATED] }
        }
    }

    def edit(Part part) {
        respond part
    }

    @Transactional
    def update(Part part) {
        if (part == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (part.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond part.errors, view:'edit'
            return
        }

        part.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'part.label', default: 'Part'), part.id])
                redirect part
            }
            '*'{ respond part, [status: OK] }
        }
    }

    @Transactional
    def delete(Part part) {

        if (part == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        part.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'part.label', default: 'Part'), part.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'part.label', default: 'Part'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
