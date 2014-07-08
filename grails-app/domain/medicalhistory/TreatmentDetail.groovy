package medicalhistory

class TreatmentDetail {

    enum TreatmentType {
 
        TREATMENT("Tratamiento")
 
        final String value
        TreatmentType(String value) {
            this.value = value
        }
 
        String toString() {
            value
        }
    }

    TreatmentType treatmentType    //String antecedentStudyType	//Son fijos: AntecedentValue - FRC
    String abbreviation
    String completeName
    FieldType fieldType
    MeasurementUnit measurementUnit
    int decimalsQuantity

    //MeasurementUnit measureUnit
    
    //static constraints = {
    //}
}
