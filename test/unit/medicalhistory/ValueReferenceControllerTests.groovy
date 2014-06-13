package medicalhistory

import grails.test.mixin.*


@Mock(ReferenceValue)
class ValueReferenceControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/valueReference/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.valueReferenceInstanceList.size() == 0
        assert model.valueReferenceInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.valueReferenceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.valueReferenceInstance != null
        assert view == '/valueReference/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/valueReference/show/1'
        assert controller.flash.message != null
        assert ReferenceValue.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/valueReference/list'

        populateValidParams(params)
        def valueReference = new ReferenceValue(params)

        assert valueReference.save() != null

        params.id = valueReference.id

        def model = controller.show()

        assert model.valueReferenceInstance == valueReference
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/valueReference/list'

        populateValidParams(params)
        def valueReference = new ReferenceValue(params)

        assert valueReference.save() != null

        params.id = valueReference.id

        def model = controller.edit()

        assert model.valueReferenceInstance == valueReference
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/valueReference/list'

        response.reset()

        populateValidParams(params)
        def valueReference = new ReferenceValue(params)

        assert valueReference.save() != null

        // test invalid parameters in update
        params.id = valueReference.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/valueReference/edit"
        assert model.valueReferenceInstance != null

        valueReference.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/valueReference/show/$valueReference.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        valueReference.clearErrors()

        populateValidParams(params)
        params.id = valueReference.id
        params.version = -1
        controller.update()

        assert view == "/valueReference/edit"
        assert model.valueReferenceInstance != null
        assert model.valueReferenceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/valueReference/list'

        response.reset()

        populateValidParams(params)
        def valueReference = new ReferenceValue(params)

        assert valueReference.save() != null
        assert ReferenceValue.count() == 1

        params.id = valueReference.id

        controller.delete()

        assert ReferenceValue.count() == 0
        assert ReferenceValue.get(valueReference.id) == null
        assert response.redirectedUrl == '/valueReference/list'
    }
}
