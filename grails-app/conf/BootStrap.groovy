import medicalhistory.SystemUser
import grails.util.Environment
import medicalhistory.Patient
import medicalhistory.Doctor
import medicalhistory.AntecedentDetail

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
        def su1 = new SystemUser(username: 'lzacharewicz', password: '123456', firstName: 'Leonardo', lastName: 'Zacharewicz', status: 'Active', lastLogin: new Date())
        def su2 = new SystemUser(username: 'mmaceiras', password: '123456', firstName: 'Mariano', lastName: 'Maceiras', status: 'Active', lastLogin: new Date())
        def su3 = new SystemUser(username: 'rgirlando', password: '123456', firstName: 'Rodrigo', lastName: 'Girlando', status: 'Inactive', lastLogin: new Date())
        def su4 = new SystemUser(username: 'mfava', password: '123456', firstName: 'Martin', lastName: 'Fava', status: 'Active', lastLogin: new Date())
        def su5 = new SystemUser(username: 'gheinrich', password: '123456', firstName: 'Gabriel', lastName: 'Heinrich', status: 'Active', lastLogin: new Date())
        su1.save()
        su2.save()
        su3.save()
        su4.save()
        su5.save()

        def antDet1 = new AntecedentDetail(antecedentDetailId: 1,internalCode: 'ENF CORONARIA', description: 'ENF CORONARIA')
        def antDet2 = new AntecedentDetail(antecedentDetailId: 2,internalCode: 'EC', description: 'EC')
        def antDet3 = new AntecedentDetail(antecedentDetailId: 3,internalCode: 'CRM', description: 'CRM')
        def antDet4 = new AntecedentDetail(antecedentDetailId: 4,internalCode: "ATC", description: "ATC")
        def antDet5 = new AntecedentDetail(antecedentDetailId: 5,internalCode: "ENF VASC PERIF", description: "ENF VASC PERIF") 
        def antDet6 = new AntecedentDetail(antecedentDetailId: 6,internalCode: "HIPOTIROIDISMO", description: "HIPOTIROIDISMO")
        def antDet7 = new AntecedentDetail(antecedentDetailId: 7,internalCode: "BETA  BLOQ", description: "BETA  BLOQ") 
        def antDet8 = new AntecedentDetail(antecedentDetailId: 8,internalCode: "BLOQ CALCI", description: "BLOQ CALCI")
        def antDet9 = new AntecedentDetail(antecedentDetailId: 9,internalCode: "IECA", description: "IECA")
        def antDet10 = new AntecedentDetail(antecedentDetailId: 10,internalCode: "INH  AT2", description: "INH  AT2")
        def antDet11 = new AntecedentDetail(antecedentDetailId: 11,internalCode: "AAS", description: "AAS")
        def antDet12 = new AntecedentDetail(antecedentDetailId: 12,internalCode: "CLOPI", description: "CLOPI")
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

        def patient1 = new Patient(patientId: 1,firstName: "Ariel", lastName: "Ortega", sexId: "Masculino", birthDate: new Date())
        def patient2 = new Patient(patientId: 2,firstName: "Diego", lastName: "Latorre", sexId: "Masculino", birthDate:new Date())
        def patient3 = new Patient(patientId: 3,firstName: "Carlos", lastName: "Tevez", sexId: "Masculino", birthDate:new Date())
        def patient4 = new Patient(patientId: 4,firstName: "Martin", lastName: "Palermo", sexId: "Masculino", birthDate:new Date())
        def patient5 = new Patient(patientId: 5,firstName: "Martin", lastName: "Zanetti", sexId: "Masculino", birthDate:new Date())
        def patient6 = new Patient(patientId: 6,firstName: "Martin", lastName: "Maradona", sexId: "Masculino", birthDate:new Date())
        def patient7 = new Patient(patientId: 7,firstName: "Jose", lastName: "Flores", sexId: "Masculino", birthDate:new Date())
        patient1.save()
        patient2.save()
        patient3.save()
        patient4.save()
        patient5.save()
        patient6.save()
        patient7.save()

        def doc1 = new Doctor(docId:1, medicalEnrollment:"e1", firstName:"Rene1", lastName:"Favaloro1")
        def doc2 = new Doctor(docId:2, medicalEnrollment:"e1", firstName:"Rene2", lastName:"Favaloro2")
        def doc3 = new Doctor(docId:3, medicalEnrollment:"e1", firstName:"Rene3", lastName:"Favaloro3")
        doc1.save()
        doc2.save()
        doc3.save()

    }

    def setTestData(){}

    def setProductionData(){}



}