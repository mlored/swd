package com.sd.isp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import com.sd.isp.dto.report.ReportDTO;
import com.sd.isp.dto.report.ReportResult;
import com.sd.isp.service.report.IReportService;

@Path("/report")
@Component
@Secured({"ROLE_ADMIN"})
public class ReportResource {
	@Autowired
	private IReportService reportService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ReportDTO getById(@PathParam("id") Integer reportId) /*throws AutomotiveException*/ {
		return reportService.getById(reportId);
	}

	@GET
	@Produces("application/xml")
	public ReportResult getAll() /*throws AutomotiveException*/ {
		return reportService.getAll();
	}

	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public ReportResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page,
			@PathParam("max") Integer maxItems) throws Exception /*throws AutomotiveException, com.sd.isp.exception.AutomotiveException*/{
		return reportService.find(textToFind, page, maxItems);
	}

	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public ReportResult search(@PathParam("page") Integer page, 
			@PathParam("max") Integer maxItems) throws Exception/*throws AutomotiveException*/ {
		return reportService.find(null, page, maxItems);
	}

	@POST
	public ReportDTO save(ReportDTO report) {
		return reportService.save(report);
	}
}
