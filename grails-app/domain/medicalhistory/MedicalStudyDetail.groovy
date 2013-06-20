package medicalhistory

class MedicalStudyDetail {

 	AgeRange ageRange
 	StudyType studyType // Deberia ser un enum, acotado
    FieldType fieldType

 	String abbreviation
    String completeName
    int minValue
    int maxValue
    int decimalsQuantity

    //PONER UN ORDEN POR SI ESTAN ACOSTUMBRADOS A ALGUN EN PARTICULAR
    
    MeasurementUnit unit

    static constraints = {
    }
}
