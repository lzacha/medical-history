package medicalhistory



class Patient {

    //Para el seach
    static searchable = {
        spellCheck "include"
    }

    String patientId
	String firstName
	String lastName


	enum Sex {
        MASCULINO("MASCULINO"), FEMENINO("FEMENINO")

        final String value

        Sex(String value) {
            this.value = value
        }

        String toString() {
            value
        }
	}
    Sex sex


	Date birthDate

    double height
    double weight
    double abdominalDiameter //Porque esta esto aca? cambia con el tiempo	
	
    String medicalHistory //Ver como es este campo...

    //static hasMany = [antecedents:AntecedentValue, treatments:TreatmentValue, medicalStudies:MedicalStudy,plates:Plate]

    //static constraints = {
        //firstName(blank:false)
        //lastName(blank:false)
        //birthDate(blank:false)
    //}
}
