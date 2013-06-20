package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(StudyTypeController)
@Mock(StudyType)
class StudyTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/studyType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.studyTypeInstanceList.size() == 0
        assert model.studyTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.studyTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.studyTypeInstance != null
        assert view == '/studyType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/studyType/show/1'
        assert controller.flash.message != null
        assert StudyType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/studyType/list'

        populateValidParams(params)
        def studyType = new StudyType(params)

        assert studyType.save() != null

        params.id = studyType.id

        def model = controller.show()

        assert model.studyTypeInstance == studyType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/studyType/list'

        populateValidParams(params)
        def studyType = new StudyType(params)

        assert studyType.save() != null

        params.id = studyType.id

        def model = controller.edit()

        assert model.studyTypeInstance == studyType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/studyType/list'

        response.reset()

        populateValidParams(params)
        def studyType = new StudyType(params)

        assert studyType.save() != null

        // test invalid parameters in update
        params.id = studyType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/studyType/edit"
        assert model.studyTypeInstance != null

        studyType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/studyType/show/$studyType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        studyType.clearErrors()

        populateValidParams(params)
        params.id = studyType.id
        params.version = -1
        controller.update()

        assert view == "/studyType/edit"
        assert model.studyTypeInstance != null
        assert model.studyTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/studyType/list'

        response.reset()

        populateValidParams(params)
        def studyType = new StudyType(params)

        assert studyType.save() != null
        assert StudyType.count() == 1

        params.id = studyType.id

        controller.delete()

        assert StudyType.count() == 0
        assert StudyType.get(studyType.id) == null
        assert response.redirectedUrl == '/studyType/list'
    }
}
