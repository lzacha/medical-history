package medicalhistory

class MedicalStudy {

    static hasMany = [medicalStudies:MedicalStudyDetail]
	Doctor	doctor
    static constraints = {
    }
}
