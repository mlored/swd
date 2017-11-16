
<%@ page import="com.sd.isp.part.Part" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="adminlte">
		<g:set var="entityName" value="${message(code: 'part.label', default: 'Part')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-part" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-part" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list part">
			
				<g:if test="${partInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="part.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${partInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="part.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${partInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="part.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${partInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partInstance?.quantity}">
				<li class="fieldcontain">
					<span id="quantity-label" class="property-label"><g:message code="part.quantity.label" default="Quantity" /></span>
					
						<span class="property-value" aria-labelledby="quantity-label"><g:fieldValue bean="${partInstance}" field="quantity"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:partInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${partInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
