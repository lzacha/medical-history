package medicalhistory

class Treatment {

    static hasMany = [treatments:TreatmentDetail]

    static constraints = {
    }
}
