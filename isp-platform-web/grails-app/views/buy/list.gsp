
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'buy.label', default: 'Buy')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-buy" class="content scaffold-list" role="main">
    <h1>Compras
   		 <g:link class="btn btn-primary" action="create">Nuevo</g:link>
    </h1>
     <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="box">
    <table class="table table-striped table-hover table-condensed">
        <thead>
        <tr>
        	<th>#</th>
            <g:sortableColumn property="date" title="Fecha" />
            <g:sortableColumn property="number" title="Numero" />
            <g:sortableColumn property="total" title="Total" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${buyInstanceList}" status="i" var="buyInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${i+1}</td>
                <td><g:link action="show" id="${buyInstance.id}">${fieldValue(bean: buyInstance, field: "date")}</g:link></td>
                <td>${fieldValue(bean: buyInstance, field: "number")}</td>
                <td>${fieldValue(bean: buyInstance, field: "total")}</td>
                <td>
                  <g:form controller="buy" method="DELETE">
                    <g:submitButton name="borrar" action="delete" class="btn btn-danger"  />
                  </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    </div>
    <div class="pagination">
        <g:paginate total="${buyInstanceTotal}" />
    </div>
</div>
</body>
</html>