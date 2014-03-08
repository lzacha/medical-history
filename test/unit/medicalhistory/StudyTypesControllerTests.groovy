package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(StudyTypesController)
@Mock(StudyTypes)
class StudyTypesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/studyTypes/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.studyTypesInstanceList.size() == 0
        assert model.studyTypesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.studyTypesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.studyTypesInstance != null
        assert view == '/studyTypes/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/studyTypes/show/1'
        assert controller.flash.message != null
        assert StudyTypes.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypes/list'

        populateValidParams(params)
        def studyTypes = new StudyTypes(params)

        assert studyTypes.save() != null

        params.id = studyTypes.id

        def model = controller.show()

        assert model.studyTypesInstance == studyTypes
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypes/list'

        populateValidParams(params)
        def studyTypes = new StudyTypes(params)

        assert studyTypes.save() != null

        params.id = studyTypes.id

        def model = controller.edit()

        assert model.studyTypesInstance == studyTypes
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypes/list'

        response.reset()

        populateValidParams(params)
        def studyTypes = new StudyTypes(params)

        assert studyTypes.save() != null

        // test invalid parameters in update
        params.id = studyTypes.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/studyTypes/edit"
        assert model.studyTypesInstance != null

        studyTypes.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/studyTypes/show/$studyTypes.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        studyTypes.clearErrors()

        populateValidParams(params)
        params.id = studyTypes.id
        params.version = -1
        controller.update()

        assert view == "/studyTypes/edit"
        assert model.studyTypesInstance != null
        assert model.studyTypesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/studyTypes/list'

        response.reset()

        populateValidParams(params)
        def studyTypes = new StudyTypes(params)

        assert studyTypes.save() != null
        assert StudyTypes.count() == 1

        params.id = studyTypes.id

        controller.delete()

        assert StudyTypes.count() == 0
        assert StudyTypes.get(studyTypes.id) == null
        assert response.redirectedUrl == '/studyTypes/list'
    }
}
