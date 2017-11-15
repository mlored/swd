<%@ page import="com.sd.isp.car.Cars" %>

<div class="box-body">
	<div class="form-group ${hasErrors(bean: carInstance, field: 'number', 'error')}">
		<label for="mark">
			<g:message code="cars.mark.label" default="Mark" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="mark" class="form-control" maxlength="50"  placeholder="Marca" required="" value="${carInstance?.mark}" autofocus="autofocus" />
	</div>
	<div class="form-group ${hasErrors(bean: carInstance, field: 'number', 'error')}">
		<label for="model">
			<g:message code="cars.model.label" default="Model" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="model" class="form-control" maxlength="50" placeholder="Modelo" required="" value="${carInstance?.model}"/>
	</div>
	<div class="form-group ${hasErrors(bean: carInstance, field: 'number', 'error')}">
		<label for="number">
			<g:message code="cars.number.label" default="Number" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="number" class="form-control" placeholder="Numero" value="${carInstance?.number}" required=""/>
	</div>
	<div class="form-group ${hasErrors(bean: carInstance, field: 'number', 'error')}">
		<label for="color">
			<g:message code="cars.color.label" default="Color" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="color" class="form-control"  placeholder="Color" maxlength="10" required="" value="${carInstance?.color}"/>
	</div>
</div>
<!-- /.box-body -->