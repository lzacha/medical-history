package applications

import pl.touk.excel.export.WebXlsxExporter
import medicalhistory.Patient

class ExcelExportController {

    def index() { }

    def patients(Long max){
        params.max = Math.min(max ?: 10, 100)

        //Nombre columnas
		def headers = ['firstName', 'firstName']
        
		//Campos con datos
		def withProperties = ['firstName', 'firstName']

        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            add(Patient.list(params), withProperties)
            save(response.outputStream)
        }
    }


}
