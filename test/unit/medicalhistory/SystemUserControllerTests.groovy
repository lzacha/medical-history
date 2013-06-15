package medicalhistory



import org.junit.*
import grails.test.mixin.*

@TestFor(SystemUserController)
@Mock(SystemUser)
class SystemUserControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/systemUser/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.systemUserInstanceList.size() == 0
        assert model.systemUserInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.systemUserInstance != null
    }

    void testSave() {
        controller.save()

        assert model.systemUserInstance != null
        assert view == '/systemUser/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/systemUser/show/1'
        assert controller.flash.message != null
        assert SystemUser.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/systemUser/list'

        populateValidParams(params)
        def systemUser = new SystemUser(params)

        assert systemUser.save() != null

        params.id = systemUser.id

        def model = controller.show()

        assert model.systemUserInstance == systemUser
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/systemUser/list'

        populateValidParams(params)
        def systemUser = new SystemUser(params)

        assert systemUser.save() != null

        params.id = systemUser.id

        def model = controller.edit()

        assert model.systemUserInstance == systemUser
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/systemUser/list'

        response.reset()

        populateValidParams(params)
        def systemUser = new SystemUser(params)

        assert systemUser.save() != null

        // test invalid parameters in update
        params.id = systemUser.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/systemUser/edit"
        assert model.systemUserInstance != null

        systemUser.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/systemUser/show/$systemUser.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        systemUser.clearErrors()

        populateValidParams(params)
        params.id = systemUser.id
        params.version = -1
        controller.update()

        assert view == "/systemUser/edit"
        assert model.systemUserInstance != null
        assert model.systemUserInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/systemUser/list'

        response.reset()

        populateValidParams(params)
        def systemUser = new SystemUser(params)

        assert systemUser.save() != null
        assert SystemUser.count() == 1

        params.id = systemUser.id

        controller.delete()

        assert SystemUser.count() == 0
        assert SystemUser.get(systemUser.id) == null
        assert response.redirectedUrl == '/systemUser/list'
    }
}
