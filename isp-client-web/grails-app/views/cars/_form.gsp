
<div class="box-body">
	<div class="form-group ${hasErrors(bean: carInstance, field: 'number', 'error')}">
		<label for="mark">
			<g:message code="cars.mark.label" default="Marca" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="mark" class="form-control" maxlength="50" minlength="2" placeholder="Marca" required="true" value="${carInstance?.mark}" autofocus="autofocus" />
	</div>
	<div class="form-group ${hasErrors(bean: carInstance, field: 'number', 'error')}">
		<label for="model">
			<g:message code="cars.model.label" default="Modelo" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="model" class="form-control" maxlength="50" minlength="2" placeholder="Modelo" required="true" value="${carInstance?.model}"/>
	</div>
	<div class="form-group ${hasErrors(bean: carInstance, field: 'year', 'error')}">
		<label for="number">
			<g:message code="cars.number.label" default="Año" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="year" class="form-control" min="1900" placeholder="Año" value="${carInstance?.year}" required="true"/>
	</div>
	<div class="form-group ${hasErrors(bean: carInstance, field: 'number', 'error')}">
		<label for="color">
			<g:message code="cars.color.label" default="Color" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="color" class="form-control"  placeholder="Color" maxlength="50" minlength="2" value="${carInstance?.color}"/>
	</div>
</div>
<!-- /.box-body -->