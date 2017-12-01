
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="adminlte">
	<g:set var="entityName" value="${message(code: 'entry.label', default: 'Entrada')}" />
	<title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title"><g:message code="default.show.label" args="[entityName]" /></h3>
				</div>
			<!-- /.box-header -->
			<!-- form start -->
				<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
				</g:if>
				<g:hasErrors bean="${entryInstance}">
					<ul class="errors" role="alert">
						<g:eachError bean="${entryInstance}" var="error">
							<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
						</g:eachError>
					</ul>
				</g:hasErrors>
				<g:form  url="[action:'save', method:'post']" >
					<fieldset class="form">
						<g:render template="form"/>
					</fieldset>


					<!-- entry details -->
					<br>
					<hr>
					<br>
					<fieldset>

						<div class="col-sm-12 no-padding">
							<div class="col-sm-4 no-padding" >
								<h4> <strong>Detalles de entrada</strong></h4>
							</div>
							<div class="col-sm-8">
								<a href="#" class="addEntrada btn btn-primary" role="button"><i class="fa fa-plus"></i></a>
							</div>
						</div>
					</fieldset>
					<br>
					<br> <fieldset>

					<table id="entradaDetallesList" class="table table-bordered" cellspacing="0" width="100%">
						<thead>
						<tr>
							<th>Item</th>
							<th>Fecha</th>
						</tr>
						</thead>
						<tbody id="entradaDetallesListTableBody">

							<td>

								<div class="form-group ${hasErrors(bean: entryDetailsInstance, field: 'part', 'error')} required">
                                     <label for="part">
                                        <g:message code="entryDetails.part.label" default="Repuesto" />
                                        <span class="required-indicator">*</span>
                                    </label>
                                        <g:select in="${entry_details}" id="part" name="partId" from="${parts}" optionKey="id" optionValue="name"  value="${entryDetailsInstance?.part?.id}" class="many-to-one"/>
                                </div>
                            </td>
                            <td>
                                <div class="form-group ${hasErrors(bean: entryDetailsInstance, field: 'date', 'error')}">
                                    <label for="date">
                                        <g:message code="entryDetails.date.label" default="Fecha" />
                                        <span class="required-indicator">*</span>
                                        <g:datePicker name="date" precision="day" noSelection="['':'-Choose-']" class="form-control" autofocus="autofocus" inputClass="date required"></g:datePicker>
                                </div>
                            </td>

						</tbody>
					</table>


					<div class="col-xs-12" align="right">

						<div   style="display:none;">
							<input class="form-control" type="text" id="counter" name="counter"  value='0' readonly />
						</div>


					</div>
				</fieldset>
                    <fieldset  class="box-footer">
                        <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                    </fieldset>

					<!-- /entry details -->
				</g:form>

			</div>
			<!-- /.box -->
		</div>
	</div>
</section>


</body>
</html>