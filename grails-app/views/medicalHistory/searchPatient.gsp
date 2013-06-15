<g:if test="${name == 'leo'}">
<div>
    <h1>Leo</h1>
</g:if>
<g:else>
    <h1>Buscar Paciente e</h1>

    <form id="example_form" action="#" method="GET" class="ch-form">
        <div class="ch-form-row">
            <label for="autocomplete">Paciente:</label>
            <input id="autocomplete"
                   type="text"
                   name="autocomplete"
                   placeholder="Nombre del paciente"
                   class="autoComplete_Example ch-autoComplete"
            />
            <input type="submit" value="Buscar">
        </div>
    </form>
</div>

</g:else>


