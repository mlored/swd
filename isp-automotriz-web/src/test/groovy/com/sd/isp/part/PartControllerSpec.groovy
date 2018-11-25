package com.sd.isp.part

import grails.test.mixin.*
import spock.lang.*

@TestFor(PartController)
@Mock(Part)
class PartControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.partList
            model.partCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.part!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def part = new Part()
            part.validate()
            controller.save(part)

        then:"The create view is rendered again with the correct model"
            model.part!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            part = new Part(params)

            controller.save(part)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/part/show/1'
            controller.flash.message != null
            Part.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def part = new Part(params)
            controller.show(part)

        then:"A model is populated containing the domain instance"
            model.part == part
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def part = new Part(params)
            controller.edit(part)

        then:"A model is populated containing the domain instance"
            model.part == part
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/part/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def part = new Part()
            part.validate()
            controller.update(part)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.part == part

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            part = new Part(params).save(flush: true)
            controller.update(part)

        then:"A redirect is issued to the show action"
            part != null
            response.redirectedUrl == "/part/show/$part.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/part/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def part = new Part(params).save(flush: true)

        then:"It exists"
            Part.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(part)

        then:"The instance is deleted"
            Part.count() == 0
            response.redirectedUrl == '/part/index'
            flash.message != null
    }
}
