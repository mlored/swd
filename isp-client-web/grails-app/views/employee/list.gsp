
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-employee" class="content scaffold-list" role="main">
    <h1>Empleados
   		 <g:link class="btn btn-primary" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
    </h1>
     <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="box">
    <table class="table table-striped table-hover table-condensed">
        <thead>
        <tr>
        	<th>#</th>
            <g:sortableColumn property="name" title="Nombre" />
            <g:sortableColumn property="surName" title="Apellido" />
            <g:sortableColumn property="ruc" title="Ruc" />
            <g:sortableColumn property="address" title="Dirección" />
            <g:sortableColumn property="cellphone" title="Telefono" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${employeeInstanceList}" status="i" var="employeeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${i+1}</td>
                <td><g:link action="show" id="${employeeInstance.id}">${fieldValue(bean: employeeInstance, field: "name")}</g:link></td>
                <td>${fieldValue(bean: employeeInstance, field: "surName")}</td>
                <td>${fieldValue(bean: employeeInstance, field: "ruc")}</td>
                <td>${fieldValue(bean: employeeInstance, field: "address")}</td>
                <td>${fieldValue(bean: employeeInstance, field: "cellphone")}</td>
                <td>
                  <g:form controller="employee" method="DELETE">
                    <g:submitButton name="borrar" action="delete" class="btn btn-danger"  />
                  </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    </div>
    <div class="pagination">
        <g:paginate total="${employeeInstanceTotal}" />
    </div>
</div>
</body>
</html>