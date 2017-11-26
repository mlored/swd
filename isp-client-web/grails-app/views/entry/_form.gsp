
<div class="box-body">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group ${hasErrors(bean: entryInstance, field: 'number', 'error')}">
                <label for="date">
                    <g:message code="entrys.date.label" default="Fecha" />
                    <span class="required-indicator">*</span>
                </label>
                <g:datePicker name="date" precision="day" noSelection="['':'-Choose-']" class="form-control" autofocus="autofocus"></g:datePicker>
            </div>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: entryInstance, field: 'string', 'error')}">
        <label for="diagnostic">
            <g:message code="entrys.diagnostic.label" default="Diagnostico" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField name="diagnostic" class="form-control" placeholder="Diagnostico" value="${entryInstance?.diagnostic}" />
    </div>
</div>
<!-- /.box-body -->