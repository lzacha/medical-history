import medicalhistory.SystemUser
import grails.util.Environment

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

    }

    def setTestData(){}

    def setProductionData(){}



}