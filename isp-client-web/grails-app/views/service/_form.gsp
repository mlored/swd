<%@ page import="com.sd.isp.service.Service" %>



<div class="fieldcontain ${hasErrors(bean: serviceInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="service.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${serviceInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="service.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" maxlength="50" required="" value="${serviceInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="service.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${serviceInstance.price}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="service.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" type="number" value="${serviceInstance.quantity}" required=""/>

</div>

