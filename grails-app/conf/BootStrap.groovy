import medicalhistory.SystemUser
import grails.util.Environment
import medicalhistory.Patient
import medicalhistory.Doctor
import medicalhistory.AntecedentDetail
import medicalhistory.StudyTypesValues
import medicalhistory.TreatmentValue
import medicalhistory.AgeRanges
import medicalhistory.MainStudyType
import medicalhistory.FieldType
import medicalhistory.TreatmentFrequency
import medicalhistory.TreatmentDetail
import medicalhistory.AntecedentValue
import medicalhistory.StudyTypes
import medicalhistory.StudyTypesDetail
import medicalhistory.MeasurementUnit
import medicalhistory.Treatment
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

        // SystemUser
        def su1 = new SystemUser(username: 'lzacharewicz', password: '123456', firstName: 'Leonardo', lastName: 'Zacharewicz', status: 'Active', role:"admin", lastLogin: new Date()).save()
        def su2 = new SystemUser(username: 'mmaceiras', password: '123456', firstName: 'Mariano', lastName: 'Maceiras', status: 'Active', role:"admin", lastLogin: new Date()).save()
        def su3 = new SystemUser(username: 'rgirlando', password: '123456', firstName: 'Rodrigo', lastName: 'Girlando', status: 'Inactive',role:"admin",  lastLogin: new Date()).save()
        def su4 = new SystemUser(username: 'mfava', password: '123456', firstName: 'Martin', lastName: 'Fava', status: 'Active', role:"admin", lastLogin: new Date()).save()
        def su5 = new SystemUser(username: 'gheinrich', password: '123456', firstName: 'Gabriel', lastName: 'Heinrich', status: 'Active', role:"admin", lastLogin: new Date()).save()


		// FieldType
        def ft1 = new FieldType(fieldName:"Numerico").save()
        def ft2 = new FieldType(fieldName:"Alfanumerico").save()
        def ft3 = new FieldType(fieldName:"Si").save()
        def ft4 = new FieldType(fieldName:"No").save()

		// TreatmentFrequency
        def tf1 = new TreatmentFrequency(frequencyDescription:"Diario").save()
        def tf2 = new TreatmentFrequency(frequencyDescription:"Semanal").save()
		def tf3 = new TreatmentFrequency(frequencyDescription:"Quincenal").save()
		def tf4 = new TreatmentFrequency(frequencyDescription:"Mensual").save()
		def tf5 = new TreatmentFrequency(frequencyDescription:"Bimestral").save()

		// MainStudyType
        def mst1 = new MainStudyType(mainStudyType:"Htal", description:"Hospital").save()
        def mst2 = new MainStudyType(mainStudyType:"RCVC", description:"RCVC").save()
        def mst3 = new MainStudyType(mainStudyType:"DgHTA", description:"DgHTA").save()

		// Doctor
        def doc1 = new Doctor(medicalEnrollment:"e1", specialistType: "Ginecologo", firstName:"Gustavo", lastName:"Giunta").save()
        def doc2 = new Doctor(medicalEnrollment:"e1", specialistType: "Traumatologo", firstName:"Rene2", lastName:"Favaloro2").save()
        def doc3 = new Doctor(medicalEnrollment:"e1", specialistType: "Clinico", firstName:"Rene3", lastName:"Favaloro3").save()

        //MeasurementUnit
        def mu1 = new MeasurementUnit(descriptionUnit:"Centimetros cuadrados", unit:"cm2").save()
        def mu2 = new MeasurementUnit(descriptionUnit:"Centimetros cubico", unit:"cm3").save()
        def mu3 = new MeasurementUnit(descriptionUnit:"Decimetros cuadrados", unit:"dm2").save()
        def mu4 = new MeasurementUnit(descriptionUnit:"Decimetros cubico", unit:"dm3").save()


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

        def ant1 = new Antecedent(description:"Antecedente").save()
        def ant2 = new Antecedent(description:"FRC").save()

        def trt1 = new Treatment(description:"Tratamiento").save()

		// 	StudyTypesDetail de StudyTypes = "Laboratorio"

        def std1 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "HTO", description: "Hematocrito", completeName: "Hematocrito", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std2 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Hb", description: "Hemoglobina", completeName: "Hemoglobina", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std3 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Leucos", description: "Leucocitos", completeName: "Leucocitos", decimalsQuantity: 0, minRange: 0, maxRange: 20000, studyTypes: st1 ).save()
		def std4 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "PROMIELOCITOS", description: "Promielocitos", completeName: "Promielocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std5 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "MIELOCITOS", description: "Mielocitos", completeName: "Mielocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std6 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "METAMIELOCITOS", description: "Metamielocitos", completeName: "Metamielocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std7 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "CAYADO", description: "Cayado", completeName: "Cayado", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std8 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "SEGMENTADOS", description: "Segmentados", completeName: "Segmentados", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std9 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "EOSINOFILOS", description: "Eosinofilos", completeName: "Eosinofilos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std10 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "BASOFILOS", description: "Basofilos", completeName: "Basofilos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std11 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "LINFOCITOS", description: "Linfocitos", completeName: "Linfocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std12 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "MONOCITOS", description: "Monocitos", completeName: "Monocitos", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std13 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "ESD", description: "ESD", completeName: "ESD", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std14 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "TGO", description: "Transaminasa glutamico oxalacetica", completeName: "Transaminasa glutamico oxalacetica", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std15 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "TGP", description: "Transaminasa glutamico piruvica", completeName: "Transaminasa glutamico piruvica", decimalsQuantity: 2, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std16 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "FAL", description: "Fosfatasa alcalina", completeName: "Fosfatasa alcalina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std17 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Bil Tot", description: "Bilirrubuna total", completeName: "Bilirrubuna total", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std18 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Bil Dir", description: "Bilirrubuna directa", completeName: "Bilirrubuna directa", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st1 ).save()
		def std19 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Col Total", description: "Colesterol total", completeName: "Colesterol total", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std20 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Col HDL", description: "Colesterol HDL", completeName: "Colesterol HDL", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std21 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Col LDL", description: "Colesterol LDL", completeName: "Colesterol LDL", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std22 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Trigliceridos", description: "Trigliceridos", completeName: "Trigliceridos", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std23 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Ac Urico", description: "Acido urico", completeName: "Acido urico", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std24 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "MicroAlbuminuria", description: "Microalbuminuria", completeName: "Microalbuminuria", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std25 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "PCR ultra", description: "Reacción en cadena de la polimerasa", completeName: "Reacción en cadena de la polimerasa", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std26 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Glu basal", description: "Glucosa basal", completeName: "Glucosa basal", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std27 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Glu 120'", description: "Glucosa basal 120'", completeName: "Glucosa basal 120'", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std28 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "PTOG 120", description: "Prueba de tolerancia oral a la glucosa 120'", completeName: "Glucosa basal 120'", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std29 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Urea", description: "Urea", completeName: "Urea", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std30 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Sodio", description: "Sodio", completeName: "Sodio", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std32 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Potasio", description: "Potasio", completeName: "Potasio", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std33 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Creatinina", description: "Creatinina", completeName: "Creatinina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std34 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Cl Creat", description: "Clearence de creatinina", completeName: "Clearence de creatinina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std35 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Na urinario", description: "Sodio urinario", completeName: "Sodio urinario", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std36 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "K urinario", description: "Potasio urinario", completeName: "Potasio urinario", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std37 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Homocisteina", description: "Homocisteina", completeName: "Homocisteina", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()
		def std38 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Fibrinogeno", description: "Fibrinogeno", completeName: "Fibrinógeno", decimalsQuantity: 0, minRange: 0, maxRange: 1000, studyTypes: st1 ).save()

		// 	StudyTypesDetail de StudyTypes = "Sed Urinario"

		def std39 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft2, abbreviation: "Sed prot", description: "Sedimento - Proteina total", completeName: "Sedimento - Proteina total", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std40 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft2, abbreviation: "Sed Hb", description: "Sedimento - Hemoglobina", completeName: "Sedimento - Hemoglobina", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std41 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft2, abbreviation: "Sed Glu", description: "Sedimento - Glucosuria", completeName: "Sedimento - Glucosuria", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std42 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft2, abbreviation: "Sed hematies", description: "Sedimento - Hematies", completeName: "Sedimento - Hematiescosuria", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std43 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft2, abbreviation: "Sed Cilindros", description: "Sedimento - Cilindros", completeName: "Sedimento - Cilindroscosuria", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()

		// 	StudyTypesDetail de StudyTypes = "Lab HTA"

		def std44 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Adre u", description: "Adrenalina", completeName: "Adrenalina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std45 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Nora u", description: "Noradrenalina", completeName: "Noradrenalina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std46 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "T3", description: "Triyodotironina", completeName: "Triyodotironina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std47 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "T4", description: "Tiroxina", completeName: "Tiroxina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std48 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "TSH", description: "Hormona tiroestimulante", completeName: "Hormona tiroestimulante", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std49 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Renina pl", description: "Renina", completeName: "Renina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std50 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Aldos pl", description: "Aldosterona pl", completeName: "Aldosterona pl", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std51 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Aldos u", description: "Aldosterona u", completeName: "Aldosterona u", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std52 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "AVM", description: "Area valvular mitral", completeName: "Area valvular mitral", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std53 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Lpa", description: "Latido prematuro auricular", completeName: "Latido prematuro auricular", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std54 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Insulina basal", description: "Insulina basal", completeName: "Insulina basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std55 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "Insulina 120", description: "Insulina 120", completeName: "Insulina 120", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std56 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft3, abbreviation: "HbA1C", description: "Hemoglobina glicosilada", completeName: "Hemoglobina glicosilada", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()

		// 	StudyTypesDetail de StudyTypes = "Pletismografia"

		def std57 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "PA media", description: "PA media", completeName: "Pletismografia media", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std58 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Flujo basal", description: "Flujo basal", completeName: "Flujo basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std59 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Resist basal", description: "Resistencia basal", completeName: "Resistencia basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std60 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "PA postisq", description: "Pletismografia postisq", completeName: "Pletismografia postisq", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std61 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Flujo postisq", description: "Flujo postisq", completeName: "Flujo postisq", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std62 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Resistencia minima", description: "Resistencia minima", completeName: "Resistencia minima", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std63 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Compliance", description: "Compliance", completeName: "Compliance", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std64 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Distancia carotida/femoral", description: "Distancia carotida/femoral", completeName: "Distancia carotida/femoral", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std65 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "VOP", description: "Velocidad de onda de pulso", completeName: "Velocidad de onda de pulso", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()

		// 	StudyTypesDetail de StudyTypes = "PEG"

		def std66 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "FC_basal", description: "Frecuencia cardidaca basal", completeName: "Frecuencia cardiaca basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std67 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "TA_basal", description: "Tension arterial basal", completeName: "Tension arterial basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std68 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "FC_maxima", description: "Frecuencia cardiaca maxima", completeName: "Frecuencia cardiaca maxima", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std69 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "TA_maxima", description: "Tension arterial maxima", completeName: "Tension arterial maxima", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std70 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "METs", description: "Unidades de esfuerzo fisico", completeName: "Unidades de esfuerzo fisico", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std71 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Terminacion", description: "Terminacion", completeName: "Terminacion", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st5 ).save()
		def std72 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "resultado", description: "Resultado", completeName: "Resultado", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st5 ).save()
		def std73 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Riesgo isque", description: "Riesgo isquemico", completeName: "Riesgo isquemico", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st5 ).save()
		def std74 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Angina", description: "Angina", completeName: "Angina", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std75 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Disnea", description: "Disnea", completeName: "Disnea", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std76 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Sincope", description: "Sincope", completeName: "Sincope", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std77 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "TV", description: "Taquicardia ventricular", completeName: "Taquicardia ventricular", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std78 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Hipo TA", description: "Hipotension arterial", completeName: "Hipotension arterial", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std79 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "ST", description: "Secrecion tubular", completeName: "Secrecion tubular", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std80 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Equiv angin", description: "Equivalente angina", completeName: "Equivalente angina", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()

		// 	StudyTypesDetail de StudyTypes = "Camara Gamma"

		def std81 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Normal", description: "Normal", completeName: "Normal", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std82 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Apremio", description: "Apremio", completeName: "Apremio", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std83 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Anterior", description: "Anterior", completeName: "Anterior", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std84 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Inferior", description: "Inferior", completeName: "Inferior", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std85 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Lateral", description: "Lateral", completeName: "Lateral", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std86 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Posterior", description: "Posterior", completeName: "Posterior", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std87 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Captacion pulm", description: "Captacion pulmonar", completeName: "Captacion pulmonar", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st6 ).save()
		def std88 = new StudyTypesDetail(measurementUnit:mu1, fieldType: ft1, abbreviation: "Dil del VI", description: "Dilatacion del ventriculo izquierdo", completeName: "Dilatacion del ventriculo izquierdo", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st6 ).save()



		// 	TreatmentDetail
		def trtDet1 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"BETA  BLOQ",completeName:"Beta Bloqueadores", decimalsQuantity:0).save()
		def trtDet2 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"BLOQ CALCI",completeName:"Bloqueante Calcico", decimalsQuantity:0).save()
		def trtDet3 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"IECA",completeName:"Inhibidor del Enzima Conversor de la Angiotensina", decimalsQuantity:0).save()
		def trtDet4 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"INH  AT2",completeName:"Isoniacida", decimalsQuantity:0).save()
		def trtDet5 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"AAS",completeName:"Anabolizante Androgénico Esteroideo", decimalsQuantity:0).save()
		def trtDet6 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"CLOPI",completeName:"Clopidogrel", decimalsQuantity:0).save()
		def trtDet7 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"DIURET",completeName:"Diureticos",  decimalsQuantity:0).save()
		def trtDet8 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"ESTATINAS",completeName:"Estatinas", decimalsQuantity:0).save()
		def trtDet9 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"FIBRATOS",completeName:"Fibratos",  decimalsQuantity:0).save()
		def trtDet10 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"EZETIMIBE",completeName:"Ezetimibe ",  decimalsQuantity:0).save()
		def trtDet11 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"METFORMINA",completeName:"Metformina", decimalsQuantity:0).save()
		def trtDet12 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"SULFONILU",completeName:"Sulfonilureas", decimalsQuantity:0).save()
		def trtDet13 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"GLIATAZO",completeName:"Gliatazo",  decimalsQuantity:0).save()
		def trtDet14 = new TreatmentDetail(measurementUnit:mu1, treatment: trt1, fieldType: ft1, abbreviation:"OTROS",completeName:"Otros Tratamientos ", decimalsQuantity:0).save()

		//AntecedentDetail
		def antDet1 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant1, fieldType: ft1, abbreviation:"HTA",completeName:"Hipertension Arterial", decimalsQuantity:0).save()
		def antDet2 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant1, fieldType: ft1, abbreviation:"DLP",completeName:"Dislipemia", decimalsQuantity:0).save()
		def antDet3 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant1, fieldType: ft1, abbreviation:"TBQ",completeName:"Tabaquismo",  decimalsQuantity:0).save()
		def antDet4 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant1, fieldType: ft1, abbreviation:"EXTBQ",completeName:"Ex Tabaquismo",  decimalsQuantity:0).save()
		def antDet5 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"AHF",completeName:"Factor Anti-Hemofilico",  decimalsQuantity:0).save()
		def antDet6 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"DBT",completeName:"Diabetes", decimalsQuantity:0).save()
		def antDet7 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"IAM",completeName:"Infarto Agudo de Miocardio",decimalsQuantity:0).save()
		def antDet8 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"ACV/ TIA",completeName:"Accidente Cerebro Vascular / Accidente Isquémico Transitorio", decimalsQuantity:0).save()
		def antDet9 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"ENF CORONARIA",completeName:"Enfermedad Coronoaria", decimalsQuantity:0).save()
		def antDet10 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"EC",completeName:"Enfermedad Celiaca", decimalsQuantity:0).save()
		def antDet11 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"CRM",completeName:"Cirugia de Revascularización Miocardica",decimalsQuantity:0).save()
		def antDet12 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"ATC",completeName:"Angioplastia Transluminal Coronaria", decimalsQuantity:0).save()
		def antDet13 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"EVP",completeName:"Enfermedad Vascular Periferica", decimalsQuantity:0).save()
		def antDet14 = new AntecedentDetail(measurementUnit:mu1, antecedent: ant2, fieldType: ft1, abbreviation:"HIPO",completeName:"Hipotiroidismo", decimalsQuantity:0).save()

		//AgeRanges
        def ar1 = new AgeRanges(rangeDescription:"Menor de 18", minValue:1, maxValue:17).save()
        def ar2 = new AgeRanges(rangeDescription:"Entre 18 y 25", minValue:18, maxValue:25).save()
		def ar3 = new AgeRanges(rangeDescription:"Entre 26 y 35", minValue:26, maxValue:35).save()
		def ar4 = new AgeRanges(rangeDescription:"Entre 36 y 45", minValue:36, maxValue:45).save()
		def ar5 = new AgeRanges(rangeDescription:"Entre 46 y 55", minValue:46, maxValue:55).save()
		def ar6 = new AgeRanges(rangeDescription:"Entre 56 y 65", minValue:56, maxValue:65).save()
		def ar7 = new AgeRanges(rangeDescription:"Entre 66 y 75", minValue:66, maxValue:75).save()
		def ar8 = new AgeRanges(rangeDescription:"Mayor de 75", minValue:76, maxValue:120).save()


        def patient1 = new Patient(patientId: 1, height:1, weight:1, abdominalDiameter:1, medicalHistory:"1", firstName: "Ariel1", lastName: "Artega", birthDate: new Date(), sex: Patient.Sex.MASCULINO).save()
        def patient2 = new Patient(patientId: 2, height:2, weight:2, abdominalDiameter:2, medicalHistory:"2", firstName: "Briel2", lastName: "Brtega", birthDate: new Date(), sex: Patient.Sex.MASCULINO).save()
        def patient3 = new Patient(patientId: 3, height:3, weight:3, abdominalDiameter:3, medicalHistory:"3", firstName: "Criel3", lastName: "Crtega", birthDate: new Date(), sex: Patient.Sex.MASCULINO).save()
        def patient4 = new Patient(patientId: 4, height:4, weight:4, abdominalDiameter:4, medicalHistory:"4", firstName: "Driel4", lastName: "Drtega", birthDate: new Date(), sex: Patient.Sex.MASCULINO).save()
        def patient5 = new Patient(patientId: 5, height:5, weight:5, abdominalDiameter:5, medicalHistory:"5", firstName: "Eriel5", lastName: "Ertega", birthDate: new Date(), sex: Patient.Sex.FEMENINO).save()
        def patient6 = new Patient(patientId: 6, height:6, weight:6, abdominalDiameter:6, medicalHistory:"6", firstName: "Friel6", lastName: "Frtega", birthDate: new Date(), sex: Patient.Sex.FEMENINO).save()
        def patient7 = new Patient(patientId: 7, height:7, weight:7, abdominalDiameter:7, medicalHistory:"7", firstName: "Griel7", lastName: "Grtega", birthDate: new Date(), sex: Patient.Sex.FEMENINO).save()
        def patient8 = new Patient(patientId: 8, height:8, weight:8, abdominalDiameter:8, medicalHistory:"8", firstName: "Hriel8", lastName: "Hrtega", birthDate: new Date(), sex: Patient.Sex.FEMENINO).save()
        def patient9 = new Patient(patientId: 9, height:9, weight:9, abdominalDiameter:9, medicalHistory:"9", firstName: "Iriel9", lastName: "Irtega", birthDate: new Date(), sex: Patient.Sex.FEMENINO).save()
        def patient10 = new Patient(patientId: 10, height:10, weight:10, abdominalDiameter:10, medicalHistory:"10", firstName: "Jriel10", lastName: "Jrtega", birthDate: new Date(), sex: Patient.Sex.FEMENINO).save()

        def antecedent1 = new AntecedentValue(patient:patient1, antecedentDetail:antDet1, antecedentValue:1)
        def antecedent2 = new AntecedentValue(patient:patient1, antecedentDetail:antDet2, antecedentValue:2)
        def antecedent3 = new AntecedentValue(patient:patient2, antecedentDetail:antDet3, antecedentValue:3)
        def antecedent4 = new AntecedentValue(patient:patient2, antecedentDetail:antDet4, antecedentValue:4)
        def antecedent5 = new AntecedentValue(patient:patient3, antecedentDetail:antDet5, antecedentValue:5)
        antecedent1.save()
        antecedent2.save()
        antecedent3.save()
        antecedent4.save()
        antecedent5.save()

        def treatment1 = new TreatmentValue(patient:patient1, treatmentDetail:trtDet1, treatmentValue:2, frequency:tf1 ).save()
        def treatment12 = new TreatmentValue(patient:patient1, treatmentDetail:trtDet2, treatmentValue:2, frequency:tf2).save()
        def treatment13 = new TreatmentValue(patient:patient1, treatmentDetail:trtDet3, treatmentValue:2 , frequency:tf3).save()
        def treatment2 = new TreatmentValue(patient:patient2, treatmentDetail:trtDet4, treatmentValue:2 , frequency:tf4).save()
        def treatment21 = new TreatmentValue(patient:patient2, treatmentDetail:trtDet5, treatmentValue:2 , frequency:tf1).save()
        def treatment22 = new TreatmentValue(patient:patient2, treatmentDetail:trtDet6, treatmentValue:2, frequency:tf2).save()
        def treatment3 = new TreatmentValue(patient:patient3, treatmentDetail:trtDet7, treatmentValue:3 , frequency:tf3).save()
        def treatment31 = new TreatmentValue(patient:patient3, treatmentDetail:trtDet8, treatmentValue:3 , frequency:tf4).save()
        def treatment32 = new TreatmentValue(patient:patient3, treatmentDetail:trtDet9, treatmentValue:3 , frequency:tf5).save()

        def treatment4 = new TreatmentValue(patient:patient4, treatmentDetail:trtDet10, treatmentValue:4, frequency:tf1 ).save()
        def treatment41 = new TreatmentValue(patient:patient4, treatmentDetail:trtDet11, treatmentValue:4, frequency:tf2 ).save()
        def treatment42 = new TreatmentValue(patient:patient4, treatmentDetail:trtDet12, treatmentValue:4, frequency:tf3 ).save()

        def treatment5 = new TreatmentValue(patient:patient5, treatmentDetail:trtDet13, treatmentValue:5 , frequency:tf4).save()
        def treatment51 = new TreatmentValue(patient:patient5, treatmentDetail:trtDet14, treatmentValue:5 , frequency:tf5).save()
        def treatment52 = new TreatmentValue(patient:patient5, treatmentDetail:trtDet1, treatmentValue:5, frequency:tf1 ).save()



		def stv1 = new StudyTypesValues(studyTypesDetail:std1, studyTypeValue:1, patient:patient1)
		def stv2 = new StudyTypesValues(studyTypesDetail:std2, studyTypeValue:2, patient:patient1)
		def stv3 = new StudyTypesValues(studyTypesDetail:std3, studyTypeValue:3, patient:patient2)
		stv1.save()
		stv2.save()
		stv3.save()

		
		

    }

    def setTestData(){}

    def setProductionData(){}



}