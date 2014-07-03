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
        def doc1 = new Doctor(docId:1, medicalEnrollment:"e1", firstName:"Gustavo", lastName:"Giunta").save()
        def doc2 = new Doctor(docId:2, medicalEnrollment:"e1", firstName:"Rene2", lastName:"Favaloro2").save()
        def doc3 = new Doctor(docId:3, medicalEnrollment:"e1", firstName:"Rene3", lastName:"Favaloro3").save()
        
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
		
		// 	StudyTypesDetails de StudyTypes = "Sed Urinario"
		
		def std39 = new StudyTypesDetails(abbreviation: "Sed prot", description: "Sedimento - Proteina total", completeName: "Sedimento - Proteina total", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std40 = new StudyTypesDetails(abbreviation: "Sed Hb", description: "Sedimento - Hemoglobina", completeName: "Sedimento - Hemoglobina", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std41 = new StudyTypesDetails(abbreviation: "Sed Glu", description: "Sedimento - Glucosuria", completeName: "Sedimento - Glucosuria", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std42 = new StudyTypesDetails(abbreviation: "Sed hematies", description: "Sedimento - Hematies", completeName: "Sedimento - Hematiescosuria", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()
		def std43 = new StudyTypesDetails(abbreviation: "Sed Cilindros", description: "Sedimento - Cilindros", completeName: "Sedimento - Cilindroscosuria", decimalsQuantity: 0, minRange: 0, maxRange: 100, studyTypes: st2 ).save()

		// 	StudyTypesDetails de StudyTypes = "Lab HTA"
		
		def std44 = new StudyTypesDetails(abbreviation: "Adre u", description: "Adrenalina", completeName: "Adrenalina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std45 = new StudyTypesDetails(abbreviation: "Nora u", description: "Noradrenalina", completeName: "Noradrenalina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std46 = new StudyTypesDetails(abbreviation: "T3", description: "Triyodotironina", completeName: "Triyodotironina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std47 = new StudyTypesDetails(abbreviation: "T4", description: "Tiroxina", completeName: "Tiroxina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std48 = new StudyTypesDetails(abbreviation: "TSH", description: "Hormona tiroestimulante", completeName: "Hormona tiroestimulante", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std49 = new StudyTypesDetails(abbreviation: "Renina pl", description: "Renina", completeName: "Renina", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std50 = new StudyTypesDetails(abbreviation: "Aldos pl", description: "Aldosterona pl", completeName: "Aldosterona pl", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std51 = new StudyTypesDetails(abbreviation: "Aldos u", description: "Aldosterona u", completeName: "Aldosterona u", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std52 = new StudyTypesDetails(abbreviation: "AVM", description: "Area valvular mitral", completeName: "Area valvular mitral", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std53 = new StudyTypesDetails(abbreviation: "Lpa", description: "Latido prematuro auricular", completeName: "Latido prematuro auricular", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std54 = new StudyTypesDetails(abbreviation: "Insulina basal", description: "Insulina basal", completeName: "Insulina basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std55 = new StudyTypesDetails(abbreviation: "Insulina 120", description: "Insulina 120", completeName: "Insulina 120", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std56 = new StudyTypesDetails(abbreviation: "HbA1C", description: "Hemoglobina glicosilada", completeName: "Hemoglobina glicosilada", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()

		// 	StudyTypesDetails de StudyTypes = "Pletismografia"
		
		def std57 = new StudyTypesDetails(abbreviation: "PA media", description: "PA media", completeName: "Pletismografia media", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std58 = new StudyTypesDetails(abbreviation: "Flujo basal", description: "Flujo basal", completeName: "Flujo basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std59 = new StudyTypesDetails(abbreviation: "Resist basal", description: "Resistencia basal", completeName: "Resistencia basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std60 = new StudyTypesDetails(abbreviation: "PA postisq", description: "Pletismografia postisq", completeName: "Pletismografia postisq", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std61 = new StudyTypesDetails(abbreviation: "Flujo postisq", description: "Flujo postisq", completeName: "Flujo postisq", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std62 = new StudyTypesDetails(abbreviation: "Resistencia minima", description: "Resistencia minima", completeName: "Resistencia minima", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std63 = new StudyTypesDetails(abbreviation: "Compliance", description: "Compliance", completeName: "Compliance", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std64 = new StudyTypesDetails(abbreviation: "Distancia carotida/femoral", description: "Distancia carotida/femoral", completeName: "Distancia carotida/femoral", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()
		def std65 = new StudyTypesDetails(abbreviation: "VOP", description: "Velocidad de onda de pulso", completeName: "Velocidad de onda de pulso", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st3 ).save()

		// 	StudyTypesDetails de StudyTypes = "PEG"
		
		def std66 = new StudyTypesDetails(abbreviation: "FC basal", description: "Frecuencia cardidaca basal", completeName: "Frecuencia cardiaca basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std67 = new StudyTypesDetails(abbreviation: "TA basal", description: "Tension arterial basal", completeName: "Tension arterial basal", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std68 = new StudyTypesDetails(abbreviation: "FC maxima", description: "Frecuencia cardiaca maxima", completeName: "Frecuencia cardiaca maxima", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std69 = new StudyTypesDetails(abbreviation: "TA maxima", description: "Tension arterial maxima", completeName: "Tension arterial maxima", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std70 = new StudyTypesDetails(abbreviation: "METs", description: "Unidades de esfuerzo fisico", completeName: "Unidades de esfuerzo fisico", decimalsQuantity: 2, minRange: 0, maxRange: 1000, studyTypes: st5 ).save()
		def std71 = new StudyTypesDetails(abbreviation: "Terminacion", description: "Terminacion", completeName: "Terminacion", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st5 ).save()
		def std72 = new StudyTypesDetails(abbreviation: "resultado", description: "Resultado", completeName: "Resultado", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st5 ).save()
		def std73 = new StudyTypesDetails(abbreviation: "Riesgo isque", description: "Riesgo isquemico", completeName: "Riesgo isquemico", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st5 ).save()
		def std74 = new StudyTypesDetails(abbreviation: "Angina", description: "Angina", completeName: "Angina", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std75 = new StudyTypesDetails(abbreviation: "Disnea", description: "Disnea", completeName: "Disnea", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std76 = new StudyTypesDetails(abbreviation: "Sincope", description: "Sincope", completeName: "Sincope", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std77 = new StudyTypesDetails(abbreviation: "TV", description: "Taquicardia ventricular", completeName: "Taquicardia ventricular", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std78 = new StudyTypesDetails(abbreviation: "Hipo TA", description: "Hipotension arterial", completeName: "Hipotension arterial", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std79 = new StudyTypesDetails(abbreviation: "ST", description: "Secrecion tubular", completeName: "Secrecion tubular", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		def std80 = new StudyTypesDetails(abbreviation: "Equiv angin", description: "Equivalente angina", completeName: "Equivalente angina", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st5 ).save()
		
		// 	StudyTypesDetails de StudyTypes = "Camara Gamma"
		
		def std81 = new StudyTypesDetails(abbreviation: "Normal", description: "Normal", completeName: "Normal", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std82 = new StudyTypesDetails(abbreviation: "Apremio", description: "Apremio", completeName: "Apremio", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std83 = new StudyTypesDetails(abbreviation: "Anterior", description: "Anterior", completeName: "Anterior", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std84 = new StudyTypesDetails(abbreviation: "Inferior", description: "Inferior", completeName: "Inferior", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std85 = new StudyTypesDetails(abbreviation: "Lateral", description: "Lateral", completeName: "Lateral", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std86 = new StudyTypesDetails(abbreviation: "Posterior", description: "Posterior", completeName: "Posterior", decimalsQuantity: 0, minRange: 0, maxRange: 0, studyTypes: st6 ).save()
		def std87 = new StudyTypesDetails(abbreviation: "Captacion pulm", description: "Captacion pulmonar", completeName: "Captacion pulmonar", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st6 ).save()
		def std88 = new StudyTypesDetails(abbreviation: "Dil del VI", description: "Dilatacion del ventriculo izquierdo", completeName: "Dilatacion del ventriculo izquierdo", decimalsQuantity: 0, minRange: 0, maxRange: 1, studyTypes: st6 ).save()
		
		

		// 	TreatmentDetail
		def trtDet1 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"BETA  BLOQ",completeName:"Beta Bloqueadores", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet2 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"BLOQ CALCI",completeName:"Bloqueante Calcico", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet3 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"IECA",completeName:"Inhibidor del Enzima Conversor de la Angiotensina", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet4 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"INH  AT2",completeName:"Isoniacida", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet5 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"AAS",completeName:"Anabolizante Androgénico Esteroideo", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet6 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"CLOPI",completeName:"Clopidogrel", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet7 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"DIURET",completeName:"Diureticos", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet8 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"ESTATINAS",completeName:"Estatinas", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet9 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"FIBRATOS",completeName:"Fibratos", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet10 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"EZETIMIBE",completeName:"Ezetimibe ", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet11 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"METFORMINA",completeName:"Metformina", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet12 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"SULFONILU",completeName:"Sulfonilureas", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet13 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"GLIATAZO",completeName:"Gliatazo", fieldType:ft2, decimalsQuantity:0).save()
		def trtDet14 = new TreatmentDetail(treatmentType: TreatmentDetail.TreatmentType.TREATMENT, abbreviation:"OTROS",completeName:"Otros Tratamientos ", fieldType:ft2, decimalsQuantity:0).save()

		//AntecedentDetail
		def antDet1 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"HTA",completeName:"Hipertension Arterial", fieldType:ft1, decimalsQuantity:0).save()
		def antDet2 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"DLP",completeName:"Dislipemia", fieldType:ft2, decimalsQuantity:0).save()
		def antDet3 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"TBQ",completeName:"Tabaquismo", fieldType:ft3, decimalsQuantity:0).save()
		def antDet4 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.FRC, abbreviation:"EXTBQ",completeName:"Ex Tabaquismo", fieldType:ft4, decimalsQuantity:0).save()
		def antDet5 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"AHF",completeName:"Factor Anti-Hemofilico", fieldType:ft1, decimalsQuantity:0).save()
		def antDet6 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"DBT",completeName:"Diabetes", fieldType:ft2, decimalsQuantity:0).save()
		def antDet7 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"IAM",completeName:"Infarto Agudo de Miocardio", fieldType:ft1, decimalsQuantity:0).save()
		def antDet8 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"ACV/ TIA",completeName:"Accidente Cerebro Vascular / Accidente Isquémico Transitorio", fieldType:ft2, decimalsQuantity:0).save()
		def antDet9 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"ENF CORONARIA",completeName:"Enfermedad Coronoaria", fieldType:ft3, decimalsQuantity:0).save()
		def antDet10 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"EC",completeName:"Enfermedad Celiaca", fieldType:ft4, decimalsQuantity:0).save()
		def antDet11 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"CRM",completeName:"Cirugia de Revascularización Miocardica", fieldType:ft1, decimalsQuantity:0).save()
		def antDet12 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"ATC",completeName:"Angioplastia Transluminal Coronaria", fieldType:ft2, decimalsQuantity:0).save()
		def antDet13 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"EVP",completeName:"Enfermedad Vascular Periferica", fieldType:ft2, decimalsQuantity:0).save()
		def antDet14 = new AntecedentDetail(antecedentStudyType: AntecedentDetail.AntecedentStudyType.ANT, abbreviation:"HIPO",completeName:"Hipotiroidismo", fieldType:ft2, decimalsQuantity:0).save()

		//AgeRanges
        def ar1 = new AgeRanges(rangeDescription:"Menor de 18", minValue:1, maxValue:17).save()
        def ar2 = new AgeRanges(rangeDescription:"Entre 18 y 25", minValue:18, maxValue:25).save()
		def ar3 = new AgeRanges(rangeDescription:"Entre 26 y 35", minValue:26, maxValue:35).save()
		def ar4 = new AgeRanges(rangeDescription:"Entre 36 y 45", minValue:36, maxValue:45).save()
		def ar5 = new AgeRanges(rangeDescription:"Entre 46 y 55", minValue:46, maxValue:55).save()
		def ar6 = new AgeRanges(rangeDescription:"Entre 56 y 65", minValue:56, maxValue:65).save()
		def ar7 = new AgeRanges(rangeDescription:"Entre 66 y 75", minValue:66, maxValue:75).save()
		def ar8 = new AgeRanges(rangeDescription:"Mayor de 75", minValue:76, maxValue:120).save()
        

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
		
		
		
		//def mu1 = new MeasurementUnit(descriptionUnit:"Centimetros cuadrados", unit:"cm2")
		 //def mu2 = new MeasurementUnit(descriptionUnit:"Centimetros cubico", unit:"cm3")
		 //mu1.save()
		 //mu2.save()
 

    }

    def setTestData(){}

    def setProductionData(){}



}