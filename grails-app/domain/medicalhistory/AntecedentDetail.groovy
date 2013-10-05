package medicalhistory

class AntecedentDetail {

	/*
    enum AntecedentStudyType {
 
        FRC("FRC"), ANT("Antecedente")
 
        final String value
        AntecedentStudyType(String value) {
            this.value = value
        }
 
        String toString() {
            value
        }
    }*/

	//AntecedentStudyType antecedentStudyType
    //String antecedentStudyType	//Son fijos: Antecedent - FRC
    String abbreviation
    String completeName
    FieldType fieldType
    int decimalsQuantity
    MeasurementUnit measureUnit
    
    static constraints = {
    }
}
