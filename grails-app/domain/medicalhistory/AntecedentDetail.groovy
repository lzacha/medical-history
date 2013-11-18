package medicalhistory

class AntecedentDetail {


    enum AntecedentStudyType {
 
        FRC("FRC"), ANT("Antecedente")
 
        final String value
        AntecedentStudyType(String value) {
            this.value = value
        }
 
        String toString() {
            value
        }
    }

	AntecedentStudyType antecedentStudyType
    String abbreviation
    String completeName
    FieldType fieldType
    int decimalsQuantity
    MeasurementUnit measureUnit

    /* TODO: constraints definition */
    static constraints = {

    }
}
