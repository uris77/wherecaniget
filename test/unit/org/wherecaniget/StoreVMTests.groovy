package org.wherecaniget

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

@TestMixin(GrailsUnitTestMixin)
@Mock([Store])
class StoreVMTests {

   @Before
    void setUp() {
    }


   @Test
   void create_new_store() {
      StoreVM vm = new StoreVM()
      vm.storeService = [create: {[id: 1, name: 'Test Store']}]
      vm.save()

      assertNotNull vm.store.id
      assertEquals 'Test Store', vm.store.name
   }
}
