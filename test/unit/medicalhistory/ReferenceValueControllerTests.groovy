package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(ReferenceValueController)
@Mock(ReferenceValue)
class ReferenceValueControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/referenceValue/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.referenceValueInstanceList.size() == 0
        assert model.referenceValueInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.referenceValueInstance != null
    }

    void testSave() {
        controller.save()

        assert model.referenceValueInstance != null
        assert view == '/referenceValue/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/referenceValue/show/1'
        assert controller.flash.message != null
        assert ReferenceValue.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/referenceValue/list'

        populateValidParams(params)
        def referenceValue = new ReferenceValue(params)

        assert referenceValue.save() != null

        params.id = referenceValue.id

        def model = controller.show()

        assert model.referenceValueInstance == referenceValue
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/referenceValue/list'

        populateValidParams(params)
        def referenceValue = new ReferenceValue(params)

        assert referenceValue.save() != null

        params.id = referenceValue.id

        def model = controller.edit()

        assert model.referenceValueInstance == referenceValue
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/referenceValue/list'

        response.reset()

        populateValidParams(params)
        def referenceValue = new ReferenceValue(params)

        assert referenceValue.save() != null

        // test invalid parameters in update
        params.id = referenceValue.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/referenceValue/edit"
        assert model.referenceValueInstance != null

        referenceValue.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/referenceValue/show/$referenceValue.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        referenceValue.clearErrors()

        populateValidParams(params)
        params.id = referenceValue.id
        params.version = -1
        controller.update()

        assert view == "/referenceValue/edit"
        assert model.referenceValueInstance != null
        assert model.referenceValueInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/referenceValue/list'

        response.reset()

        populateValidParams(params)
        def referenceValue = new ReferenceValue(params)

        assert referenceValue.save() != null
        assert ReferenceValue.count() == 1

        params.id = referenceValue.id

        controller.delete()

        assert ReferenceValue.count() == 0
        assert ReferenceValue.get(referenceValue.id) == null
        assert response.redirectedUrl == '/referenceValue/list'
    }
}
