package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(StudyTypesDetailController)
@Mock(StudyTypesDetail)
class StudyTypesDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/studyTypesDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.studyTypesDetailInstanceList.size() == 0
        assert model.studyTypesDetailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.studyTypesDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.studyTypesDetailInstance != null
        assert view == '/studyTypesDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/studyTypesDetail/show/1'
        assert controller.flash.message != null
        assert StudyTypesDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetail/list'

        populateValidParams(params)
        def studyTypesDetail = new StudyTypesDetail(params)

        assert studyTypesDetail.save() != null

        params.id = studyTypesDetail.id

        def model = controller.show()

        assert model.studyTypesDetailInstance == studyTypesDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetail/list'

        populateValidParams(params)
        def studyTypesDetail = new StudyTypesDetail(params)

        assert studyTypesDetail.save() != null

        params.id = studyTypesDetail.id

        def model = controller.edit()

        assert model.studyTypesDetailInstance == studyTypesDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetail/list'

        response.reset()

        populateValidParams(params)
        def studyTypesDetail = new StudyTypesDetail(params)

        assert studyTypesDetail.save() != null

        // test invalid parameters in update
        params.id = studyTypesDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/studyTypesDetail/edit"
        assert model.studyTypesDetailInstance != null

        studyTypesDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/studyTypesDetail/show/$studyTypesDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        studyTypesDetail.clearErrors()

        populateValidParams(params)
        params.id = studyTypesDetail.id
        params.version = -1
        controller.update()

        assert view == "/studyTypesDetail/edit"
        assert model.studyTypesDetailInstance != null
        assert model.studyTypesDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/studyTypesDetail/list'

        response.reset()

        populateValidParams(params)
        def studyTypesDetail = new StudyTypesDetail(params)

        assert studyTypesDetail.save() != null
        assert StudyTypesDetail.count() == 1

        params.id = studyTypesDetail.id

        controller.delete()

        assert StudyTypesDetail.count() == 0
        assert StudyTypesDetail.get(studyTypesDetail.id) == null
        assert response.redirectedUrl == '/studyTypesDetail/list'
    }
}
