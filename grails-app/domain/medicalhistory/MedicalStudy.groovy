package medicalhistory

class MedicalStudy {

	Doctor doctor
	Date studyDate
	String mainStudy //Htal: Hospital, RCVC: ?, DgHTA: ?

	Patient patient

	MeasurementUnit unit //?

    static hasMany = [medicalStudies:MedicalStudyDetail]
	
    static constraints = {
    }
}
