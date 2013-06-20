package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(FieldTypeController)
@Mock(FieldType)
class FieldTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/fieldType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.fieldTypeInstanceList.size() == 0
        assert model.fieldTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.fieldTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.fieldTypeInstance != null
        assert view == '/fieldType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/fieldType/show/1'
        assert controller.flash.message != null
        assert FieldType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/fieldType/list'

        populateValidParams(params)
        def fieldType = new FieldType(params)

        assert fieldType.save() != null

        params.id = fieldType.id

        def model = controller.show()

        assert model.fieldTypeInstance == fieldType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/fieldType/list'

        populateValidParams(params)
        def fieldType = new FieldType(params)

        assert fieldType.save() != null

        params.id = fieldType.id

        def model = controller.edit()

        assert model.fieldTypeInstance == fieldType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/fieldType/list'

        response.reset()

        populateValidParams(params)
        def fieldType = new FieldType(params)

        assert fieldType.save() != null

        // test invalid parameters in update
        params.id = fieldType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/fieldType/edit"
        assert model.fieldTypeInstance != null

        fieldType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/fieldType/show/$fieldType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        fieldType.clearErrors()

        populateValidParams(params)
        params.id = fieldType.id
        params.version = -1
        controller.update()

        assert view == "/fieldType/edit"
        assert model.fieldTypeInstance != null
        assert model.fieldTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/fieldType/list'

        response.reset()

        populateValidParams(params)
        def fieldType = new FieldType(params)

        assert fieldType.save() != null
        assert FieldType.count() == 1

        params.id = fieldType.id

        controller.delete()

        assert FieldType.count() == 0
        assert FieldType.get(fieldType.id) == null
        assert response.redirectedUrl == '/fieldType/list'
    }
}
