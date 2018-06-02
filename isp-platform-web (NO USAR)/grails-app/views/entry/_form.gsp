
<div class="box-body">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group ${hasErrors(bean: entryInstance, field: 'date', 'error')}">
                <label for="date">
                    <g:message code="entry.date.label" default="Fecha" />
                    <span class="required-indicator">*</span>
                    <g:textField name="date" class="form-control" placeholder="Fecha" value="${entryInstance?.date}" autofocus="autofocus" />
                </label>
            </div>
        </div>
    </div>


    <div class="form-group ${hasErrors(bean: entryInstance, field: 'number', 'error')}">
        <label for="number">
            <g:message code="entry.number.label" default="Numero" />

        </label>
            <g:textField name="number" class="form-control" placeholder="numero" value="${entryInstance?.number}" />
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="form-group ${hasErrors(bean: entryInstance, field: 'client', 'error')} required">
                <label for="client">
                    <g:message code="entry.client.label" default="Cliente" />
                    <span class="required-indicator">*</span>
                </label>
                <g:select id="client" name="clientId" from="${entryInstance?.getCliente()}"
                          optionKey="id" optionValue="name" required=""
                          value="${entryInstance?.cliente?.id}" class="form-control input-sm"
                          noSelection="['null':'Select a Resource']" />
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <div class="form-group ${hasErrors(bean: entryInstance, field: 'car', 'error')} required">
                <label for="car">
                    <g:message code="entry.car.label" default="Automovil" />
                    <span class="required-indicator">*</span>
                </label>
                <g:hiddenField name="id" value="${entryInstance?.id}" />
                <g:select id="car" name="carId" from="${entryInstance?.getCar()}"
                          optionKey="id" optionValue="mark" required=""
                          value="${entryInstance?.car?.id}"  class="form-control input-sm"
                          noSelection="['null':'Select a Resource']"/>
            </div>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: entryInstance, field: 'string', 'error')}">
        <label for="diagnostic">
            <g:message code="entry.diagnostic.label" default="Diagnostico" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField name="diagnostic" class="form-control" placeholder="Diagnostico" value="${entryInstance?.diagnostic}" />
    </div>

    <dynamic:block itemId="fullName" min="2" max="5" addBtnId="addFullName" removeBtnLabel="Delete"
                   onComplete="makeDatePicker" limitReachedMsg="Limit is exceeded!">
        <g:textField name="firstName"/>
        <g:textField name="lastName"/>
        <g:textField name="birthday" id="birthday"/>
        <input id="addFullName" type="button" value="Add another name"/>
    </dynamic:block>
</div>
<!-- /.box-body -->

<g:javascript>
    $(function() {
        $(document).ready(function () {
            $("#client").select2({
                id: function (client) {
                    return client
                },
                ajax: {
                    url: "/isp-client-web/client/list.json",
                    dataType: 'json',
                    data: function (params) {

                        var queryParameters = {
                            term: params.term
                        }
                        return queryParameters;
                    },
                    processResults: function (data) {
                        return {
                            results: $.map(data, function (item) {
                                return {
                                    text: item.name,
                                    id: item.id
                                }
                            })
                        };
                    }
                },
                formatResult: formatResult,
                formatSelection: formatSelection,
                escapeMarkup: function (m) {
                    return m;
                }
            });

            $(document).ready(function () {
                $("#car").select2({
                    id: function (car) {
                        return car
                    },
                    ajax: {
                        url: "/isp-client-web/cars/list.json",
                        dataType: 'json',
                        data: function (params) {

                            var queryParameters = {
                                term: params.term
                            }
                            return queryParameters;
                        },
                        processResults: function (data) {
                            return {
                                results: $.map(data, function (item) {
                                    return {
                                        text: item.mark,
                                        id: item.id
                                    }
                                })
                            };
                        }
                    },
                    formatResult: formatResult,
                    formatSelection: formatSelection,
                    escapeMarkup: function (m) {
                        return m;
                    }
                });
            });

            function formatResult(data) {
                return '<div>' + data + '</div>';
            }

            function formatSelection(data) {
                return data;
            }
        });
    });
</g:javascript>