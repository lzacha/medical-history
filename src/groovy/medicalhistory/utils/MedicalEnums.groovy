package medicalhistory.utils
class MedicalEnums {
	
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

	enum StudyType {
		LABORATORY("Laboratorio"), URINAL("Sed Urinario")
		
		final String value
		StudyType(String value) {
			this.value = value
		}
		String toString() {
			value
		}
	}

	enum FieldType {
		NUMERIC("Numerico"), ALPHANUMERIC("Alfanumerico")
		
		final String value
		FieldType(String value) {
			this.value = value
		}
		String toString() {
			value
		}
	}


}
