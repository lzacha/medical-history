package medicalhistory

class AgeRange {

    /*
    enum PatientSex {
        MAN("Hombre"), WOMAN("Mujer"), BOTH("Ambos")

        final String value
        PatientSex(String value) {
            this.value = value
        }
        String toString() {
            value
        }
    }
    */

	String rangeDescription
	int minValue
	int maxValue
	//PatientSex sex
    String sex

    static constraints = {
    	rangeDescription blank: false, size: 3..150
		minValue blank: false, min: 0, max: 200
        maxValue  blank: false, min: 0, max: 200
        //sexz blank: false

    }
}
