package medicalhistory

import org.springframework.dao.DataIntegrityViolationException

class PatientController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [patientInstanceList: Patient.list(params), patientInstanceTotal: Patient.count()]
    }

    def create() {
        [patientInstance: new Patient(params)]
    }

    def save() {
        def patientInstance = new Patient(params)
        if (!patientInstance.save(flush: true)) {
            render(view: "create", model: [patientInstance: patientInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'patient.label', default: 'Patient'), patientInstance.id])
        redirect(action: "show", id: patientInstance.id)
    }

    def show(Long id) {
        def patientInstance = Patient.get(id)
        if (!patientInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'patient.label', default: 'Patient'), id])
            redirect(action: "list")
            return
        }

        [patientInstance: patientInstance]
    }

    def edit(Long id) {
        def patientInstance = Patient.get(id)
        if (!patientInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'patient.label', default: 'Patient'), id])
            redirect(action: "list")
            return
        }

        [patientInstance: patientInstance]
    }

    def update(Long id, Long version) {
        def patientInstance = Patient.get(id)
        if (!patientInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'patient.label', default: 'Patient'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (patientInstance.version > version) {
                patientInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'patient.label', default: 'Patient')] as Object[],
                          "Another user has updated this Patient while you were editing")
                render(view: "edit", model: [patientInstance: patientInstance])
                return
            }
        }

        patientInstance.properties = params

        if (!patientInstance.save(flush: true)) {
            render(view: "edit", model: [patientInstance: patientInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'patient.label', default: 'Patient'), patientInstance.id])
        redirect(action: "show", id: patientInstance.id)
    }

    def delete(Long id) {
        def patientInstance = Patient.get(id)
        if (!patientInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'patient.label', default: 'Patient'), id])
            redirect(action: "list")
            return
        }

        try {
            patientInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'patient.label', default: 'Patient'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'patient.label', default: 'Patient'), id])
            redirect(action: "show", id: id)
        }
    }
}
