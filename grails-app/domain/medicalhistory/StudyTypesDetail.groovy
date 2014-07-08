package medicalhistory

class StudyTypesDetail {

    StudyTypes studyTypes //Laboratorio, Peg, etc...

    String description
    String abbreviation
    String completeName

    double minRange
    double maxRange
    FieldType fieldType //Numerico, alfanumerico
    int decimalsQuantity
    MeasurementUnit measurementUnit //cm3, cm3

    //static constraints = {
    //}
}
