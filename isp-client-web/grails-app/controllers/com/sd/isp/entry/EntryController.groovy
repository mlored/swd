package com.sd.isp.entry

import com.sd.isp.beans.entry.EntryB
import com.sd.isp.service.entry.IEntryService
import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class EntryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    IEntryService entryService

    def create() {
        [entryInstance: new EntryB(params)]
    }

    def save() {
        def entryInstance = new EntryB(params)
        def newCar = entryService.save(entryInstance)
        if (!newCar?.getId()) {
            render(view: "create", model: [entryInstance: entryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'entry.label', default: 'Car'),
                newCar.getId()
        ])
        redirect(action: "index")
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        def cars = entryService.getAll()
        [entryInstanceList: cars, entryInstanceTotal: cars?.size()]
    }

    /*def show(Long id) {
        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [entryInstance: entryInstance]
    }*/

    def edit(Long id) {
        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [entryInstance: entryInstance]
    }

    def update(Long id) {
        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (entryInstance.version > version) {
                entryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [
                                message(code: 'entry.label', default: 'Car')] as Object[],
                        "Another user has updated this Car while you were editing")
                render(view: "edit", model: [entryInstance: entryInstance])
                return
            }
        }

        entryInstance.properties = params

        if (!entryInstance.save(flush: true)) {
            render(view: "edit", model: [entryInstance: entryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'entry.label', default: 'Car'),
                entryInstance.id
        ])
        redirect(action: "show", id: entryInstance.id)
    }

    def delete(Long id) {
        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
            return
        }

        try {
            entryService.delete(entryInstance?.id)
            entryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'entry.label', default: 'Car'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'entry.label', default: 'Car'),
                    id
            ])
            redirect(action: "show", id: id)
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entry.label', default: 'EntryB'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
