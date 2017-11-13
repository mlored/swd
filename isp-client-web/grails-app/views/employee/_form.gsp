<%@ page import="com.sd.isp.employee.Employee" %>
<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="employee.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${employeeInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'surName', 'error')} required">
	<label for="surName">
		<g:message code="employee.surName.label" default="Sur Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="surName" maxlength="50" required="" value="${employeeInstance?.surName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'ruc', 'error')} required">
	<label for="ruc">
		<g:message code="employee.ruc.label" default="Ruc" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ruc" maxlength="10" required="" value="${employeeInstance?.ruc}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="employee.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" maxlength="100" required="" value="${employeeInstance?.address}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'cellphone', 'error')} required">
	<label for="cellphone">
		<g:message code="employee.cellphone.label" default="Cellphone" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cellphone" type="number" value="${employeeInstance.cellphone}" required=""/>

</div>

