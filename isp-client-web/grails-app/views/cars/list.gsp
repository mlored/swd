
<!DOCTYPE html>
<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'car.label', default: 'Car')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-car" class="content scaffold-list" role="main">
    <h1>
         Automóviles
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
                <g:sortableColumn property="number" title="Nº de Chapa" />
                <g:sortableColumn property="mark" title="Marca" />
                <g:sortableColumn property="model" title="Modelo" />
                <g:sortableColumn property="color" title="Color" />
                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${carInstanceList}" status="i" var="carInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i+1}</td>
                    <td>
                        <g:link action="edit" id="${carInstance?.id}"><g:message code="${fieldValue(bean: carInstance, field: "number")}" default="${fieldValue(bean: carInstance, field: "number")}" /></g:link>
                    </td>
                    <td>${fieldValue(bean: carInstance, field: "mark")}</td>
                    <td>${fieldValue(bean: carInstance, field: "model")}</td>
                    <td>${fieldValue(bean: carInstance, field: "color")}</td>
                    <td>
                        <g:form controller="cars" method="DELETE">
                            <g:submitButton name="borrar" action="delete" class="btn btn-danger"  />
                        </g:form>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>

    <div class="pagination">
        <g:paginate total="${carInstanceTotal}" />
    </div>
</div>
</body>
</html>