package medicalhistory

class Philiatory {

    double height
    double weight
    double abdominalDiameter //Porque esta esto aca? cambia con el tiempo

    static hasMany = [patients:Patient]

    static constraints = {
    }
}
