package medicalhistory

class Patient {

    //Para el seach
    static searchable = {
        spellCheck "include"
    }

    int patientId
	String firstName
	String lastName
	String sexId
	Date birthDate

    double height   //Altura
    double weight   //Peso
    double abdominalDiameter //Porque esta esto aca? cambia con el tiempo

    String medicalHistory //Ver como es este campo...

    //static hasMany = [antecedents:Antecedent, treatments:Treatment, medicalStudies:MedicalStudy,plates:Plate]

    static constraints = {
        firstName(blank:false)
        lastName(blank:false)
        sexId(blank:false)
        birthDate(blank:false)
    }
}
