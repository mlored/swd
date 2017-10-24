<%@ page import="com.sd.isp.zona.Zona" %>



<div class="fieldcontain ${hasErrors(bean: zonaInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="zona.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${zonaInstance?.descripcion}"/>
</div>

