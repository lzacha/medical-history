package medicalhistory

class Patient {

    static searchable = {
        spellCheck "include"
    }


    int patientId
	String firstName
	String lastName
	String sexId
	Date birthDate

    static hasManyAntecedents = [antecedents:Antecedent]
    static hasManyTreatments = [treatments:Treatment]
    static hasManyMedicalStudies = [medicalStudies:MedicalStudy]
    static hasManyPlates = [plates:Plate]

    static constraints = {
        firstName(blank:false)
        lastName(blank:false)
        sexId(blank:false)
        birthDate(blank:false)
    }
}
