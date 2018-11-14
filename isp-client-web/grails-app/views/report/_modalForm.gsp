
<div class="container-fluid">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>
				<strong>Informes</strong>
				<label type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#createReport">
					<i class="fa fa-plus"></i>
				</label>
			</h4>
		</div>
		<div class="panel-body"></div>
	</div>
</div>




<div class="modal fade" id="createReport" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Crear Informe</h4>
			</div>
			<div class="modal-body">
				<g:formRemote name="createReport" update="showReports"
					url="[controller:'report', action:'save']">
					<div class="row">
						<div class="col-md-4">
							<label> Fecha </label>
							<g:formatDate date="${new Date()}" class="form-control"
								name="date" type="date" value="${reportInstance?.date}" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<label> Diagnóstico <span class="required-indicator">*</span>
							</label>
							<g:textField class="form-control" name="diagnostic" required=""
								maxlength="100" value="${reportInstance?.entry.diagnostic}" />
						</div>
					</div>
					<%--<div class="row">
						<div class="col-md-10">
							<label> Observaciones <span class="required-indicator">*</span>
							</label>
							<g:textArea rows="5" cols="40" class="form-control"
								name="observations" required="" maxlength="250"
								value="${reportInstance?.observations}" />
						</div>
					</div>
				--%></g:formRemote>
			</div>

			<div class="modal-footer">
				<g:submitToRemote class="btn btn-primary" url="[controller:'report', action:'save']" value="Crear"/>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			</div>
		</div>
	</div>
</div>


<!-- jQuery -->
<script src=" ${request.contextPath}/template/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>