package medicalhistory

import grails.test.mixin.*

@TestFor(TreatmentController)
@Mock(TreatmentValue)
class TreatmentControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/treatment/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.treatmentInstanceList.size() == 0
        assert model.treatmentInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.treatmentInstance != null
    }

    void testSave() {
        controller.save()

        assert model.treatmentInstance != null
        assert view == '/treatment/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/treatment/show/1'
        assert controller.flash.message != null
        assert TreatmentValue.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/treatment/list'

        populateValidParams(params)
        def treatment = new TreatmentValue(params)

        assert treatment.save() != null

        params.id = treatment.id

        def model = controller.show()

        assert model.treatmentInstance == treatment
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/treatment/list'

        populateValidParams(params)
        def treatment = new TreatmentValue(params)

        assert treatment.save() != null

        params.id = treatment.id

        def model = controller.edit()

        assert model.treatmentInstance == treatment
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/treatment/list'

        response.reset()

        populateValidParams(params)
        def treatment = new TreatmentValue(params)

        assert treatment.save() != null

        // test invalid parameters in update
        params.id = treatment.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/treatment/edit"
        assert model.treatmentInstance != null

        treatment.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/treatment/show/$treatment.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        treatment.clearErrors()

        populateValidParams(params)
        params.id = treatment.id
        params.version = -1
        controller.update()

        assert view == "/treatment/edit"
        assert model.treatmentInstance != null
        assert model.treatmentInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/treatment/list'

        response.reset()

        populateValidParams(params)
        def treatment = new TreatmentValue(params)

        assert treatment.save() != null
        assert TreatmentValue.count() == 1

        params.id = treatment.id

        controller.delete()

        assert TreatmentValue.count() == 0
        assert TreatmentValue.get(treatment.id) == null
        assert response.redirectedUrl == '/treatment/list'
    }
}
