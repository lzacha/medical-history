package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class PhiliatoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [philiatoryInstanceList: Philiatory.list(params), philiatoryInstanceTotal: Philiatory.count()]
    }

    def create() {
        [philiatoryInstance: new Philiatory(params)]
    }

    def save() {
        def philiatoryInstance = new Philiatory(params)
        if (!philiatoryInstance.save(flush: true)) {
            render(view: "create", model: [philiatoryInstance: philiatoryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), philiatoryInstance.id])
        redirect(action: "show", id: philiatoryInstance.id)
    }

    def show(Long id) {
        def philiatoryInstance = Philiatory.get(id)
        if (!philiatoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), id])
            redirect(action: "list")
            return
        }

        [philiatoryInstance: philiatoryInstance]
    }

    def edit(Long id) {
        def philiatoryInstance = Philiatory.get(id)
        if (!philiatoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), id])
            redirect(action: "list")
            return
        }

        [philiatoryInstance: philiatoryInstance]
    }

    def update(Long id, Long version) {
        def philiatoryInstance = Philiatory.get(id)
        if (!philiatoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (philiatoryInstance.version > version) {
                philiatoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'philiatory.label', default: 'Philiatory')] as Object[],
                          "Another user has updated this Philiatory while you were editing")
                render(view: "edit", model: [philiatoryInstance: philiatoryInstance])
                return
            }
        }

        philiatoryInstance.properties = params

        if (!philiatoryInstance.save(flush: true)) {
            render(view: "edit", model: [philiatoryInstance: philiatoryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), philiatoryInstance.id])
        redirect(action: "show", id: philiatoryInstance.id)
    }

    def delete(Long id) {
        def philiatoryInstance = Philiatory.get(id)
        if (!philiatoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), id])
            redirect(action: "list")
            return
        }

        try {
            philiatoryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'philiatory.label', default: 'Philiatory'), id])
            redirect(action: "show", id: id)
        }
    }
}
