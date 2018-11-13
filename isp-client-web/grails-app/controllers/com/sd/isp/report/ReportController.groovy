package com.sd.isp.report


import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired

import com.sd.isp.beans.report.ReportB
import com.sd.isp.service.auth.IAuthService
import com.sd.isp.service.car.ICarService
import com.sd.isp.service.client.IClientService
import com.sd.isp.service.entry.IEntryService
import com.sd.isp.service.part.IPartService
import com.sd.isp.service.report.IReportService
//import com.sd.uni.isp.service.client.IClientService
/*import com.sd.isp.service.patient.IPatientService
import com.sd.isp.service.report.IReportService
import com.sd.isp.service.request.IRequestService
import com.sd.isp.service.statistic.IStatisticService*/
/*import com.sd.uni.labpatologia.util.SexEnum
import com.sd.uni.labpatologia.util.StatusEnum*/
import com.sun.corba.se.pept.transport.OutboundConnectionCache

@Secured(["ROLE_ADMIN"])
class ReportController {
	static allowedMethods = [save: "POST", update: "POST"]

	//service
	def IReportService reportService;
	def IEntryService  entryService;
	def IPartService   partService;
	def ICarService    carService;
	def IClientService clientService;
	
	@Autowired def IAuthService authService

	/*@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])*/
	def index() {
		redirect(action: "list", params: params)
	}

	/*@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])*/
	def show() {
		def reportInstance = reportService.getById(Integer.parseInt(params.get("id")))
		[reportInstance: reportInstance,entryInstanceList: entryService.getAll(),
			user:authService.getName(), reportShow:params.get("reportShow")]
	}

	/*@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])*/
	def list() {
		//def reports = reportService.getAll()
	}
	/*@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])*/
	def create(Integer id) {
		def action = "save"
		def reportInstance = new ReportB(params)
		reportInstance.setEntry(entryService.getById(id))
		[reportInstance: reportInstance,entryInstanceList: entryService.getAll(),
			user:authService.getName(), action:action] 
	}
	/*@Secured([
		'ROLE_DOCTOR',
		'    ROLE_ADMINISTRADOR'
	])*/
	
	
	def generateReport(Integer id) {

		def reportInstance = reportService.getById(Integer.parseInt(params.get("id")))
		
		params.entry = reportInstance?.entry?.name +" "+ reportInstance?.entry?.diagnostic
		//params.age = reportInstance.getAge()
		params.date = "ENCARNACION, "+ new Date().getDate() + " de " 
									 + (new SimpleDateFormat("MMMM", new Locale("es", "ES"))).format(new Date())
									 + " del "+(new SimpleDateFormat("yyyy", new Locale("es", "ES"))).format(new Date())
		params.code = reportInstance?.entry?.code
	
		params.number = reportInstance?.entry?.diagnostic
		
		
		
		chain(controller:'jasper', action:'index',
								  model:[data:reportService.getAll()],
								  params:params)
		return false
	}

}
