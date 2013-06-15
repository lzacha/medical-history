package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class MedicalStudyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [medicalStudyInstanceList: MedicalStudy.list(params), medicalStudyInstanceTotal: MedicalStudy.count()]
    }

    def create() {
        [medicalStudyInstance: new MedicalStudy(params)]
    }

    def save() {
        def medicalStudyInstance = new MedicalStudy(params)
        if (!medicalStudyInstance.save(flush: true)) {
            render(view: "create", model: [medicalStudyInstance: medicalStudyInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), medicalStudyInstance.id])
        redirect(action: "show", id: medicalStudyInstance.id)
    }

    def show(Long id) {
        def medicalStudyInstance = MedicalStudy.get(id)
        if (!medicalStudyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), id])
            redirect(action: "list")
            return
        }

        [medicalStudyInstance: medicalStudyInstance]
    }

    def edit(Long id) {
        def medicalStudyInstance = MedicalStudy.get(id)
        if (!medicalStudyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), id])
            redirect(action: "list")
            return
        }

        [medicalStudyInstance: medicalStudyInstance]
    }

    def update(Long id, Long version) {
        def medicalStudyInstance = MedicalStudy.get(id)
        if (!medicalStudyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (medicalStudyInstance.version > version) {
                medicalStudyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'medicalStudy.label', default: 'MedicalStudy')] as Object[],
                          "Another user has updated this MedicalStudy while you were editing")
                render(view: "edit", model: [medicalStudyInstance: medicalStudyInstance])
                return
            }
        }

        medicalStudyInstance.properties = params

        if (!medicalStudyInstance.save(flush: true)) {
            render(view: "edit", model: [medicalStudyInstance: medicalStudyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), medicalStudyInstance.id])
        redirect(action: "show", id: medicalStudyInstance.id)
    }

    def delete(Long id) {
        def medicalStudyInstance = MedicalStudy.get(id)
        if (!medicalStudyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), id])
            redirect(action: "list")
            return
        }

        try {
            medicalStudyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy'), id])
            redirect(action: "show", id: id)
        }
    }
}
