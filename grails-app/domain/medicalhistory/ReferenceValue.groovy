package medicalhistory

class ReferenceValue {

    String sex
    AgeRanges ageRange

    int minValue
    int maxValue

    StudyTypesDetail studyTypesDetail

    //MeasurementUnit unit

    int decimalQuantity

    static constraints = {
    }
}
