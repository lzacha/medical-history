package medicalhistory

/*
 * Iba a ser el tablon
 */
class MedicalStudy {

    Patient patient
    Doctor doctor
	Date studyDate

    MainStudyType mainStudyType //Htal / RCVC

	double height   //Altura
    double weight   //Peso
    double abdominalDiameter

    //static hasMany = [studyType:StudyType]
	
    //static constraints = {
    //}
}
