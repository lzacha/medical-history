package medicalhistory

class StudyTypesTable {

    //Fecha de alta de estudio
    Date studyDate

    String studyType

    Patient patient

    //Datos
    double height
    double weight
    double abdominalDiameter

    def antecedents = [:]
    def treatments = [:]
    def studies = [:]

    def plates = [:]


    //static hasMany = [studyTypes:StudyTypes]
    //


    static constraints = {
    }
}
