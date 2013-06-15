package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class TreatmentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [treatmentInstanceList: Treatment.list(params), treatmentInstanceTotal: Treatment.count()]
    }

    def create() {
        [treatmentInstance: new Treatment(params)]
    }

    def save() {
        def treatmentInstance = new Treatment(params)
        if (!treatmentInstance.save(flush: true)) {
            render(view: "create", model: [treatmentInstance: treatmentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'treatment.label', default: 'Treatment'), treatmentInstance.id])
        redirect(action: "show", id: treatmentInstance.id)
    }

    def show(Long id) {
        def treatmentInstance = Treatment.get(id)
        if (!treatmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatment.label', default: 'Treatment'), id])
            redirect(action: "list")
            return
        }

        [treatmentInstance: treatmentInstance]
    }

    def edit(Long id) {
        def treatmentInstance = Treatment.get(id)
        if (!treatmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatment.label', default: 'Treatment'), id])
            redirect(action: "list")
            return
        }

        [treatmentInstance: treatmentInstance]
    }

    def update(Long id, Long version) {
        def treatmentInstance = Treatment.get(id)
        if (!treatmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatment.label', default: 'Treatment'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (treatmentInstance.version > version) {
                treatmentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'treatment.label', default: 'Treatment')] as Object[],
                          "Another user has updated this Treatment while you were editing")
                render(view: "edit", model: [treatmentInstance: treatmentInstance])
                return
            }
        }

        treatmentInstance.properties = params

        if (!treatmentInstance.save(flush: true)) {
            render(view: "edit", model: [treatmentInstance: treatmentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'treatment.label', default: 'Treatment'), treatmentInstance.id])
        redirect(action: "show", id: treatmentInstance.id)
    }

    def delete(Long id) {
        def treatmentInstance = Treatment.get(id)
        if (!treatmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatment.label', default: 'Treatment'), id])
            redirect(action: "list")
            return
        }

        try {
            treatmentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'treatment.label', default: 'Treatment'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'treatment.label', default: 'Treatment'), id])
            redirect(action: "show", id: id)
        }
    }
}
