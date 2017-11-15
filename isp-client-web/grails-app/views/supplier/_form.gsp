<%@ page import="com.sd.isp.supplier.Supplier" %>
<div class="fieldcontain ${hasErrors(bean: supplierInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="supplier.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${supplierInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: supplierInstance, field: 'surName', 'error')} required">
	<label for="surName">
		<g:message code="supplier.surName.label" default="Sur Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="surName" maxlength="50" required="" value="${supplierInstance?.surName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: supplierInstance, field: 'ruc', 'error')} required">
	<label for="ruc">
		<g:message code="supplier.ruc.label" default="Ruc" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ruc" maxlength="10" required="" value="${supplierInstance?.ruc}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: supplierInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="supplier.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" maxlength="100" required="" value="${supplierInstance?.address}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: supplierInstance, field: 'cellphone', 'error')} required">
	<label for="cellphone">
		<g:message code="supplier.cellphone.label" default="Cellphone" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cellphone" type="number" value="${supplierInstance.cellphone}" required=""/>

</div>

