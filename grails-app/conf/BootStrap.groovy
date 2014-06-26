import medicalhistory.SystemUser
import grails.util.Environment
import medicalhistory.Patient
import medicalhistory.Doctor
import medicalhistory.AntecedentDetail
import medicalhistory.StudyTypesValues
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

		// Study Types 
		
        def st1 = new StudyTypes(description:"Laboratorio").save()
        def st2 = new StudyTypes(description:"Sed Urinario").save()
        def st3 = new StudyTypes(description:"Lab HTA").save()
        def st4 = new StudyTypes(description:"Pletismografia").save()
        def st5 = new StudyTypes(description:"PEG").save()
        def st6 = new StudyTypes(description:"Camara Gamma").save()
		def st7 = new StudyTypes(description:"ECO Doppler Abdominal").save()
		def st8 = new StudyTypes(description:"ECO Vasos de Cuello").save()
		def st9 = new StudyTypes(description:"Espesor Miointimal").save()
		def st10 = new StudyTypes(description:"ECO Doppler Cardiaco").save()
		def st11 = new StudyTypes(description:"MAPA Resumen").save()
		def st12 = new StudyTypes(description:"MAPA Dia").save()
		def st13 = new StudyTypes(description:"MAPA Noche").save()
		def st14 = new StudyTypes(description:"RxTx").save()
		def st15 = new StudyTypes(description:"Variabilidad de la tension arterial y Sensibilidad de Barorreflejo").save()
		
	
		// 	StudyTypesDetails de StudyTypes = "Laboratorio"
		
        def std1 = new StudyTypesDetails(abbreviation: "HTO", description: "Hematocrito", completeName: "Hematocrito", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std2 = new StudyTypesDetails(abbreviation: "Hb", description: "Hemoglobina", completeName: "Hemoglobina", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std3 = new StudyTypesDetails(abbreviation: "Leucos", description: "Leucocitos", completeName: "Leucocitos", decimalsQuantity: 0, minRange: 0, maxRange: 20000, studyTypes: st1 ).save()
		def std4 = new StudyTypesDetails(abbreviation: "PROMIELOCITOS", description: "Promielocitos", completeName: "Promielocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std5 = new StudyTypesDetails(abbreviation: "MIELOCITOS", description: "Mielocitos", completeName: "Mielocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std6 = new StudyTypesDetails(abbreviation: "METAMIELOCITOS", description: "Metamielocitos", completeName: "Metamielocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std7 = new StudyTypesDetails(abbreviation: "CAYADO", description: "Cayado", completeName: "Cayado", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std8 = new StudyTypesDetails(abbreviation: "SEGMENTADOS", description: "Segmentados", completeName: "Segmentados", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std9 = new StudyTypesDetails(abbreviation: "EOSINOFILOS", description: "Eosinofilos", completeName: "Eosinofilos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std10 = new StudyTypesDetails(abbreviation: "BASOFILOS", description: "Basofilos", completeName: "Basofilos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std11 = new StudyTypesDetails(abbreviation: "LINFOCITOS", description: "Linfocitos", completeName: "Linfocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std12 = new StudyTypesDetails(abbreviation: "MONOCITOS", description: "Monocitos", completeName: "Monocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std13 = new StudyTypesDetails(abbreviation: "ESD", description: "ESD", completeName: "ESD", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std14 = new StudyTypesDetails(abbreviation: "TGO", description: "Transaminasa glutamico oxalacetica", completeName: "Transaminasa glutamico oxalacetica", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std15 = new StudyTypesDetails(abbreviation: "TGP", description: "Transaminasa glutamico piruvica", completeName: "Transaminasa glutamico piruvica", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std16 = new StudyTypesDetails(abbreviation: "FAL", description: "Fosfatasa alcalina", completeName: "Fosfatasa alcalina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std17 = new StudyTypesDetails(abbreviation: "Bil Tot", description: "Bilirrubuna total", completeName: "Bilirrubuna total", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std18 = new StudyTypesDetails(abbreviation: "Bil Dir", description: "Bilirrubuna directa", completeName: "Bilirrubuna directa", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std19 = new StudyTypesDetails(abbreviation: "Col Total", description: "Colesterol total", completeName: "Colesterol total", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std20 = new StudyTypesDetails(abbreviation: "Col HDL", description: "Colesterol HDL", completeName: "Colesterol HDL", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std21 = new StudyTypesDetails(abbreviation: "Col LDL", description: "Colesterol LDL", completeName: "Colesterol LDL", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std22 = new StudyTypesDetails(abbreviation: "Trigliceridos", description: "Trigliceridos", completeName: "Trigliceridos", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std23 = new StudyTypesDetails(abbreviation: "Ac Urico", description: "Acido urico", completeName: "Acido urico", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std24 = new StudyTypesDetails(abbreviation: "MicroAlbuminuria", description: "Microalbuminuria", completeName: "Microalbuminuria", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std25 = new StudyTypesDetails(abbreviation: "PCR ultra", description: "Reacción en cadena de la polimerasa", completeName: "Reacción en cadena de la polimerasa", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std26 = new StudyTypesDetails(abbreviation: "Glu basal", description: "Glucosa basal", completeName: "Glucosa basal", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std27 = new StudyTypesDetails(abbreviation: "Glu 120'", description: "Glucosa basal 120'", completeName: "Glucosa basal 120'", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std28 = new StudyTypesDetails(abbreviation: "PTOG 120", description: "Prueba de tolerancia oral a la glucosa 120'", completeName: "Glucosa basal 120'", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std29 = new StudyTypesDetails(abbreviation: "Urea", description: "Urea", completeName: "Urea", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std30 = new StudyTypesDetails(abbreviation: "Sodio", description: "Sodio", completeName: "Sodio", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std32 = new StudyTypesDetails(abbreviation: "Potasio", description: "Potasio", completeName: "Potasio", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std33 = new StudyTypesDetails(abbreviation: "Creatinina", description: "Creatinina", completeName: "Creatinina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std34 = new StudyTypesDetails(abbreviation: "Cl Creat", description: "Clearence de creatinina", completeName: "Clearence de creatinina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std35 = new StudyTypesDetails(abbreviation: "Na urinario", description: "Sodio urinario", completeName: "Sodio urinario", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std36 = new StudyTypesDetails(abbreviation: "K urinario", description: "Potasio urinario", completeName: "Potasio urinario", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std37 = new StudyTypesDetails(abbreviation: "Homocisteina", description: "Homocisteina", completeName: "Homocisteina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std38 = new StudyTypesDetails(abbreviation: "Fibrinogeno", description: "Fibrinogeno", completeName: "Fibrinógeno", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		
		
        

//        def t1 = new Treatment(antecedentDetailId: 1,internalCode: 'ENF CORONARIA', description: 'ENF CORONARIA')
//        t1.save()


        def ar1 = new AgeRanges(rangeDescription:"niÃ±os", minValue:1, maxValue:10)//, sex: "hombre") //, sex: AgeRange.PatientSex.MAN)
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

		def stv1 = new StudyTypesValues(studyTypesDetails:std1,value:1)
		def stv2 = new StudyTypesValues(studyTypesDetails:std2,value:2)
		def stv3 = new StudyTypesValues(studyTypesDetails:std3,value:3)
		stv1.save()
		stv2.save()
		stv3.save()
		
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