<div>
Estudios
    <g:select name="studySelect"
              from="${medicalhistory.StudyTypes.list()}"
              multiple="multiple"
              optionKey="id"
              size="5"
              value="${studyTypesInstance?.studyTypesInstance*.id}"
              class="many-to-many"
              optionValue="${{ st -> "${st.description}" }}"
              onChange="${remoteFunction( controller: 'Study',
                      action:'loadStudyTypesInputs',
                      params: '\'id=\'+escape(this.value)',
                      update: 'studyTypesDetailsDiv' )}"/>

    <g:form action="saveStudyTypesValues">
        <div id="studyTypesDetailsDiv"></div>
        <g:hiddenField name="studyId" value="" />
    </g:form>
</div>

<script>
    $("#studySelect").change(
            function() {
                $("#studyId").val( $("#studySelect").val());
            }
    );
</script>