package medicalhistory

class Treatment {

	//Boolean antecedentValue
    Patient patient
    TreatmentFrequency frequency

    static hasMany = [treatmentDetails:TreatmentDetail]
    
    static constraints = {
    }


}
