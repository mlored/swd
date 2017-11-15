<%@ page import="com.sd.isp.client.Client" %>



<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="client.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${clientInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'surName', 'error')} required">
	<label for="surName">
		<g:message code="client.surName.label" default="Sur Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="surName" maxlength="50" required="" value="${clientInstance?.surName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'ruc', 'error')} required">
	<label for="ruc">
		<g:message code="client.ruc.label" default="Ruc" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ruc" maxlength="10" required="" value="${clientInstance?.ruc}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="client.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" maxlength="100" required="" value="${clientInstance?.address}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'cellphone', 'error')} required">
	<label for="cellphone">
		<g:message code="client.cellphone.label" default="Cellphone" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cellphone" type="number" value="${clientInstance.cellphone}" required=""/>

</div>

