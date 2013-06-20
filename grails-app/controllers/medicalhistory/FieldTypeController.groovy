package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class FieldTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [fieldTypeInstanceList: FieldType.list(params), fieldTypeInstanceTotal: FieldType.count()]
    }

    def create() {
        [fieldTypeInstance: new FieldType(params)]
    }

    def save() {
        def fieldTypeInstance = new FieldType(params)
        if (!fieldTypeInstance.save(flush: true)) {
            render(view: "create", model: [fieldTypeInstance: fieldTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'fieldType.label', default: 'FieldType'), fieldTypeInstance.id])
        redirect(action: "show", id: fieldTypeInstance.id)
    }

    def show(Long id) {
        def fieldTypeInstance = FieldType.get(id)
        if (!fieldTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fieldType.label', default: 'FieldType'), id])
            redirect(action: "list")
            return
        }

        [fieldTypeInstance: fieldTypeInstance]
    }

    def edit(Long id) {
        def fieldTypeInstance = FieldType.get(id)
        if (!fieldTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fieldType.label', default: 'FieldType'), id])
            redirect(action: "list")
            return
        }

        [fieldTypeInstance: fieldTypeInstance]
    }

    def update(Long id, Long version) {
        def fieldTypeInstance = FieldType.get(id)
        if (!fieldTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fieldType.label', default: 'FieldType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (fieldTypeInstance.version > version) {
                fieldTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'fieldType.label', default: 'FieldType')] as Object[],
                          "Another user has updated this FieldType while you were editing")
                render(view: "edit", model: [fieldTypeInstance: fieldTypeInstance])
                return
            }
        }

        fieldTypeInstance.properties = params

        if (!fieldTypeInstance.save(flush: true)) {
            render(view: "edit", model: [fieldTypeInstance: fieldTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'fieldType.label', default: 'FieldType'), fieldTypeInstance.id])
        redirect(action: "show", id: fieldTypeInstance.id)
    }

    def delete(Long id) {
        def fieldTypeInstance = FieldType.get(id)
        if (!fieldTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'fieldType.label', default: 'FieldType'), id])
            redirect(action: "list")
            return
        }

        try {
            fieldTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'fieldType.label', default: 'FieldType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'fieldType.label', default: 'FieldType'), id])
            redirect(action: "show", id: id)
        }
    }
}
