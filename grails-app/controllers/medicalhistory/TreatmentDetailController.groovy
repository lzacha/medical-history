package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class TreatmentDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [treatmentDetailInstanceList: TreatmentDetail.list(params), treatmentDetailInstanceTotal: TreatmentDetail.count()]
    }

    def create() {
        [treatmentDetailInstance: new TreatmentDetail(params)]
    }

    def save() {
        def treatmentDetailInstance = new TreatmentDetail(params)
        if (!treatmentDetailInstance.save(flush: true)) {
            render(view: "create", model: [treatmentDetailInstance: treatmentDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), treatmentDetailInstance.id])
        redirect(action: "show", id: treatmentDetailInstance.id)
    }

    def show(Long id) {
        def treatmentDetailInstance = TreatmentDetail.get(id)
        if (!treatmentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), id])
            redirect(action: "list")
            return
        }

        [treatmentDetailInstance: treatmentDetailInstance]
    }

    def edit(Long id) {
        def treatmentDetailInstance = TreatmentDetail.get(id)
        if (!treatmentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), id])
            redirect(action: "list")
            return
        }

        [treatmentDetailInstance: treatmentDetailInstance]
    }

    def update(Long id, Long version) {
        def treatmentDetailInstance = TreatmentDetail.get(id)
        if (!treatmentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (treatmentDetailInstance.version > version) {
                treatmentDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'treatmentDetail.label', default: 'TreatmentDetail')] as Object[],
                          "Another user has updated this TreatmentDetail while you were editing")
                render(view: "edit", model: [treatmentDetailInstance: treatmentDetailInstance])
                return
            }
        }

        treatmentDetailInstance.properties = params

        if (!treatmentDetailInstance.save(flush: true)) {
            render(view: "edit", model: [treatmentDetailInstance: treatmentDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), treatmentDetailInstance.id])
        redirect(action: "show", id: treatmentDetailInstance.id)
    }

    def delete(Long id) {
        def treatmentDetailInstance = TreatmentDetail.get(id)
        if (!treatmentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            treatmentDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'treatmentDetail.label', default: 'TreatmentDetail'), id])
            redirect(action: "show", id: id)
        }
    }
}
