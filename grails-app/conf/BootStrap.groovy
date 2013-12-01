import medicalhistory.SystemUser
import grails.util.Environment
import medicalhistory.Patient
import medicalhistory.Doctor
import medicalhistory.AntecedentDetail
import medicalhistory.Treatment
import medicalhistory.AgeRange
import medicalhistory.MeasurementUnit
import medicalhistory.StudyTypeDetail
import medicalhistory.MainStudyType
import medicalhistory.utils.MedicalEnums
import medicalhistory.StudyType
import medicalhistory.FieldType
import medicalhistory.TreatmentFrequency
import medicalhistory.TreatmentDetail
import medicalhistory.Antecedent

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

        
		def mu0 = new MeasurementUnit(descriptionUnit:"Unidades", unit:"uni")
        def mu1 = new MeasurementUnit(descriptionUnit:"Centimetros cuadrados", unit:"cm2")
        def mu2 = new MeasurementUnit(descriptionUnit:"Centimetros cubicos", unit:"cm3")
        mu0.save()
		mu1.save()
        mu2.save()

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
		def tf3 = new TreatmentFrequency(frequencyDescription:"Quincenal")
		def tf4 = new TreatmentFrequency(frequencyDescription:"Mensual")
		def tf5 = new TreatmentFrequency(frequencyDescription:"Bimestral")
        tf1.save()
        tf2.save()
		tf3.save()
		tf4.save()
		tf5.save()
		

        def mst1 = new MainStudyType(mainStudyType:"Htal", description:"Hospital")
        def mst2 = new MainStudyType(mainStudyType:"RCVC", description:"RCVC")
        def mst3 = new MainStudyType(mainStudyType:"DgHTA", description:"DgHTA")
        mst1.save()
        mst2.save()
        mst3.save()


        
        def antDet1 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"HTA",completeName:"NombreCompleto HTA", fieldType:ft1, decimalsQuantity:2, measureUnit:mu1)
        def antDet2 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"DLP",completeName:"NombreCompleto DLP", fieldType:ft2, decimalsQuantity:2, measureUnit:mu2)
        def antDet3 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"TBQ",completeName:"NombreCompleto TBQ", fieldType:ft3, decimalsQuantity:2, measureUnit:mu1)
        def antDet4 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"EXTBQ",completeName:"NombreCompleto EXTBQ", fieldType:ft4, decimalsQuantity:2, measureUnit:mu2)

		def antDet5 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"AHF",completeName:"Factor Anti-Hemofílico", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet6 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"DBT",completeName:"Diabetes", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet7 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"IAM",completeName:"Infarto Aguso de Miocardio", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet8 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"ACV/TIA",completeName:"Accidente Cerebro Vascular / Accidente Isquémico Transitorio", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet9 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"ENF CORONARIA",completeName:"Enfermedad Coronaria", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet10 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"EC",completeName:"Enfermedad Celíaca", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet11 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"CRM",completeName:"Cirugía de Revascularización Miocárdica", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet12 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"ATC",completeName:"Angioplastía Transluminal Coronaria", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet13 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"EVP",completeName:"Enfermedad Vascular Periférica", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def antDet14 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"HIPO",completeName:"Hipotiroidismo", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		
		
        antDet1.save()
        antDet2.save()
        antDet3.save()
        antDet4.save()
        antDet5.save()
        antDet6.save()
		antDet7.save()
		antDet8.save()
		antDet9.save()
		antDet10.save()
		antDet11.save()
		antDet12.save()
		antDet13.save()
		antDet14.save()
 

        def doc1 = new Doctor(docId:1, medicalEnrollment:"e1", firstName:"Rene1", lastName:"Favaloro1")
        def doc2 = new Doctor(docId:2, medicalEnrollment:"e1", firstName:"Rene2", lastName:"Favaloro2")
        def doc3 = new Doctor(docId:3, medicalEnrollment:"e1", firstName:"Rene3", lastName:"Favaloro3")
        doc1.save()
        doc2.save()
        doc3.save()

 //       def st1 = new StudyType(studyType:"Laboratorio")
 //       def st2 = new StudyType(studyType:"Sed Urinario")
 //      st1.save()
 //       st2.save()

//        def t1 = new Treatment(antecedentDetailId: 1,internalCode: 'ENF CORONARIA', description: 'ENF CORONARIA')
//        t1.save()

        def ar1 = new AgeRange(rangeDescription:"niÃ±os", minValue:1, maxValue:10)//, sex: "hombre") //, sex: AgeRange.PatientSex.MAN)
        def ar2 = new AgeRange(rangeDescription:"adolescentes", minValue:11, maxValue:19)//, sex:"hombre") //, sex: AgeRange.PatientSex.MAN)
        def ar3 = new AgeRange(rangeDescription:"adultos", minValue:20, maxValue:120)//, sex:"hombre") //, sex: AgeRange.PatientSex.MAN)
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

		def trtDet1 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"BETA  BLOQ",completeName:"Beta Bloqueadores", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet2 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"BLOQ CALCI",completeName:"Bloqueante Cálcico", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet3 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"IECA",completeName:"Inhibidor del Enzima Conversor de la Angiotensina", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet4 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"INH  AT2",completeName:"Isoniacida", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet5 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"AAS",completeName:"Anabolizante Androgénico Esteroideo", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet6 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"CLOPI",completeName:"Clopidogrel", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet7 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"DIURET",completeName:"Diuréticos", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet8 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"ESTATINAS",completeName:"Estatinas", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet9 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"FIBRATOS",completeName:"Fibratos", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet10 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"EZETIMIBE",completeName:"Ezetimibe", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet11 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"METFORMINA",completeName:"Metformina", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet12 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"SULFONILU",completeName:"Sulfonilureas", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet13 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"GLIATAZO",completeName:"Gliatazo", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		def trtDet14 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"OTROS",completeName:"Otros Tratamientos ", fieldType:ft1, decimalsQuantity:0, measureUnit:mu0)
		
		trtDet1.save()
		trtDet2.save()
		trtDet3.save()
		trtDet4.save()
		trtDet5.save()
		trtDet6.save()
		trtDet7.save()
		trtDet8.save()
		trtDet9.save()
		trtDet10.save()
		trtDet11.save()
		trtDet12.save()
		trtDet13.save()
		trtDet14.save()
		
        def antecendet1 = new Antecedent(patienta:patient1, antecedentDetail:antDet1, antecedentValue:"2"  )
        antecendet1.save()

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