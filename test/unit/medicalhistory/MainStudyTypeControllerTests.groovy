package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(MainStudyTypeController)
@Mock(MainStudyType)
class MainStudyTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/mainStudyType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.mainStudyTypeInstanceList.size() == 0
        assert model.mainStudyTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.mainStudyTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.mainStudyTypeInstance != null
        assert view == '/mainStudyType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/mainStudyType/show/1'
        assert controller.flash.message != null
        assert MainStudyType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/mainStudyType/list'

        populateValidParams(params)
        def mainStudyType = new MainStudyType(params)

        assert mainStudyType.save() != null

        params.id = mainStudyType.id

        def model = controller.show()

        assert model.mainStudyTypeInstance == mainStudyType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/mainStudyType/list'

        populateValidParams(params)
        def mainStudyType = new MainStudyType(params)

        assert mainStudyType.save() != null

        params.id = mainStudyType.id

        def model = controller.edit()

        assert model.mainStudyTypeInstance == mainStudyType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/mainStudyType/list'

        response.reset()

        populateValidParams(params)
        def mainStudyType = new MainStudyType(params)

        assert mainStudyType.save() != null

        // test invalid parameters in update
        params.id = mainStudyType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/mainStudyType/edit"
        assert model.mainStudyTypeInstance != null

        mainStudyType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/mainStudyType/show/$mainStudyType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        mainStudyType.clearErrors()

        populateValidParams(params)
        params.id = mainStudyType.id
        params.version = -1
        controller.update()

        assert view == "/mainStudyType/edit"
        assert model.mainStudyTypeInstance != null
        assert model.mainStudyTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/mainStudyType/list'

        response.reset()

        populateValidParams(params)
        def mainStudyType = new MainStudyType(params)

        assert mainStudyType.save() != null
        assert MainStudyType.count() == 1

        params.id = mainStudyType.id

        controller.delete()

        assert MainStudyType.count() == 0
        assert MainStudyType.get(mainStudyType.id) == null
        assert response.redirectedUrl == '/mainStudyType/list'
    }
}
