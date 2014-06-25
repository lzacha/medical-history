<div>
	<label for="studyTypes">
		<g:message code="studyTypesValues.studyTypes.label" default="Study Types" />
		
	</label>
	<g:select name="studyTypes" from="${medicalhistory.StudyTypes.list()}" multiple="multiple" 
	optionKey="id" size="5" value="${studyTypesInstance?.studyTypesInstance*.id}" class="many-to-many"
	optionValue="${{ st -> "${st.description}" }}" 
	
	onChange="${remoteFunction( controller: 'Study',
								action:'loadStudyTypesValues',
                                params: '\'id=\'+escape(this.value)',
                                update: 'studyTypesValuesDiv' )}"/>
	
	<div id="studyTypesValuesDiv">
	
	</div>
	
	<!--  
	<label for="studyTypesDetails" >std:</label>
  		<g:select name="studyTypesDetails" noSelection="['':'Select one...']" from="${std}">
	</g:select>	
    -->

</div>