
<div class="box-body">
    <div class="row">
    </label>
        <div class="col-md-6">
            <div class="form-group ${hasErrors(bean: entryInstance, field: 'date', 'error')}">
                <label for="date">
                    <g:message code="entry.date.label" default="Fecha" />
                    <span class="required-indicator">*</span>
                <g:datePicker name="date" precision="day" noSelection="['':'-Choose-']" class="form-control" autofocus="autofocus" inputClass="date required"></g:datePicker>
            </div>
        </div>
    </div>


    <div class="form-group ${hasErrors(bean: entryInstance, field: 'number', 'error')}">
        <label for="number">
            <g:message code="entry.date.label" default="Numero" />

        </label>
            <g:textField name="number" class="form-control" placeholder="numero" value="${entryInstance?.number}" />

    </div>


    <div class="form-group ${hasErrors(bean: entryInstance, field: 'client', 'error')} required">
        <label for="client">
            <g:message code="entry.client.label" default="Cliente" />
            <span class="required-indicator">*</span>
        </label>
        <g:select id="client" name="clientId" from="${clients}" optionKey="id" optionValue="name" required="" value="${entryInstance?.client?.id}" class="many-to-one"/>
    </div>

    <div class="form-group ${hasErrors(bean: entryInstance, field: 'car', 'error')} required">
        <label for="car">
            <g:message code="entry.car.label" default="Automovil" />
            <span class="required-indicator">*</span>
        </label>
        <g:select id="car" name="carId" from="${cars}" optionKey="id" optionValue="mark" required="" value="${entryInstance?.car?.id}" />
    </div>

    <div class="form-group ${hasErrors(bean: entryInstance, field: 'string', 'error')}">
        <label for="diagnostic">
            <g:message code="entry.diagnostic.label" default="Diagnostico" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField name="diagnostic" class="form-control" placeholder="Diagnostico" value="${entryInstance?.diagnostic}" />
    </div>
</div>
<!-- /.box-body -->

<g:javascript>
    $(function() {

        $('.date').datepicker();
        $('.date').inputmask('Regex', { regex: "[0-9]{4}-[0-1][0-9]-[0-3][0-9]" });
    });
</g:javascript>