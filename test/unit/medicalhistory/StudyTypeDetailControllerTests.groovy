package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(StudyTypeDetailController)
@Mock(StudyTypeDetail)
class StudyTypeDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/studyTypeDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.studyTypeDetailInstanceList.size() == 0
        assert model.studyTypeDetailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.studyTypeDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.studyTypeDetailInstance != null
        assert view == '/studyTypeDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/studyTypeDetail/show/1'
        assert controller.flash.message != null
        assert StudyTypeDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypeDetail/list'

        populateValidParams(params)
        def studyTypeDetail = new StudyTypeDetail(params)

        assert studyTypeDetail.save() != null

        params.id = studyTypeDetail.id

        def model = controller.show()

        assert model.studyTypeDetailInstance == studyTypeDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypeDetail/list'

        populateValidParams(params)
        def studyTypeDetail = new StudyTypeDetail(params)

        assert studyTypeDetail.save() != null

        params.id = studyTypeDetail.id

        def model = controller.edit()

        assert model.studyTypeDetailInstance == studyTypeDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/studyTypeDetail/list'

        response.reset()

        populateValidParams(params)
        def studyTypeDetail = new StudyTypeDetail(params)

        assert studyTypeDetail.save() != null

        // test invalid parameters in update
        params.id = studyTypeDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/studyTypeDetail/edit"
        assert model.studyTypeDetailInstance != null

        studyTypeDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/studyTypeDetail/show/$studyTypeDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        studyTypeDetail.clearErrors()

        populateValidParams(params)
        params.id = studyTypeDetail.id
        params.version = -1
        controller.update()

        assert view == "/studyTypeDetail/edit"
        assert model.studyTypeDetailInstance != null
        assert model.studyTypeDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/studyTypeDetail/list'

        response.reset()

        populateValidParams(params)
        def studyTypeDetail = new StudyTypeDetail(params)

        assert studyTypeDetail.save() != null
        assert StudyTypeDetail.count() == 1

        params.id = studyTypeDetail.id

        controller.delete()

        assert StudyTypeDetail.count() == 0
        assert StudyTypeDetail.get(studyTypeDetail.id) == null
        assert response.redirectedUrl == '/studyTypeDetail/list'
    }
}
