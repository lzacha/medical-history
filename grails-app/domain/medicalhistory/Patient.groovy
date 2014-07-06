package medicalhistory



class Patient {

    //Para el seach
    static searchable = {
        spellCheck "include"
    }

    int patientId
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
	
	
	Date birthDate

    Sex sex

    double height
    double weight
    double abdominalDiameter //Porque esta esto aca? cambia con el tiempo	
	
    String medicalHistory //Ver como es este campo...

    //static hasMany = [antecedents:Antecedent, treatments:Treatment, medicalStudies:MedicalStudy,plates:Plate]

    static constraints = {
        firstName(blank:false)
        lastName(blank:false)
        birthDate(blank:false)
    }
}
