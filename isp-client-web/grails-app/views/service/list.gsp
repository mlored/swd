<!DOCTYPE html>
<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'service.label', default: 'Service')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-service" class="content scaffold-list" role="main">
    <h1>Servicios</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="box">
        <table class="table table-striped table-hover table-condensed">
            <thead>
            <tr>
                <th>#</th>
                <g:sortableColumn property="name" title="Nombre" />
                <g:sortableColumn property="description" title="Descripcion" />
                <g:sortableColumn property="price" title="Precio" />
                <g:sortableColumn property="quantity" title="Cantidad" />
            </tr>
            </thead>
            <tbody>
            <g:each in="${serviceInstanceList}" status="i" var="serviceInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i+1}</td>
                    <td><g:link action="show" id="${serviceInstance.id}">${fieldValue(bean: serviceInstance, field: "name")}</g:link></td>
                    <td>${fieldValue(bean: serviceInstance, field: "description")}</td>
                    <td>${fieldValue(bean: serviceInstance, field: "price")}</td>
                    <td>${fieldValue(bean: serviceInstance, field: "quantity")}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>

    <div class="pagination">
        <g:paginate total="${serviceInstanceTotal}" />
    </div>
</div>
</body>
</html>