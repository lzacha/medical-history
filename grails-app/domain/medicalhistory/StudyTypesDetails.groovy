package medicalhistory

class StudyTypesDetails {

    static hasMany = [studyTypes:StudyTypes]

    String description
    String abbreviation
    String completeName

    enum FieldType {

        NUM("NUMERICO"), ALFANUMERICO("ALFANUMERICO")

        final String value
        FieldType(String value) {
            this.value = value
        }

        String toString() {
            value
        }
    }

    int minRange
    int maxRange

    int decimalsQuantity

    //MeasurementUnit measurementUnit

    static constraints = {
    }
}
