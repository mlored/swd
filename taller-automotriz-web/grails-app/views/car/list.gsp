<!DOCTYPE html>
<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'car.label', default: 'Car')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-car" class="content scaffold-list" role="main">
    <div class="col-sm-12" align="right">
        <g:form action="list" class="form-search">
            <div class="input-group col-md-5">
                <input type="text" name="text" class="form-control" maxlength="50" value="${text}"
                       placeholder="Ingrese un texto para buscar" />
                <span class="input-group-btn">
                    <button class="btn btn-primary" name="list" value="Buscar">
                        <span class="fa fa-search" style="font-size:20px"></span>
                    </button>
                </span>
            </div>
        </g:form>
    </div>
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
                <g:sortableColumn property="mark" title="Marca" />
                <g:sortableColumn property="model" title="Modelo" />
                <g:sortableColumn property="year" title="Año" />
                <g:sortableColumn property="color" title="Color" />
                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${carInstanceList}" status="i" var="carInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i+1}</td>
                    <td>
                        <g:link action="edit" id="${carInstance?.id}"><g:message code="${fieldValue(bean: carInstance, field: "mark")}" default="${fieldValue(bean: carInstance, field: "mark")}" /></g:link>
                    </td>
                    <td>${fieldValue(bean: carInstance, field: "model")}</td>
                    <td>${fieldValue(bean: carInstance, field: "year")}</td>
                    <td>${fieldValue(bean: carInstance, field: "color")}</td>
                    <td>
                        <sec:ifAnyGranted roles="ROLE_ADMIN">
                        <a class="btn btn-sm btn-danger"
                           data-confirm="Estas Seguro?"
                           data-method="delete"
                           href="/cars/delete/${carInstance.id}">Eliminar</a>
                        </sec:ifAnyGranted>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
    <g:render template="/layouts/paginate"/>
</div>
</body>
</html>