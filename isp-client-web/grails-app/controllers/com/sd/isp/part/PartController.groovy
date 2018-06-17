package com.sd.isp.part

import com.sd.isp.beans.part.PartB
import com.sd.isp.service.part.IPartService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

@Transactional(readOnly = true)
class PartController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	IPartService partService
	
	def create() {
		respond new PartB(params)
	}

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }
	
	def list(Integer max) {
		def parts = partService.getAll()
		[partInstanceList: parts, partInstanceTotal: parts?.size()]
	}

    /*def show(Long id) {
        def partInstance = partService.getById(id.intValue())
        if (!partInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [partInstance: partInstance]
    }*/

    @Transactional
    def save(){
        def partInstance = new PartB(params)
        def newPart = partService.save(partInstance)
        if (!newPart?.getId()) {
            render(view: "create", model: [partInstance: partInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'part.label', default: 'Part'),
                newPart.getId()
        ])
        redirect(action: "index")

    }

    def edit(Long id) {
        def partInstance = partService.getById(id.intValue())
        if (!partInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [partInstance: partInstance]
    }

    @Transactional
    def update(Long id) {
        def partB= new PartB(params)
        def partInstance = partService.update(id.intValue(), partB)
        if (partInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "list")
            return
        }

        /*if (!partInstance.save(flush: true)) {
            render(view: "edit", model: [partInstance: partInstance])
            return
        }*/

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'part.label', default: 'Part'),
                partInstance.id
        ])
        redirect(action: "list")
    }

    def delete(Long id) {

        try {
            partService.delete(id.intValue())
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'part.label', default: 'Part'),
                    id
            ])
            redirect(action: "show", id: id)
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
