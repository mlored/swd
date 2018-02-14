package com.sd.isp.entry

import com.sd.isp.service.car.ICarService
import com.sd.isp.service.part.IPartService
import com.sd.isp.beans.entry.EntryB
import com.sd.isp.entry.Entry;
import com.sd.isp.entry_details.EntryDetails
import com.sd.isp.service.client.IClientService
import com.sd.isp.service.entry.IEntryService
import com.sd.isp.service.entry_details.IEntryDetailsService

class EntryController {

    static allowedMethods = [list: "GET",save: "POST", update: "PUT", delete: "DELETE"]

    IEntryService entryService
    IEntryDetailsService entryDetailsService
    IPartService partService
    IClientService clientService


    def index(Integer max){
        //def entries = entryService.getAll()
        //[entryList: entries, entryInstanceTotal: entries.size()]

        params.max = Math.min(max ?: 10, 100)
        redirect(action: "list", params: params)
    }
    def list(Integer max) {
        def entries = entryService.getAll()

        [entryInstanceList: entries, serviceInstanceTotal: entries?.size()]
    }

    def create() {
        [entryInstance: new Entry(params)]
        return

    }


    def save() {
        def newEntry = new EntryB(params)
        def entryInstance = entryService.save(newEntry)


        if (!entryInstance.getId()) {
            render(view: "create", model: [entryInstance: entryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'entry.label', default: 'Entry'),
                entryInstance.getId()
        ])
        redirect(action: "index")
    }


    def show(Long id) {
        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [entryInstance: entryInstance, cars: entryService.getAll()]
    }


    def edit(Long id) {
        def entryInstance = entryService.getById(id.intValue())

        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "list")
            return
        }


        [entryInstance: entryInstance]
    }


    def update(Long id) {
        def entryB = new EntryB(params)
        def entryInstance = entryService.update(id.intValue(), entryB)
        if (entryInstance == null) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entrada'),
                    id
            ])
            redirect(action: "list")
            return
        }

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'entry.label', default: 'Entrada'),
                entryInstance.id
        ])
        redirect(action: "list")
    }

    /*
    def delete(Long id) {

        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
            return
        }

        try {
            entryService.delete(id.intValue())
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
        }
        catch (Exception e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
        }
    }*/
}




