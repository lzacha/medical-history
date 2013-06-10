package medicalhistory

class Patient {

    static searchable = {
        spellCheck "include"
    }

	String firstName
	String lastName
	String sexId
	Date birthDate

    static hasManyAntecedents = [antecedents:Antecedent]
    static hasManyTreatments = [treatments:Treatment]
    static hasManyMedicalStudies = [medicalStudies:MedicalStudy]
    static hasManyPlates = [plates:Plate]


    //Antecedent antecedent
    //MedicalStudy medicalStudy
    //Treatment treatment
    //Plate plate
    //static constraints = {
    //}
}
