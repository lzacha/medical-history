package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class AntecedentDetailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [antecedentDetailInstanceList: AntecedentDetail.list(params), antecedentDetailInstanceTotal: AntecedentDetail.count()]
    }

    def create() {
        [antecedentDetailInstance: new AntecedentDetail(params)]
    }

    def save() {
        def antecedentDetailInstance = new AntecedentDetail(params)
        if (!antecedentDetailInstance.save(flush: true)) {
            render(view: "create", model: [antecedentDetailInstance: antecedentDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), antecedentDetailInstance.id])
        redirect(action: "show", id: antecedentDetailInstance.id)
    }

    def show(Long id) {
        def antecedentDetailInstance = AntecedentDetail.get(id)
        if (!antecedentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), id])
            redirect(action: "list")
            return
        }

        [antecedentDetailInstance: antecedentDetailInstance]
    }

    def edit(Long id) {
        def antecedentDetailInstance = AntecedentDetail.get(id)
        if (!antecedentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), id])
            redirect(action: "list")
            return
        }

        [antecedentDetailInstance: antecedentDetailInstance]
    }

    def update(Long id, Long version) {
        def antecedentDetailInstance = AntecedentDetail.get(id)
        if (!antecedentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (antecedentDetailInstance.version > version) {
                antecedentDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'antecedentDetail.label', default: 'AntecedentDetail')] as Object[],
                          "Another user has updated this AntecedentDetail while you were editing")
                render(view: "edit", model: [antecedentDetailInstance: antecedentDetailInstance])
                return
            }
        }

        antecedentDetailInstance.properties = params

        if (!antecedentDetailInstance.save(flush: true)) {
            render(view: "edit", model: [antecedentDetailInstance: antecedentDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), antecedentDetailInstance.id])
        redirect(action: "show", id: antecedentDetailInstance.id)
    }

    def delete(Long id) {
        def antecedentDetailInstance = AntecedentDetail.get(id)
        if (!antecedentDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            antecedentDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'antecedentDetail.label', default: 'AntecedentDetail'), id])
            redirect(action: "show", id: id)
        }
    }
}
