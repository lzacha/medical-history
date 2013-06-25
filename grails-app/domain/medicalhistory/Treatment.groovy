package medicalhistory

class Treatment {

	//Boolean antecedentValue
    Patient patient
    
    static hasMany = [treatmentDetails:TreatmentDetail]
    
    static constraints = {
    }

    TreatmentFrequency frequency
}
