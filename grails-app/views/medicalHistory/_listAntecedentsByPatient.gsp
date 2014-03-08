<g:each in="${ants}">
    <!--p>PatientId: ${it.patient}</p -->
    <p>AntValue: ${it.antecedentValue}</p>
    <p>AntValue: ${it.antecedentDetails.antecedentStudyType}</p>

</g:each>