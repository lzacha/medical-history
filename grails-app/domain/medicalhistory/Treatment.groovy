package medicalhistory

class Treatment {


	int treatmentId
	String treatmentCode 	//Abrev...
	String treatmentDetail  //Complete name..	
	int treatmentValue  	//Numeric value..	

	MeasurementUnit unit
    Patient patient

    TreatmentFrequency frequency

    static hasMany = [treatments:TreatmentDetail]

    static constraints = {
    }
}
