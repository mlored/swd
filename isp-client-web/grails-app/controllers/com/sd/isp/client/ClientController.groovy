package com.sd.isp.client
import static org.springframework.http.HttpStatus.*
import com.sd.isp.beans.client.ClientB
import com.sd.isp.service.client.IClientService;
import grails.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException

@Transactional(readOnly = true)
class ClientController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	IClientService clientService

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def clients = clientService.getAll()

		respond clients, [model: [clientInstanceList: clients, clientInstanceTotal: clients?.size()]]
	}

	def show(Client clientInstance) {
		respond clientInstance
	}

	def create() {
		respond new Client(params)
	}

	//@Transactional
	def save(){
		def clientInstance = new ClientB(params)
		def newClient = clientService.save(clientInstance)
		if (!newClient?.getId()) {
			render(view: "create", model: [clientInstance: clientInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
				message(code: 'client.label', default: 'Client'),
				newClient.getId()
		])
		redirect(action: "index")
		/*if (clientInstance == null) {
			notFound()
			return
		}

		if (clientInstance.hasErrors()) {
			respond clientInstance.errors, view:'create'
			return
		}

		clientInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'client.label', default: 'Client'), clientInstance.id])
				redirect clientInstance
			}
			'*' { respond clientInstance, [status: CREATED] }
		}*/
	}

	def edit(Long id) {
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
		//respond clientInstance
	}

	@Transactional
	def update(Long id) {
		/*if (clientInstance == null) {
			notFound()
			return
		}

		if (clientInstance.hasErrors()) {
			respond clientInstance.errors, view:'edit'
			return
		}

		clientInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Client.label', default: 'Client'), clientInstance.id])
				redirect clientInstance
			}
			'*'{ respond clientInstance, [status: OK] }
		}*/
		def clientInstance = clientService.getById(id.intValue())
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

	@Transactional
	def delete(Long id) {
		def clientInstance = clientService.getById(id.intValue())
		if (!clientInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'client.label', default: 'Client'),
					id
			])
			redirect(action: "list")
			return
		}

		try {
			clientService.delete(clientInstance?.id)
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
		/*if (clientInstance == null) {
			notFound()
			return
		}

		clientInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'Client.label', default: 'Client'), clientInstance.id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}*/
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'client.label', default: 'Client'), params.id])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
