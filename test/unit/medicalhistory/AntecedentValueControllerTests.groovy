package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(AntecedentValueController)
@Mock(AntecedentValue)
class AntecedentValueControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/antecedentValue/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.antecedentValueInstanceList.size() == 0
        assert model.antecedentValueInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.antecedentValueInstance != null
    }

    void testSave() {
        controller.save()

        assert model.antecedentValueInstance != null
        assert view == '/antecedentValue/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/antecedentValue/show/1'
        assert controller.flash.message != null
        assert AntecedentValue.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedentValue/list'

        populateValidParams(params)
        def antecedentValue = new AntecedentValue(params)

        assert antecedentValue.save() != null

        params.id = antecedentValue.id

        def model = controller.show()

        assert model.antecedentValueInstance == antecedentValue
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedentValue/list'

        populateValidParams(params)
        def antecedentValue = new AntecedentValue(params)

        assert antecedentValue.save() != null

        params.id = antecedentValue.id

        def model = controller.edit()

        assert model.antecedentValueInstance == antecedentValue
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedentValue/list'

        response.reset()

        populateValidParams(params)
        def antecedentValue = new AntecedentValue(params)

        assert antecedentValue.save() != null

        // test invalid parameters in update
        params.id = antecedentValue.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/antecedentValue/edit"
        assert model.antecedentValueInstance != null

        antecedentValue.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/antecedentValue/show/$antecedentValue.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        antecedentValue.clearErrors()

        populateValidParams(params)
        params.id = antecedentValue.id
        params.version = -1
        controller.update()

        assert view == "/antecedentValue/edit"
        assert model.antecedentValueInstance != null
        assert model.antecedentValueInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/antecedentValue/list'

        response.reset()

        populateValidParams(params)
        def antecedentValue = new AntecedentValue(params)

        assert antecedentValue.save() != null
        assert AntecedentValue.count() == 1

        params.id = antecedentValue.id

        controller.delete()

        assert AntecedentValue.count() == 0
        assert AntecedentValue.get(antecedentValue.id) == null
        assert response.redirectedUrl == '/antecedentValue/list'
    }
}
