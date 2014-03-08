package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(StudyTypesDetailsController)
@Mock(StudyTypesDetails)
class StudyTypesDetailsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/studyTypesDetails/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.studyTypesDetailsInstanceList.size() == 0
        assert model.studyTypesDetailsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.studyTypesDetailsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.studyTypesDetailsInstance != null
        assert view == '/studyTypesDetails/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/studyTypesDetails/show/1'
        assert controller.flash.message != null
        assert StudyTypesDetails.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetails/list'

        populateValidParams(params)
        def studyTypesDetails = new StudyTypesDetails(params)

        assert studyTypesDetails.save() != null

        params.id = studyTypesDetails.id

        def model = controller.show()

        assert model.studyTypesDetailsInstance == studyTypesDetails
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetails/list'

        populateValidParams(params)
        def studyTypesDetails = new StudyTypesDetails(params)

        assert studyTypesDetails.save() != null

        params.id = studyTypesDetails.id

        def model = controller.edit()

        assert model.studyTypesDetailsInstance == studyTypesDetails
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetails/list'

        response.reset()

        populateValidParams(params)
        def studyTypesDetails = new StudyTypesDetails(params)

        assert studyTypesDetails.save() != null

        // test invalid parameters in update
        params.id = studyTypesDetails.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/studyTypesDetails/edit"
        assert model.studyTypesDetailsInstance != null

        studyTypesDetails.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/studyTypesDetails/show/$studyTypesDetails.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        studyTypesDetails.clearErrors()

        populateValidParams(params)
        params.id = studyTypesDetails.id
        params.version = -1
        controller.update()

        assert view == "/studyTypesDetails/edit"
        assert model.studyTypesDetailsInstance != null
        assert model.studyTypesDetailsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetails/list'

        response.reset()

        populateValidParams(params)
        def studyTypesDetails = new StudyTypesDetails(params)

        assert studyTypesDetails.save() != null
        assert StudyTypesDetails.count() == 1

        params.id = studyTypesDetails.id

        controller.delete()

        assert StudyTypesDetails.count() == 0
        assert StudyTypesDetails.get(studyTypesDetails.id) == null
        assert response.redirectedUrl == '/studyTypesDetails/list'
    }
}
