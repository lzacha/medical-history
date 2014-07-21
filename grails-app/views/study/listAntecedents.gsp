<div>
Antecedentes
    <g:select id="antecedentSelect"
              name="antecedents"
              from="${medicalhistory.Antecedent.list()}"
              multiple="multiple"
              optionKey="id"
              size="5"
              value="${antecedentInstance?.antecedentInstance*.id}"
              class="many-to-many"
              optionValue="${{ an -> "${an.description}" }}"
              onChange="${remoteFunction( controller: 'Study',
                      action:'loadAntecedentsInputs',
                      params: '\'id=\'+escape(this.value)',
                      update: 'antecedentDetailsDiv' )}"/>

    <g:form action="saveAntecedentValues">
        <div id="antecedentDetailsDiv"></div>
        <g:hiddenField name="antecedentId" value="" />
    </g:form>
</div>

<script>
    $("#antecedentSelect").change(
        function() {
            $("#antecedentId").val( $("#antecedentSelect").val());
        }
    );
</script>