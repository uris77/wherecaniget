package org.wherecaniget.store

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import org.zkoss.zul.*
import groovy.mock.interceptor.MockFor
import org.wherecaniget.*

@TestMixin(GrailsUnitTestMixin)
@Mock([Store])
class CreateComposerTests {

   @Before
   void setUp() {
   }

   @After
   void tearDown() {
   }

   void test_save_button_should_create_new_store_when_clicked() {
      Window.metaClass.getParams << {->[name: 'Store']}
      StoreService.metaClass.create = {params-> [id: 1, name:'Store']}
      CreateComposer.metaClass.redirect = {redirectParams -> '' }
      CreateComposer composer = new CreateComposer()
      composer.self = new Window()
      composer.metaClass.flash = [:]
      composer.metaClass.redirect = ""
      composer.storeService = new StoreService()
      composer.onClick_saveButton()

      assertNotNull composer.storeInstance.id
      assertEquals 'Store', composer.storeInstance.name
      assertNull composer.storeInstance.errors
   }
}
