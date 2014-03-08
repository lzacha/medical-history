import medicalhistory.SystemUser
import grails.util.Environment
import medicalhistory.Patient
import medicalhistory.Doctor
import medicalhistory.AntecedentDetail
import medicalhistory.Treatment
import medicalhistory.AgeRanges
//import medicalhistory.MeasurementUnit
import medicalhistory.StudyTypesDetails
import medicalhistory.MainStudyType
import medicalhistory.utils.MedicalEnums
import medicalhistory.FieldType
import medicalhistory.TreatmentFrequency
import medicalhistory.TreatmentDetail
import medicalhistory.Antecedent
import medicalhistory.StudyTypes

class BootStrap {

    def init = { servletContext ->

        if(Environment.current == Environment.DEVELOPMENT)
            setDevelopmentData()

        if(Environment.current == Environment.TEST)
            setTestData()

        if(Environment.current == Environment.PRODUCTION)
            setProductionData()

    }




    def destroy = {

    }

    def setDevelopmentData(){

        //System users
        def su1 = new SystemUser(username: 'lzacharewicz', password: '123456', firstName: 'Leonardo', lastName: 'Zacharewicz', status: 'Active', role:"admin", lastLogin: new Date())
        def su2 = new SystemUser(username: 'mmaceiras', password: '123456', firstName: 'Mariano', lastName: 'Maceiras', status: 'Active', role:"admin", lastLogin: new Date())
        def su3 = new SystemUser(username: 'rgirlando', password: '123456', firstName: 'Rodrigo', lastName: 'Girlando', status: 'Inactive',role:"admin",  lastLogin: new Date())
        def su4 = new SystemUser(username: 'mfava', password: '123456', firstName: 'Martin', lastName: 'Fava', status: 'Active', role:"admin", lastLogin: new Date())
        def su5 = new SystemUser(username: 'gheinrich', password: '123456', firstName: 'Gabriel', lastName: 'Heinrich', status: 'Active', role:"admin", lastLogin: new Date())
        su1.save()
        su2.save()
        su3.save()
        su4.save()
        su5.save()

        
       //def mu1 = new MeasurementUnit(descriptionUnit:"Centimetros cuadrados", unit:"cm2")
        //def mu2 = new MeasurementUnit(descriptionUnit:"Centimetros cubico", unit:"cm3")
        //mu1.save()
        //mu2.save()

        def ft1 = new FieldType(fieldName:"Numerico")
        def ft2 = new FieldType(fieldName:"Alfanumerico")
        def ft3 = new FieldType(fieldName:"Si")
        def ft4 = new FieldType(fieldName:"No")
        ft1.save()
        ft2.save()
        ft3.save()
        ft4.save()

        def tf1 = new TreatmentFrequency(frequencyDescription:"Diario")
        def tf2 = new TreatmentFrequency(frequencyDescription:"Semanal")
        tf1.save()
        tf2.save()

        def mst1 = new MainStudyType(mainStudyType:"Htal", description:"Hospital")
        def mst2 = new MainStudyType(mainStudyType:"RCVC", description:"RCVC")
        def mst3 = new MainStudyType(mainStudyType:"DgHTA", description:"DgHTA")
        mst1.save()
        mst2.save()
        mst3.save()

        def antDet1 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"HTA",completeName:"NombreCompleto HTA", fieldType:ft1, decimalsQuantity:2/*, measureUnit:mu1*/)
        def antDet2 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"DLP",completeName:"NombreCompleto DLP", fieldType:ft2, decimalsQuantity:2/*, measureUnit:mu2*/)
        def antDet3 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"TBQ",completeName:"NombreCompleto TBQ", fieldType:ft3, decimalsQuantity:2/*, measureUnit:mu1*/)
        def antDet4 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"EXTBQ",completeName:"NombreCompleto EXTBQ", fieldType:ft4, decimalsQuantity:2/*, measureUnit:mu2*/)
        def antDet5 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"AHF",completeName:"NombreCompleto AHF", fieldType:ft1, decimalsQuantity:2/*, measureUnit:mu1*/)
        def antDet6 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"DBT",completeName:"NombreCompleto DBT", fieldType:ft2, decimalsQuantity:2/*, measureUnit:mu2*/)
        antDet1.save()
        antDet2.save()
        antDet3.save()
        antDet4.save()
        antDet5.save()
        antDet6.save()




        def doc1 = new Doctor(docId:1, medicalEnrollment:"e1", firstName:"Rene1", lastName:"Favaloro1")
        def doc2 = new Doctor(docId:2, medicalEnrollment:"e1", firstName:"Rene2", lastName:"Favaloro2")
        def doc3 = new Doctor(docId:3, medicalEnrollment:"e1", firstName:"Rene3", lastName:"Favaloro3")
        doc1.save()
        doc2.save()
        doc3.save()

        def st1 = new StudyTypes(description:"Laboratorio")
        st1.save()


        def st2 = new StudyTypes(description:"Sed Urinario")
        def st3 = new StudyTypes(description:"Lab HTA")
        def st4 = new StudyTypes(description:"Pletismografía")
        def st5 = new StudyTypes(description:"PEG")
        def st6 = new StudyTypes(description:"Cámara Gamma")

        st1.save()
        st2.save()
        st3.save()
        st4.save()
        st5.save()
        st6.save()

        def std1 = new StudyTypesDetails(abbreviation: "HTO", description: "laza azals2 aazr", completeName: "No tengo idea", decimalsQuantity: 2, minRange: 1, maxRange: 10, studyTypes: st1 )
        def std2 = new StudyTypesDetails(abbreviation: "Hb", description: "laza azals2 aazr", completeName: "No tengo idea", decimalsQuantity: 2, minRange: 1, maxRange: 10, studyTypes: st2 )
        def std3 = new StudyTypesDetails(abbreviation: "Leucos", description: "laza azals2 aazr", completeName: "No tengo idea", decimalsQuantity: 2, minRange: 1, maxRange: 10, studyTypes: st3 )
        def std4 = new StudyTypesDetails(abbreviation: "ESD", description: "laza azals2 aazr", completeName: "No tengo idea", decimalsQuantity: 2, minRange: 1, maxRange: 10, studyTypes: st4 )

        std1.save()
        std2.save()
        std3.save()
        std4.save()

//        def t1 = new Treatment(antecedentDetailId: 1,internalCode: 'ENF CORONARIA', description: 'ENF CORONARIA')
//        t1.save()


        def ar1 = new AgeRanges(rangeDescription:"niños", minValue:1, maxValue:10)//, sex: "hombre") //, sex: AgeRange.PatientSex.MAN)
        def ar2 = new AgeRanges(rangeDescription:"adolescentes", minValue:11, maxValue:19)//, sex:"hombre") //, sex: AgeRange.PatientSex.MAN)
        def ar3 = new AgeRanges(rangeDescription:"adultos", minValue:20, maxValue:120)//, sex:"hombre") //, sex: AgeRange.PatientSex.MAN)
        ar1.save()
        ar2.save()
        ar3.save()


        def patient1 = new Patient(height:1, weight:1, abdominalDiameter:1, medicalHistory:1, patientId: 1,firstName: "Ariel", lastName: "Ortega", sexId: "Masculino", birthDate: new Date())
        def patient2 = new Patient(height:2, weight:2, abdominalDiameter:2, medicalHistory:2, patientId: 2,firstName: "Diego", lastName: "Latorre", sexId: "Masculino", birthDate:new Date())
        def patient3 = new Patient(height:3, weight:3, abdominalDiameter:3, medicalHistory:3, patientId: 3,firstName: "Carlos", lastName: "Tevez", sexId: "Masculino", birthDate:new Date())
        def patient4 = new Patient(height:4, weight:4, abdominalDiameter:4, medicalHistory:4, patientId: 4,firstName: "Martin", lastName: "Palermo", sexId: "Masculino", birthDate:new Date())
        def patient5 = new Patient(height:5, weight:5, abdominalDiameter:5, medicalHistory:5, patientId: 5,firstName: "Martin", lastName: "Zanetti", sexId: "Masculino", birthDate:new Date())
        def patient6 = new Patient(height:6, weight:6, abdominalDiameter:6, medicalHistory:6, patientId: 6,firstName: "Martin", lastName: "Maradona", sexId: "Masculino", birthDate:new Date())
        def patient7 = new Patient(height:7, weight:7, abdominalDiameter:7, medicalHistory:7, patientId: 7,firstName: "Jose", lastName: "Flores", sexId: "Masculino", birthDate:new Date())
        patient1.save()
        patient2.save()
        patient3.save()
        patient4.save()
        patient5.save()
        patient6.save()
        patient7.save()

        def trtDet1 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"BETA  BLOQ",completeName:"Beta Bloqueadores1", fieldType:ft1, decimalsQuantity:2/*, measureUnit:mu1*/)
        def trtDet2 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"BETA  BLOQ",completeName:"Beta Bloqueadores2", fieldType:ft1, decimalsQuantity:2/*, measureUnit:mu1*/)
        def trtDet3 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"BETA  BLOQ",completeName:"Beta Bloqueadores3", fieldType:ft1, decimalsQuantity:2/*, measureUnit:mu1*/)
        trtDet1.save()
        trtDet2.save()
        trtDet3.save()

        def antecendet1 = new Antecedent(patient:patient1, antecedentDetails:antDet1, antecedentValue:"1"  )
        def antecendet2 = new Antecedent(patient:patient1, antecedentDetails:antDet2, antecedentValue:"2"  )
        def antecendet3 = new Antecedent(patient:patient1, antecedentDetails:antDet3, antecedentValue:"3"  )
        def antecendet4 = new Antecedent(patient:patient1, antecedentDetails:antDet4, antecedentValue:"4"  )
        def antecendet5 = new Antecedent(patient:patient1, antecedentDetails:antDet5, antecedentValue:"5"  )

        antecendet1.save()
        antecendet2.save()
        antecendet3.save()
        antecendet4.save()
        antecendet5.save()

//        def msd1 = new MedicalStudyDetail(  ageRange: ar1, studyType: st1,
//                                            abbreviation: "HTO", completeName: "Hipo todo zaraza",
//                                            fieldType: ft1, minValue:1, maxValue:10,
//                                            decimalsQuantity: 2, unit:mu1)
//
//        msd1.save()

    }

    def setTestData(){}

    def setProductionData(){}



}