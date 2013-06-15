package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(AntecedentController)
@Mock(Antecedent)
class AntecedentControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/antecedent/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.antecedentInstanceList.size() == 0
        assert model.antecedentInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.antecedentInstance != null
    }

    void testSave() {
        controller.save()

        assert model.antecedentInstance != null
        assert view == '/antecedent/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/antecedent/show/1'
        assert controller.flash.message != null
        assert Antecedent.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedent/list'

        populateValidParams(params)
        def antecedent = new Antecedent(params)

        assert antecedent.save() != null

        params.id = antecedent.id

        def model = controller.show()

        assert model.antecedentInstance == antecedent
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedent/list'

        populateValidParams(params)
        def antecedent = new Antecedent(params)

        assert antecedent.save() != null

        params.id = antecedent.id

        def model = controller.edit()

        assert model.antecedentInstance == antecedent
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/antecedent/list'

        response.reset()

        populateValidParams(params)
        def antecedent = new Antecedent(params)

        assert antecedent.save() != null

        // test invalid parameters in update
        params.id = antecedent.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/antecedent/edit"
        assert model.antecedentInstance != null

        antecedent.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/antecedent/show/$antecedent.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        antecedent.clearErrors()

        populateValidParams(params)
        params.id = antecedent.id
        params.version = -1
        controller.update()

        assert view == "/antecedent/edit"
        assert model.antecedentInstance != null
        assert model.antecedentInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/antecedent/list'

        response.reset()

        populateValidParams(params)
        def antecedent = new Antecedent(params)

        assert antecedent.save() != null
        assert Antecedent.count() == 1

        params.id = antecedent.id

        controller.delete()

        assert Antecedent.count() == 0
        assert Antecedent.get(antecedent.id) == null
        assert response.redirectedUrl == '/antecedent/list'
    }
}
