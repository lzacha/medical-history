package medicalhistory

class MedicalStudy {

	Doctor doctor
	Date studyDate
	MainStudyType mainStudyType
	Patient patient
	//String mainStudy //Htal: Hospital, RCVC: ?, DgHTA: ?
	//MeasurementUnit unit // -- Ver porque estaba
	double height   //Altura
    double weight   //Peso
    double abdominalDiameter

    //static hasMany = [medicalStudies:Stud]
	
    static constraints = {
    }
}
