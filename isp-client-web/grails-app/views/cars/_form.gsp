<%@ page import="com.sd.isp.car.Cars" %>



<div class="fieldcontain ${hasErrors(bean: carsInstance, field: 'mark', 'error')} required">
	<label for="mark">
		<g:message code="cars.mark.label" default="Mark" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="mark" maxlength="50" required="" value="${carsInstance?.mark}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: carsInstance, field: 'model', 'error')} required">
	<label for="model">
		<g:message code="cars.model.label" default="Model" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="model" maxlength="50" required="" value="${carsInstance?.model}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: carsInstance, field: 'number', 'error')} required">
	<label for="number">
		<g:message code="cars.number.label" default="Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="number" type="number" value="${carsInstance.number}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: carsInstance, field: 'color', 'error')} required">
	<label for="color">
		<g:message code="cars.color.label" default="Color" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="color" maxlength="10" required="" value="${carsInstance?.color}"/>

</div>

