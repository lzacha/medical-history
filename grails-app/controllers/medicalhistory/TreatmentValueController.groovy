package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class TreatmentValueController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [treatmentValueInstanceList: TreatmentValue.list(params), treatmentValueInstanceTotal: TreatmentValue.count()]
    }

    def create() {
        [treatmentValueInstance: new TreatmentValue(params)]
    }

    def save() {
        def treatmentValueInstance = new TreatmentValue(params)
        if (!treatmentValueInstance.save(flush: true)) {
            render(view: "create", model: [treatmentValueInstance: treatmentValueInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), treatmentValueInstance.id])
        redirect(action: "show", id: treatmentValueInstance.id)
    }

    def show(Long id) {
        def treatmentValueInstance = TreatmentValue.get(id)
        if (!treatmentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), id])
            redirect(action: "list")
            return
        }

        [treatmentValueInstance: treatmentValueInstance]
    }

    def edit(Long id) {
        def treatmentValueInstance = TreatmentValue.get(id)
        if (!treatmentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), id])
            redirect(action: "list")
            return
        }

        [treatmentValueInstance: treatmentValueInstance]
    }

    def update(Long id, Long version) {
        def treatmentValueInstance = TreatmentValue.get(id)
        if (!treatmentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (treatmentValueInstance.version > version) {
                treatmentValueInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'treatmentValue.label', default: 'TreatmentValue')] as Object[],
                          "Another user has updated this TreatmentValue while you were editing")
                render(view: "edit", model: [treatmentValueInstance: treatmentValueInstance])
                return
            }
        }

        treatmentValueInstance.properties = params

        if (!treatmentValueInstance.save(flush: true)) {
            render(view: "edit", model: [treatmentValueInstance: treatmentValueInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), treatmentValueInstance.id])
        redirect(action: "show", id: treatmentValueInstance.id)
    }

    def delete(Long id) {
        def treatmentValueInstance = TreatmentValue.get(id)
        if (!treatmentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), id])
            redirect(action: "list")
            return
        }

        try {
            treatmentValueInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'treatmentValue.label', default: 'TreatmentValue'), id])
            redirect(action: "show", id: id)
        }
    }
}
