package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class MedicalStudyDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [medicalStudyDetailInstanceList: MedicalStudyDetail.list(params), medicalStudyDetailInstanceTotal: MedicalStudyDetail.count()]
    }

    def create() {
        [medicalStudyDetailInstance: new MedicalStudyDetail(params)]
    }

    def save() {
        def medicalStudyDetailInstance = new MedicalStudyDetail(params)
        if (!medicalStudyDetailInstance.save(flush: true)) {
            render(view: "create", model: [medicalStudyDetailInstance: medicalStudyDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), medicalStudyDetailInstance.id])
        redirect(action: "show", id: medicalStudyDetailInstance.id)
    }

    def show(Long id) {
        def medicalStudyDetailInstance = MedicalStudyDetail.get(id)
        if (!medicalStudyDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), id])
            redirect(action: "list")
            return
        }

        [medicalStudyDetailInstance: medicalStudyDetailInstance]
    }

    def edit(Long id) {
        def medicalStudyDetailInstance = MedicalStudyDetail.get(id)
        if (!medicalStudyDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), id])
            redirect(action: "list")
            return
        }

        [medicalStudyDetailInstance: medicalStudyDetailInstance]
    }

    def update(Long id, Long version) {
        def medicalStudyDetailInstance = MedicalStudyDetail.get(id)
        if (!medicalStudyDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (medicalStudyDetailInstance.version > version) {
                medicalStudyDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail')] as Object[],
                          "Another user has updated this MedicalStudyDetail while you were editing")
                render(view: "edit", model: [medicalStudyDetailInstance: medicalStudyDetailInstance])
                return
            }
        }

        medicalStudyDetailInstance.properties = params

        if (!medicalStudyDetailInstance.save(flush: true)) {
            render(view: "edit", model: [medicalStudyDetailInstance: medicalStudyDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), medicalStudyDetailInstance.id])
        redirect(action: "show", id: medicalStudyDetailInstance.id)
    }

    def delete(Long id) {
        def medicalStudyDetailInstance = MedicalStudyDetail.get(id)
        if (!medicalStudyDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            medicalStudyDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail'), id])
            redirect(action: "show", id: id)
        }
    }
}
