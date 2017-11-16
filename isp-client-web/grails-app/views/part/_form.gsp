<%@ page import="com.sd.isp.part.Part" %>



<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="part.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${partInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="part.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" maxlength="50" required="" value="${partInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="part.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${partInstance.price}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: partInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="part.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" type="number" value="${partInstance.quantity}" required=""/>

</div>

