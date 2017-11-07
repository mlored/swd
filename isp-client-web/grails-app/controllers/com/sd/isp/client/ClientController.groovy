package com.sd.isp.client

import org.springframework.dao.DataIntegrityViolationException

import com.sd.isp.beans.client.ClientB
import com.sd.isp.service.client.IClientService

class ClientController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//services
	def IClientService clientService

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def clients = clientService.getAll()

		[clientInstanceList: clients, clientInstanceTotal: clients?.size()]
	}

	def create() {
		[clientInstance: new ClientB(params), cities:cityService.getAll()]
	}

	def save() {
		def clientInstance = new ClientB(params)
		clientInstance.setCity(cityService.getById(Integer.valueOf(params.cityId)))
		def newClient= clientService.save(clientInstance)
		if (!newClient?.getId()) {
			render(view: "create", model: [clientInstance: clientInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'client.label', default: 'Client'),
			newClient.getId()
		])
		redirect(action: "show", id: newClient.getId())
	}

	def show(Long id) {
		def clientInstance = clientService.getById(id.intValue())
		if (!clientInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'client.label', default: 'Client'),
				id
			])
			redirect(action: "list")
			return
		}

		[clientInstance: clientInstance]
	}

	def edit(Long id) {
		def clientInstance = Client.get(id)
		if (!clientInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'client.label', default: 'Client'),
				id
			])
			redirect(action: "list")
			return
		}

		[clientInstance: clientInstance]
	}

	def update(Long id, Long version) {
		def clientInstance = Client.get(id)
		if (!clientInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'client.label', default: 'Client'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (clientInstance.version > version) {
				clientInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'client.label', default: 'Client')] as Object[],
						"Another user has updated this Client while you were editing")
				render(view: "edit", model: [clientInstance: clientInstance])
				return
			}
		}

		clientInstance.properties = params

		if (!clientInstance.save(flush: true)) {
			render(view: "edit", model: [clientInstance: clientInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'client.label', default: 'Client'),
			clientInstance.id
		])
		redirect(action: "show", id: clientInstance.id)
	}

	def delete(Long id) {
		def clientInstance = Client.get(id)
		if (!clientInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'client.label', default: 'Client'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			clientInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'client.label', default: 'Client'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'client.label', default: 'Client'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
}
