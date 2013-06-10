package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(MedicalStudyDetailController)
@Mock(MedicalStudyDetail)
class MedicalStudyDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/medicalStudyDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.medicalStudyDetailInstanceList.size() == 0
        assert model.medicalStudyDetailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.medicalStudyDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.medicalStudyDetailInstance != null
        assert view == '/medicalStudyDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/medicalStudyDetail/show/1'
        assert controller.flash.message != null
        assert MedicalStudyDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudyDetail/list'

        populateValidParams(params)
        def medicalStudyDetail = new MedicalStudyDetail(params)

        assert medicalStudyDetail.save() != null

        params.id = medicalStudyDetail.id

        def model = controller.show()

        assert model.medicalStudyDetailInstance == medicalStudyDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudyDetail/list'

        populateValidParams(params)
        def medicalStudyDetail = new MedicalStudyDetail(params)

        assert medicalStudyDetail.save() != null

        params.id = medicalStudyDetail.id

        def model = controller.edit()

        assert model.medicalStudyDetailInstance == medicalStudyDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudyDetail/list'

        response.reset()

        populateValidParams(params)
        def medicalStudyDetail = new MedicalStudyDetail(params)

        assert medicalStudyDetail.save() != null

        // test invalid parameters in update
        params.id = medicalStudyDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/medicalStudyDetail/edit"
        assert model.medicalStudyDetailInstance != null

        medicalStudyDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/medicalStudyDetail/show/$medicalStudyDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        medicalStudyDetail.clearErrors()

        populateValidParams(params)
        params.id = medicalStudyDetail.id
        params.version = -1
        controller.update()

        assert view == "/medicalStudyDetail/edit"
        assert model.medicalStudyDetailInstance != null
        assert model.medicalStudyDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/medicalStudyDetail/list'

        response.reset()

        populateValidParams(params)
        def medicalStudyDetail = new MedicalStudyDetail(params)

        assert medicalStudyDetail.save() != null
        assert MedicalStudyDetail.count() == 1

        params.id = medicalStudyDetail.id

        controller.delete()

        assert MedicalStudyDetail.count() == 0
        assert MedicalStudyDetail.get(medicalStudyDetail.id) == null
        assert response.redirectedUrl == '/medicalStudyDetail/list'
    }
}
