package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(StudyTypesValuesController)
@Mock(StudyTypesValues)
class StudyTypesValuesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/studyTypesValues/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.studyTypesValuesInstanceList.size() == 0
        assert model.studyTypesValuesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.studyTypesValuesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.studyTypesValuesInstance != null
        assert view == '/studyTypesValues/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/studyTypesValues/show/1'
        assert controller.flash.message != null
        assert StudyTypesValues.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesValues/list'

        populateValidParams(params)
        def studyTypesValues = new StudyTypesValues(params)

        assert studyTypesValues.save() != null

        params.id = studyTypesValues.id

        def model = controller.show()

        assert model.studyTypesValuesInstance == studyTypesValues
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesValues/list'

        populateValidParams(params)
        def studyTypesValues = new StudyTypesValues(params)

        assert studyTypesValues.save() != null

        params.id = studyTypesValues.id

        def model = controller.edit()

        assert model.studyTypesValuesInstance == studyTypesValues
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesValues/list'

        response.reset()

        populateValidParams(params)
        def studyTypesValues = new StudyTypesValues(params)

        assert studyTypesValues.save() != null

        // test invalid parameters in update
        params.id = studyTypesValues.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/studyTypesValues/edit"
        assert model.studyTypesValuesInstance != null

        studyTypesValues.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/studyTypesValues/show/$studyTypesValues.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        studyTypesValues.clearErrors()

        populateValidParams(params)
        params.id = studyTypesValues.id
        params.version = -1
        controller.update()

        assert view == "/studyTypesValues/edit"
        assert model.studyTypesValuesInstance != null
        assert model.studyTypesValuesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesValues/list'

        response.reset()

        populateValidParams(params)
        def studyTypesValues = new StudyTypesValues(params)

        assert studyTypesValues.save() != null
        assert StudyTypesValues.count() == 1

        params.id = studyTypesValues.id

        controller.delete()

        assert StudyTypesValues.count() == 0
        assert StudyTypesValues.get(studyTypesValues.id) == null
        assert response.redirectedUrl == '/studyTypesValues/list'
    }
}
