package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class TreatmentFrequencyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [treatmentFrequencyInstanceList: TreatmentFrequency.list(params), treatmentFrequencyInstanceTotal: TreatmentFrequency.count()]
    }

    def create() {
        [treatmentFrequencyInstance: new TreatmentFrequency(params)]
    }

    def save() {
        def treatmentFrequencyInstance = new TreatmentFrequency(params)
        if (!treatmentFrequencyInstance.save(flush: true)) {
            render(view: "create", model: [treatmentFrequencyInstance: treatmentFrequencyInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), treatmentFrequencyInstance.id])
        redirect(action: "show", id: treatmentFrequencyInstance.id)
    }

    def show(Long id) {
        def treatmentFrequencyInstance = TreatmentFrequency.get(id)
        if (!treatmentFrequencyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), id])
            redirect(action: "list")
            return
        }

        [treatmentFrequencyInstance: treatmentFrequencyInstance]
    }

    def edit(Long id) {
        def treatmentFrequencyInstance = TreatmentFrequency.get(id)
        if (!treatmentFrequencyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), id])
            redirect(action: "list")
            return
        }

        [treatmentFrequencyInstance: treatmentFrequencyInstance]
    }

    def update(Long id, Long version) {
        def treatmentFrequencyInstance = TreatmentFrequency.get(id)
        if (!treatmentFrequencyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (treatmentFrequencyInstance.version > version) {
                treatmentFrequencyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency')] as Object[],
                          "Another user has updated this TreatmentFrequency while you were editing")
                render(view: "edit", model: [treatmentFrequencyInstance: treatmentFrequencyInstance])
                return
            }
        }

        treatmentFrequencyInstance.properties = params

        if (!treatmentFrequencyInstance.save(flush: true)) {
            render(view: "edit", model: [treatmentFrequencyInstance: treatmentFrequencyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), treatmentFrequencyInstance.id])
        redirect(action: "show", id: treatmentFrequencyInstance.id)
    }

    def delete(Long id) {
        def treatmentFrequencyInstance = TreatmentFrequency.get(id)
        if (!treatmentFrequencyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), id])
            redirect(action: "list")
            return
        }

        try {
            treatmentFrequencyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'treatmentFrequency.label', default: 'TreatmentFrequency'), id])
            redirect(action: "show", id: id)
        }
    }
}
