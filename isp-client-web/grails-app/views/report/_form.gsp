<%@ page import="java.text.SimpleDateFormat"%>
<head>
<ckeditor:resources />
</head>

<h4>
	<p style="text-align: center">INFORME DE ENTRADA DE VEHÍCULOS</p>
</h4>
	<g:if test="${action == 'save'}">
 	   <form action="/isp-client-web/report/save" method="post" id="report" onsubmit="return saveDataReport();">
 	</g:if><g:else>
 	 	   <form action="/isp-client-web/report/update" method="post" id="report" onsubmit="return saveDataReport();">
  	</g:else>
 	

<fieldset>
	<legend>Datos de la Solicitud de Entrada</legend>

	<div class="col-md-6">
		<label> Código:</label>

		${reportInstance?.request?.code}
		<g:hiddenField class="form-control" name="clientId"
			value="${reportInstance?.client?.id}" />
		<g:hiddenField class="form-control" name="carId"
			value="${reportInstance?.car?.id}" />
		<g:hiddenField class="form-control" name="isActived"
			value="${reportInstance?.isActived}" />
	</div>
	<div class="col-md-6">
		<label>Fecha de Solicitud:</label>
		<g:formatDate date="${reportInstance?.entry?.date}"
			format='dd/MM/yyyy' />
	</div>
</fieldset>
<br>
<fieldset>
	<legend>Datos del Cliente</legend>

	<div class="col-md-6">
		<label> Nombre y Apellido:</label>
		${reportInstance?.entry?.client?.name +" "+ reportInstance?.entry?.client?.surname}
	</div>
	<%--<g:if test="${!reportInstance?.entry?.client?.speciality.isEmpty()}">
		<div class="col-md-6">
			<label> Especialidad:</label>
			${reportInstance?.request?.doctor?.speciality}
		</div>
	</g:if>
	--%><g:if test="${!reportInstance?.entry?.client?.cellphone.isEmpty()}">
		<div class="col-md-6">
			<label> Teléfono:</label>
			${reportInstance?.entry?.client?.cellphone}
		</div>
	</g:if>

</fieldset>
<br>
<fieldset>
	<Legend>Datos del  Automóvil</Legend>
	<div class="col-md-6">
		<label> Marca:</label>
		${reportInstance?.entry?.car?.mark +" "+ reportInstance?.entry?.car?.model}
	</div>
	<g:if test="${reportInstance?.entry?.car?.color}">
		<div class="col-md-6">
			<label> Color:</label>
			${reportInstance?.entry?.car?.color}

		</div>
	</g:if>
	<g:if test="${reportInstance?.entry?.client?.año}">
		<div class="col-md-6">
			<label> Año:</label>
			${reportInstance?.year}
			<g:hiddenField class="form-control" name="age" required=""
				value="${reportInstance?.year}" />

		</div>
	</g:if>
	<%--<g:if test="${reportInstance?.request?.patient?.phone}">
		<div class="col-md-6">
			<label> Teléfono:</label>
			${reportInstance?.request?.patient?.phone}
		</div>
	</g:if>
	<g:if test="${reportInstance?.request?.patient?.mail}">
		<div class="col-md-6">
			<label> Correo:</label>
			${reportInstance?.request?.patient?.mail}
		</div>
	</g:if>
--%></fieldset>
<br>
<fieldset>
	<legend>Datos del Informe</legend>
	<div class="col-md-4">
		<label> Fecha del Informe:</label>
		<g:formatDate date="${new Date()}" class="form-control" name="date"
			type="date" value="${reportInstance?.date}" />
	</div>


	<div class="col-md-4">
		<label>Diagnóstico <span class="required-indicator">*</span></label>
		<div class="form-group">
			<div class="input-group" id="data-diagnostic">
				<g:if test="${action == 'save'}">
					<select class="select-diagnostic form-control" name="diagnosticId"
						id="diagnosticId">
						<option value="${reportInstance?.diagnostic?.id}">Selecciona
							un diagnóstico</option>
					</select>
				</g:if>
				<g:else>
					<select class="select-diagnostic form-control" name="diagnosticId"
						id="diagnosticId">
						<option value="${reportInstance?.diagnostic?.id}">
							${reportInstance?.diagnostic?.name}
						</option>
					</select>
				</g:else>
				<label type="button" class="btn btn-primary input-group-addon"
					data-toggle="modal" data-target="#createDiagnostic"> <i
					class="fa fa-plus"></i>
				</label>
			</div>
		</div>
	</div>

	<div class="col-md-4">
		<label>Descripción</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="200"
				id="diagnosticDetail" id="diagnosticDetail" name="diagnosticDetail"
				placeholder="Descripción del Diagnóstico"
				value="${reportInstance?.diagnosticDetail}" />
		</div>
	</div>
	<div class="col-md-12">
		<label> Informe <span class="required-indicator">*</span>
		</label>
		<div class="form-group">
			<textarea class="form-control" rows="10" id="observations"
				name="observations" placeholder="Ingrese el Informe"><g:if
					test="${null!=reportInstance?.observations}">
					${reportInstance?.observations}
				</g:if><g:else>
MACROSCOPÍA	


			</g:else>
			</textarea>
		</div>
	</div>

</fieldset>
<div class="row"></div>
							<br>
							<g:if test="${action == 'save'}">
 	  <div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary" name="create"
										value="${reportInstance?.request?.id}">
										<i class="fa fa-floppy-o"></i> Guardar
									</button>
									<a class="btn btn-default" href="/Sistema/request/list"
											role="button"><i class="fa fa-times"></i> Cancelar</a>
								</div>
 	</g:if><g:else>
							<div class="col-xs-12" align="center">
									<g:hiddenField name="reportEdit" value="${reportEdit}" />
									<button type="submit" class="btn btn-primary" name="edit"
										value="${reportInstance?.id}">
										<i class="fa fa-save"></i> Guardar
									</button>
									<g:if test="${reportEdit.equals("entry")}">
										<a class="btn btn-default" href="/Sistema/entry/list"
											role="button"><i class="fa fa-times"></i> Cancelar</a>
									</g:if>
									<g:else>
										<a class="btn btn-default" href="/Sistema/report/list"
											role="button"><i class="fa fa-times"></i> Cancelar</a>
									</g:else>

								
							</div>

  	</g:else>
							
						

</form>
<!-- Modal diagnostico -->
<div class="modal fade" id="createDiagnostic" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Registrar Diagnóstico</h4>
			</div>
			<div class="modal-body">
			<form id="myFormDiagnostic" onsubmit="return callDiagnostic();">
			
				<g:render template="/diagnostic/form"/>
			
					<fieldset class="buttons">
						<br><br><div class="col-xs-10">
							<div class="text-right">
							<button  type="submit"  class="btn btn-primary"><i class="fa fa-save"></i> Guardar</button>
							</div></div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- Bootstrap Core JavaScript -->
<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

<style>
		.select2-container--default .select2-selection--single{
		    height: 32px;
		}	
	</style>
    <!-- Para boton guardar de diagnóstico -->
    <script>
        function callDiagnostic(){
        	if(saveDataModalDiagnostic()){
        	    $.ajax({
                	type:"POST",
                    url : "${createLink(controller: 'diagnostic', action: 'save')}",
                    data :   $("#myFormDiagnostic").serialize() , 
                    dataType: 'json',
                    success : function(data){
                    	 $("#myFormDiagnostic").submit();
                    },
                });
        	}else{
				return false;
            }
        }
    </script>
    
<!-- Para selector de diagnóstico -->
    <script type="text/javascript">
	    	$(".select-diagnostic").select2({
		    	language: 'es',
	    		  ajax: {
	    		    url: "${createLink(controller: 'diagnostic', action: 'selectDiagnostic')}",
	    		    dataType: 'json',
	    		    delay: 250,
	    		    data: function (params) {
	    		      return {
	    		        q: params.term, 
	    		        page: 0
	    		      };
	    		    },
	    		    processResults: function (data) {
	    		        return {
	    		            results: $.map(data, function(obj) {
	    		                return { id: obj.id, text: obj.name};
	    		            })
	    		        };
	    		    },
	    		    cache: true
	    		  },
	    		  escapeMarkup: function (markup) { return markup; }, 
	    		  minimumInputLength: 1,
	    	}).on("change", function (e) {
	    	    $(this).valid(); //jquery validation script validate on change
	    	}).on("select2:open", function() { //correct validation classes (has=*)
	    	    if ($(this).parents("[class*='has-']").length) { //copies the classes
	    	        var classNames = $(this).parents("[class*='has-']")[0].className.split(/\s+/);

	    	        for (var i = 0; i < classNames.length; ++i) {
	    	            if (classNames[i].match("has-")) {
	    	                $("body > .select2-container").addClass(classNames[i]);
	    	            }
	    	        }
	    	    } else { //removes any existing classes
	    	        $("body > .select2-container").removeClass (function (index, css) {
	    	            return (css.match (/(^|\s)has-\S+/g) || []).join(' ');
	    	        });            
	    	    }
	    	});
	   
    </script>