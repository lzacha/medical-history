package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class AntecedentValueController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [antecedentValueInstanceList: AntecedentValue.list(params), antecedentValueInstanceTotal: AntecedentValue.count()]
    }

    def create() {
        [antecedentValueInstance: new AntecedentValue(params)]
    }

    def save() {
        def antecedentValueInstance = new AntecedentValue(params)
        if (!antecedentValueInstance.save(flush: true)) {
            render(view: "create", model: [antecedentValueInstance: antecedentValueInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), antecedentValueInstance.id])
        redirect(action: "show", id: antecedentValueInstance.id)
    }

    def show(Long id) {
        def antecedentValueInstance = AntecedentValue.get(id)
        if (!antecedentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), id])
            redirect(action: "list")
            return
        }

        [antecedentValueInstance: antecedentValueInstance]
    }

    def edit(Long id) {
        def antecedentValueInstance = AntecedentValue.get(id)
        if (!antecedentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), id])
            redirect(action: "list")
            return
        }

        [antecedentValueInstance: antecedentValueInstance]
    }

    def update(Long id, Long version) {
        def antecedentValueInstance = AntecedentValue.get(id)
        if (!antecedentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (antecedentValueInstance.version > version) {
                antecedentValueInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'antecedentValue.label', default: 'AntecedentValue')] as Object[],
                          "Another user has updated this AntecedentValue while you were editing")
                render(view: "edit", model: [antecedentValueInstance: antecedentValueInstance])
                return
            }
        }

        antecedentValueInstance.properties = params

        if (!antecedentValueInstance.save(flush: true)) {
            render(view: "edit", model: [antecedentValueInstance: antecedentValueInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), antecedentValueInstance.id])
        redirect(action: "show", id: antecedentValueInstance.id)
    }

    def delete(Long id) {
        def antecedentValueInstance = AntecedentValue.get(id)
        if (!antecedentValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), id])
            redirect(action: "list")
            return
        }

        try {
            antecedentValueInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'antecedentValue.label', default: 'AntecedentValue'), id])
            redirect(action: "show", id: id)
        }
    }
}
