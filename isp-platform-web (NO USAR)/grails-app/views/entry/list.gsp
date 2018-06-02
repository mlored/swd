<!DOCTYPE html>
<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'entry.label', default: 'Entrada')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-entry" class="content scaffold-list" role="main">
    <h1>
         Entrada de Automoviles
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
                <g:sortableColumn property="number" title="Numero" />
                <g:sortableColumn property="date" title="Fecha" />
                <g:sortableColumn property="client" title="Cliente" />
                <g:sortableColumn property="car" title="Automovil" />
                <g:sortableColumn property="color" title="Color" />
                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${entryInstanceList}" status="i" var="entryInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i+1}</td>
                    <td>
                        <g:link action="edit" id="${entryInstance?.id}"><g:message code="${fieldValue(bean: entryInstance, field: "number")}" default="${fieldValue(bean: entryInstance, field: "number")}" /></g:link>
                    </td>
                    <td>${fieldValue(bean: entryInstance, field: "date")}</td>
                    <td>${fieldValue(bean: entryInstance, field: "cliente.name")}</td>
                    <td>${fieldValue(bean: entryInstance, field: "car.mark")}</td>
                    <td>${fieldValue(bean: entryInstance, field: "car.color")}</td>
                    <td>
                        <g:form controller="entries" method="DELETE">
                            <g:submitButton name="borrar" action="delete" class="btn btn-danger"  />
                        </g:form>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>


</div>
</body>
</html>