package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class SystemUserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [systemUserInstanceList: SystemUser.list(params), systemUserInstanceTotal: SystemUser.count()]
    }

    def create() {
        [systemUserInstance: new SystemUser(params)]
    }

    def save() {
        def systemUserInstance = new SystemUser(params)
        if (!systemUserInstance.save(flush: true)) {
            render(view: "create", model: [systemUserInstance: systemUserInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), systemUserInstance.id])
        redirect(action: "show", id: systemUserInstance.id)
    }

    def show(Long id) {
        def systemUserInstance = SystemUser.get(id)
        if (!systemUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), id])
            redirect(action: "list")
            return
        }

        [systemUserInstance: systemUserInstance]
    }

    def edit(Long id) {
        def systemUserInstance = SystemUser.get(id)
        if (!systemUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), id])
            redirect(action: "list")
            return
        }

        [systemUserInstance: systemUserInstance]
    }

    def update(Long id, Long version) {
        def systemUserInstance = SystemUser.get(id)
        if (!systemUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (systemUserInstance.version > version) {
                systemUserInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'systemUser.label', default: 'SystemUser')] as Object[],
                          "Another user has updated this SystemUser while you were editing")
                render(view: "edit", model: [systemUserInstance: systemUserInstance])
                return
            }
        }

        systemUserInstance.properties = params

        if (!systemUserInstance.save(flush: true)) {
            render(view: "edit", model: [systemUserInstance: systemUserInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), systemUserInstance.id])
        redirect(action: "show", id: systemUserInstance.id)
    }

    def delete(Long id) {
        def systemUserInstance = SystemUser.get(id)
        if (!systemUserInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), id])
            redirect(action: "list")
            return
        }

        try {
            systemUserInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'systemUser.label', default: 'SystemUser'), id])
            redirect(action: "show", id: id)
        }
    }
}
