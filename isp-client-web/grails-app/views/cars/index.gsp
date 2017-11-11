
<%@ page import="com.sd.isp.car.Cars" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cars.label', default: 'Cars')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-cars" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-cars" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="mark" title="${message(code: 'cars.mark.label', default: 'Mark')}" />
					
						<g:sortableColumn property="model" title="${message(code: 'cars.model.label', default: 'Model')}" />
					
						<g:sortableColumn property="number" title="${message(code: 'cars.number.label', default: 'Number')}" />
					
						<g:sortableColumn property="color" title="${message(code: 'cars.color.label', default: 'Color')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${carsInstanceList}" status="i" var="carsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${carsInstance.id}">${fieldValue(bean: carsInstance, field: "mark")}</g:link></td>
					
						<td>${fieldValue(bean: carsInstance, field: "model")}</td>
					
						<td>${fieldValue(bean: carsInstance, field: "number")}</td>
					
						<td>${fieldValue(bean: carsInstance, field: "color")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${carsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
