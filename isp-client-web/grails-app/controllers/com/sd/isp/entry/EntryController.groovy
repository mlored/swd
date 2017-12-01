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

    static allowedMethods = [list: "GET",save: "POST", update: "POST", delete: "POST"]

    def IEntryService entryService
    def IEntryDetailsService entryDetailsService
    def ICarService carService
    def IPartService partService
    def IClientService clientService


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
        List<EntryDetails> entryDetails;
        [entryInstance: new Entry(params), cars: carService.getAll(),
         clients: clientService.getAll(), entryDetails: entryDetails]
        return

    }


    def save() {
        def car= carService.getById(Integer.valueOf(params.car.id))
        def client= clientService.getById(Integer.valueOf(params.client.id))


        def newEntry = new EntryB(params)
        newEntry.setCar(car)
        newEntry.setCliente(client)

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

        [entryInstance: entryInstance, cars: carService.getAll()]
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
        Map<String,String> args = new HashMap<String,String>();
        args.put("entryId",entryInstance.getId().toString())
        def entry_details = entryDetailsService.getAllBy(args)

        System.out.println(entry_details.size())

        [entryInstance: entryInstance, car: carService.getAll(),
         client: clientService.getAll(), entry: entry_details]
    }


    /*def update(Long id, Long version) {
        def entryInstance = entryService.getById(id.intValue())
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
            return
        }

        def car= carService.getById(Integer.valueOf(params.car.id))
        if (!car) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'entry.label', default: 'Entry'),
                    id
            ])
            redirect(action: "index")
            return
        }

        redirect(action: "index")
    }*/

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




