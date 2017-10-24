package com.sd.isp.city

import org.springframework.dao.DataIntegrityViolationException

import com.sd.isp.beans.city.CityB
import com.sd.isp.service.city.ICityService
import com.sd.isp.service.country.ICountryService
import com.sd.isp.service.state.IStateService


class CityController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def ICityService cityService
	def IStateService stateService
	def ICountryService countryService

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def cities = cityService.getAll()
		[cityInstanceList: cities, cityInstanceTotal: cities.size()]
	}

	def create() {
		[cityInstance: new City(params), states:stateService.getAll()]
	}

	def save() {
		def state = stateService.getById(Integer.valueOf(params.stateId))
		def country = countryService.getById(state.getCountry().getId())

		def newCity = new CityB(params)
		newCity.setState(state)
		newCity.setCountry(country)
		def cityInstance = cityService.save(newCity)

		if (!cityInstance.getId()) {
			render(view: "create", model: [cityInstance: cityInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'city.label', default: 'City'),
			cityInstance.getId()
		])
		redirect(action: "show", id: cityInstance.getId())
	}

	def show(Long id) {
		def cityInstance = cityService.getById(id.intValue())
		if (!cityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'city.label', default: 'City'),
				id
			])
			redirect(action: "list")
			return
		}

		[cityInstance: cityInstance]
	}

	def edit(Long id) {
		def cityInstance = City.get(id)
		if (!cityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'city.label', default: 'City'),
				id
			])
			redirect(action: "list")
			return
		}

		[cityInstance: cityInstance]
	}

	def update(Long id, Long version) {
		def cityInstance = City.get(id)
		if (!cityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'city.label', default: 'City'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (cityInstance.version > version) {
				cityInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'city.label', default: 'City')] as Object[],
						"Another user has updated this City while you were editing")
				render(view: "edit", model: [cityInstance: cityInstance])
				return
			}
		}

		cityInstance.properties = params

		if (!cityInstance.save(flush: true)) {
			render(view: "edit", model: [cityInstance: cityInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'city.label', default: 'City'),
			cityInstance.id
		])
		redirect(action: "show", id: cityInstance.id)
	}

	def delete(Long id) {
		def cityInstance = City.get(id)
		if (!cityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'city.label', default: 'City'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			cityInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'city.label', default: 'City'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'city.label', default: 'City'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
}
