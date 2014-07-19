<div>
    Tratamientos
    <g:select name="antecedents" from="${medicalhistory.Treatment.list()}" multiple="multiple"
              optionKey="id" size="5" value="${treatmentInstance?.treatmentInstance*.id}" class="many-to-many"
              optionValue="${{ trt -> "${trt.description}" }}"

              onChange="${remoteFunction( controller: 'Study',
                      action:'loadTreatmentsInputs',
                      params: '\'id=\'+escape(this.value)',
                      update: 'treatmentDetailsDiv' )}"/>

    <div id="treatmentDetailsDiv">

    </div>

    <!--
	<label for="studyTypesDetails" >std:</label>
  	<g:select name="treatmentDetails" noSelection="['':'Select one...']" from="${std}">
    </g:select>
    -->

</div>