package com.sd.isp.part

import com.sd.isp.beans.part.PartB
import com.sd.isp.service.part.IPartService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PartController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	IPartService partService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        //respond Part.list(params), model:[partInstanceCount: Part.count()]
		redirect(action: "list", params: params)
    }
	
	def list(Integer max) {
		def parts = partService.getAll()

		[partInstanceList: parts, partInstanceTotal: parts?.size()]
	}

    def show(Part partInstance) {
        respond partInstance
    }

    def create() {
        respond new Part(params)
    }

    @Transactional
    def save(Part partInstance) {
        if (partInstance == null) {
            notFound()
            return
        }

        if (partInstance.hasErrors()) {
            respond partInstance.errors, view:'create'
            return
        }

        partInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'part.label', default: 'Part'), partInstance.id])
                redirect partInstance
            }
            '*' { respond partInstance, [status: CREATED] }
        }
    }

    def edit(Part partInstance) {
        respond partInstance
    }

    @Transactional
    def update(Part partInstance) {
        if (partInstance == null) {
            notFound()
            return
        }

        if (partInstance.hasErrors()) {
            respond partInstance.errors, view:'edit'
            return
        }

        partInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Part.label', default: 'Part'), partInstance.id])
                redirect partInstance
            }
            '*'{ respond partInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Part partInstance) {

        if (partInstance == null) {
            notFound()
            return
        }

        partInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Part.label', default: 'Part'), partInstance.id])
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
