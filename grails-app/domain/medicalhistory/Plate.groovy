package medicalhistory

class Plate {

	String plateDescription
	
	Date plateDate

	String fieldPlate2
	String fieldPlate3

	String imagePlate

	Doctor doctor
	
	String observation

	//List observations = new List(
	//static hasMany = [observations:PlateDetail]

    static constraints = {
    }
}
