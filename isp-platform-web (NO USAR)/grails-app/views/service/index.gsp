
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'service.label', default: 'Service')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-service" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-service" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'service.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'service.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'service.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="quantity" title="${message(code: 'service.quantity.label', default: 'Quantity')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${serviceInstanceList}" status="i" var="serviceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${serviceInstance.id}">${fieldValue(bean: serviceInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: serviceInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: serviceInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: serviceInstance, field: "quantity")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${serviceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
