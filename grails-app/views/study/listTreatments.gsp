<div>
    Tratamientos
    <g:select name="treatmentSelect"
              from="${medicalhistory.Treatment.list()}"
              multiple="multiple"
              optionKey="id"
              size="5"
              value="${treatmentInstance?.treatmentInstance*.id}"
              class="many-to-many"
              optionValue="${{ trt -> "${trt.description}" }}"

              onChange="${remoteFunction( controller: 'Study',
                      action:'loadTreatmentsInputs',
                      params: '\'id=\'+escape(this.value)',
                      update: 'treatmentDetailsDiv' )}"/>

    <g:form action="saveTreatmentsValues">
        <div id="treatmentDetailsDiv"></div>
        <g:hiddenField name="treatmentId" value="" />
    </g:form>

</div>
<script>
    $("#antecedentSelect").change(
            function() {
                $("#treatmentId").val( $("#antecedentSelect").val());
            }
    );

</script>