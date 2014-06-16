package medicalhistory

import medicalhistory.history.FileUploadService
import org.springframework.dao.DataIntegrityViolationException

class PlateController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	FileUploadService fileUploadService
	

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [plateInstanceList: Plate.list(params), plateInstanceTotal: Plate.count()]
    }

    def create() {
        [plateInstance: new Plate(params)]
    }

    def save() {
		
		//System.out.println "params --> " +params
		//System.out.println "request.getFileMap --> " +request.getFileNames().toString()

        def imagePlateFile = request.getFile('imagePlateFile')
		def imagePlate

		//println imagePlateFile.getFileItem().getName().toString()
        //plateInstance.getPatient().getId() + "-date-"+plateInstance.getPlateDate().fastTime

		if (!imagePlateFile.isEmpty()) {
			imagePlate = fileUploadService.uploadFile(imagePlateFile, 
					//plateInstance.getPatient().getId()
                    //+ "-date-"+plateInstance.getPlateDate().fastTime
					imagePlateFile.getFileItem().getName()
                    , "plateFiles")
		}
		
		params.imagePlate = imagePlate
		def plateInstance = new Plate(params)

		//System.out.println "params --> e" +params
        if (!plateInstance.save(flush: true)) {
			render(view: "create", model: [plateInstance: plateInstance])
            return
        }
		
        flash.message = message(code: 'default.created.message', args: [message(code: 'plate.label', default: 'Plate'), plateInstance.id])
        redirect(action: "show", id: plateInstance.id)
    }

    def show(Long id) {
        def plateInstance = Plate.get(id)
        if (!plateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plate.label', default: 'Plate'), id])
            redirect(action: "list")
            return
        }

        [plateInstance: plateInstance]
    }

    def edit(Long id) {
        def plateInstance = Plate.get(id)
        if (!plateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plate.label', default: 'Plate'), id])
            redirect(action: "list")
            return
        }

        [plateInstance: plateInstance]
    }

    def update(Long id, Long version) {
        def plateInstance = Plate.get(id)
        if (!plateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plate.label', default: 'Plate'), id])
            redirect(action: "list")
            return
        }
		
		def imagePlate = request.getFile('imagePlate')
		if (!imagePlate.isEmpty()) {
			plateInstance.imagePlate = fileUploadService.uploadFile(imagePlate, "${plateInstance.id}.png", "plateFiles")
		}

        if (version != null) {
            if (plateInstance.version > version) {
                plateInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'plate.label', default: 'Plate')] as Object[],
                          "Another user has updated this Plate while you were editing")
                render(view: "edit", model: [plateInstance: plateInstance])
                return
            }
        }

        plateInstance.properties = params

        if (!plateInstance.save(flush: true)) {
            render(view: "edit", model: [plateInstance: plateInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'plate.label', default: 'Plate'), plateInstance.id])
        redirect(action: "show", id: plateInstance.id)
    }

    def delete(Long id) {
        def plateInstance = Plate.get(id)
        if (!plateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'plate.label', default: 'Plate'), id])
            redirect(action: "list")
            return
        }

        try {
            plateInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'plate.label', default: 'Plate'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'plate.label', default: 'Plate'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def patient(Integer patient) {
		//params.max = Math.min(max ?: 10, 100)
		[plateInstanceList: Plate.findByPatient(patient), plateInstanceTotal: Plate.count()]
	}

}
