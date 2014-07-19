package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class AntecedentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [antecedentInstanceList: Antecedent.list(params), antecedentInstanceTotal: Antecedent.count()]
    }

    def create() {
        [antecedentInstance: new Antecedent(params)]
    }

    def save() {
        def antecedentInstance = new Antecedent(params)
        if (!antecedentInstance.save(flush: true)) {
            render(view: "create", model: [antecedentInstance: antecedentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), antecedentInstance.id])
        redirect(action: "show", id: antecedentInstance.id)
    }

    def show(Long id) {
        def antecedentInstance = Antecedent.get(id)
        if (!antecedentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), id])
            redirect(action: "list")
            return
        }

        [antecedentInstance: antecedentInstance]
    }

    def edit(Long id) {
        def antecedentInstance = Antecedent.get(id)
        if (!antecedentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), id])
            redirect(action: "list")
            return
        }

        [antecedentInstance: antecedentInstance]
    }

    def update(Long id, Long version) {
        def antecedentInstance = Antecedent.get(id)
        if (!antecedentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (antecedentInstance.version > version) {
                antecedentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'antecedent.label', default: 'Antecedent')] as Object[],
                        "Another user has updated this Antecedent while you were editing")
                render(view: "edit", model: [antecedentInstance: antecedentInstance])
                return
            }
        }

        antecedentInstance.properties = params

        if (!antecedentInstance.save(flush: true)) {
            render(view: "edit", model: [antecedentInstance: antecedentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), antecedentInstance.id])
        redirect(action: "show", id: antecedentInstance.id)
    }

    def delete(Long id) {
        def antecedentInstance = Antecedent.get(id)
        if (!antecedentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), id])
            redirect(action: "list")
            return
        }

        try {
            antecedentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'antecedent.label', default: 'Antecedent'), id])
            redirect(action: "show", id: id)
        }
    }
}
