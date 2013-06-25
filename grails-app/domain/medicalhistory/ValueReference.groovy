package medicalhistory

class ValueReference {

    String sex
    int minValue
    int maxValue

    StudyTypeDetail studyTypeDetail
    MeasurementUnit unit 
    AgeRange ageRange

    int decimalQuantity

    static constraints = {
    }
}
