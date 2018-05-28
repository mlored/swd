package com.sd.isp.report


import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired

import com.sd.isp.beans.report.ReportB
import com.sd.isp.service.auth.IAuthService
import com.sd.isp.service.car.ICarService
import com.sd.isp.service.client.IClientService
import com.sd.isp.service.entry.IEntryService
import com.sd.isp.service.report.IReportService
//import com.sd.uni.isp.service.client.IClientService
/*import com.sd.isp.service.patient.IPatientService
import com.sd.isp.service.report.IReportService
import com.sd.isp.service.request.IRequestService
import com.sd.isp.service.statistic.IStatisticService*/
/*import com.sd.uni.labpatologia.util.SexEnum
import com.sd.uni.labpatologia.util.StatusEnum*/
import com.sun.corba.se.pept.transport.OutboundConnectionCache

class ReportController {
	static allowedMethods = [save: "POST", update: "POST"]

	//service
	def IReportService reportService;
	def IEntryService  entryService;
	def IClientService clientService;
	def ICarService    carService;
	//def IRequestService requestService;
	
	
	//def ILaboratoryService laboratoryService;
	//def IStatisticService statisticService;
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
		def page = 0
		def siguiente
		if(null != params.get("page")){
			page = Integer.parseInt(params.get("page"))
		}
		def reports   = null
		String search ="";
		System.out.println("asdasd" + search)
		System.out.println("asdasd" + params)
			if(null!=params.get("diagnosticSearch") && !"".equals(params.get("diagnosticSearch")) && !"null".equals(params.get("diagnosticSearch"))){
				search+="diagnostic="+params.get("diagnosticSearch")+'&'
			}
			if((!"".equals(params.get("startSearch")) && !"".equals(params.get("endSearch"))) &&
			(null!=(params.get("startSearch")) && null!=params.get("endSearch"))){
				search+="start="+params.get("startSearch")+'&'
				search+="end="+params.get("endSearch")
			}else{
				if(null!=(params.get("startSearch")) && !"".equals(params.get("startSearch"))){
					search+="date="+params.get("startSearch")
				}
			}
		System.out.println("asdasd" + search)
		if(!search.equals("")){
			reports   = reportService.find(search,10,page);
			siguiente = reportService.find(search,10,page+1);
		}else{
			reports   = reportService.find(null,10,page);
			siguiente = reportService.find(null,10,page+1);
		}
		System.out.println("Cantidad Reportes----------------------------->"+reports.size())
		[reportInstanceList: reports, reportInstanceTotal: reports?.size(), page: page, siguiente: siguiente?.size(),laboratoryInstanceList: laboratoryService.getAll(), text: params.get("diagnosticSearch"),
			user:authService.getName()]
	}
	/*@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])*/
	def create(Integer id) {
		def action = "save"
		def reportInstance = new ReportB(params)
		reportInstance.setRequest(requestService.getById(id))
		/*if((null!=reportInstance.request.patient._birthDate)){
			reportInstance.setAge(calculateAge(reportInstance.request.patient._birthDate));
		}*/
		[reportInstance: reportInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName(), action:action] //, requests:requestService.getAll()]
	}
	/*@Secured([
		'ROLE_DOCTOR',
		'    ROLE_ADMINISTRADOR'
	])*/
	/*def save() {

		def reportInstance = new ReportB(params)
		//request
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setId(Integer.parseInt(params.get("requestId")));
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		reportInstance.setRequest(requestService.getById(Integer.parseInt(params.get("requestId"))))
		reportInstance.setDiagnostic(diagnosticService.getById(Integer.parseInt(params.get("diagnosticId"))))
		reportInstance.setDiagnosticDetail((params.get("diagnosticDetail")))
		if((null!=params.get("age"))){
			reportInstance.setAge(Integer.parseInt(params.get("age")));
		}
		def requestInstance = requestService.getById(Integer.parseInt(params.get("requestId")))
		requestInstance.setStatus(StatusEnum.TERMINADO)
		reportInstance.setIsProcessed(false);
		//reportInstance.setAge(calculateAge(requestInstance.getPatient().getBirthDate()));
		def newReport= reportService.save(reportInstance)
		requestService.save(requestInstance)

		if (!newReport?.getId()) {
			//redirect(action: "list", id: newReport.getId())
			//return
		}
		redirect(action: "list", controller: "request")
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def edit(Integer id) {
		def reportInstance = reportService.getById(Integer.parseInt(params.get("id")))
		def statisticId = ""
		if(null!= reportInstance.getStatistic()){
			statisticId = reportInstance.getStatistic().getId()
		}
		[reportInstance: reportInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName(), reportEdit:params.get("reportEdit"), statisticId:statisticId, isProcessed:reportInstance._isProcessed]
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def update(Integer id) {
		def reportInstance = new ReportB(params)
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		def requestInstance = requestService.getById(Integer.parseInt(params.get("requestId")))
		reportInstance.setRequest(requestInstance)
		reportInstance.setId(Integer.parseInt(params.get("edit")))
		reportInstance.setDiagnostic(diagnosticService.getById(Integer.parseInt(params.get("diagnosticId"))))
		
		reportInstance.setDiagnosticDetail(params.get("diagnosticDetail"))
		if(params.get("isProcessed")=="true"){
			def statisticInstance = statisticService.getById(Integer.parseInt(params.get("statisticId")))
			statisticInstance.setDiagnostic(diagnosticService.getById(Integer.parseInt(params.get("diagnosticId"))))
			statisticInstance.setId(Integer.parseInt(params.get("statisticId")))
			reportInstance.setStatistic(statisticService.save(statisticInstance))
			reportInstance.setIsProcessed(true)
		}else{
			reportInstance.setIsProcessed(false)
		}
		
		if((null!=params.get("age"))){
			reportInstance.setAge(Integer.parseInt(params.get("age")))
		}

		reportService.save(reportInstance)
		if(params.get("reportEdit").equals("request")){
			redirect(action: "list", controller: "request")
		}else{
			redirect(action: "list")
		}
	}*/
	
	def generateReport(Integer id) {

		def reportInstance = reportService.getById(Integer.parseInt(params.get("id")))
		
		params.client = reportInstance?.request?.client?.name +" "+ reportInstance?.entry?.client?.lastName
		//params.age = reportInstance.getAge()
		params.date = "ENCARNACION, "+ new Date().getDate() + " de " + (new SimpleDateFormat("MMMM", new Locale("es", "ES"))).format(new Date())+ " del "+(new SimpleDateFormat("yyyy", new Locale("es", "ES"))).format(new Date())
		params.code = reportInstance?.entry?.code
		/*if(reportInstance?.request.doctor?.sex == SexEnum.MASCULINO){
			params.doctor = "Dr. " + reportInstance?.request?.doctor?.name +" "+ reportInstance?.request?.doctor?.lastName
		}else{
			params.doctor = "Dra. " + reportInstance?.request?.doctor?.name +" "+ reportInstance?.request?.doctor?.lastName
		}*/
		params.number = reportInstance?.entry?.car?.number
		
		/*params.specimen = reportInstance?.request?.specimen
		params.signature = "DR. SERGIO ARIEL MEDINA S."
		
		params.diagnostic = reportInstance.getDiagnostic()
		params.diagnosticDetail = reportInstance.getDiagnosticDetail()
		params.studyType= "Tipo de Estudio: " + reportInstance?.request?.studyType?.name;
		params.observations = reportInstance.getObservations()*/
		
		chain(controller:'jasper', action:'index',
								  model:[data:reportService.getAll()],
								  params:params)
		return false
	}

	/*private int calculateAge(Date birthDay) {
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(birthDay);
		Calendar today = Calendar.getInstance();

		int diff_year = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		int diff_month = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		int diff_day = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
			diff_year--;
		}
		return diff_year;
	}*/
}
