package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(PatientController)
@Mock(Patient)
class PatientControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/patient/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.patientInstanceList.size() == 0
        assert model.patientInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.patientInstance != null
    }

    void testSave() {
        controller.save()

        assert model.patientInstance != null
        assert view == '/patient/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/patient/show/1'
        assert controller.flash.message != null
        assert Patient.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/patient/list'

        populateValidParams(params)
        def patient = new Patient(params)

        assert patient.save() != null

        params.id = patient.id

        def model = controller.show()

        assert model.patientInstance == patient
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/patient/list'

        populateValidParams(params)
        def patient = new Patient(params)

        assert patient.save() != null

        params.id = patient.id

        def model = controller.edit()

        assert model.patientInstance == patient
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/patient/list'

        response.reset()

        populateValidParams(params)
        def patient = new Patient(params)

        assert patient.save() != null

        // test invalid parameters in update
        params.id = patient.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/patient/edit"
        assert model.patientInstance != null

        patient.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/patient/show/$patient.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        patient.clearErrors()

        populateValidParams(params)
        params.id = patient.id
        params.version = -1
        controller.update()

        assert view == "/patient/edit"
        assert model.patientInstance != null
        assert model.patientInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/patient/list'

        response.reset()

        populateValidParams(params)
        def patient = new Patient(params)

        assert patient.save() != null
        assert Patient.count() == 1

        params.id = patient.id

        controller.delete()

        assert Patient.count() == 0
        assert Patient.get(patient.id) == null
        assert response.redirectedUrl == '/patient/list'
    }
}
