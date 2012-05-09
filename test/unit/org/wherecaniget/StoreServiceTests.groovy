package org.wherecaniget

import static org.junit.Assert.*
import org.junit.*
import grails.test.mixin.*
import grails.test.mixin.support.*

@TestMixin(GrailsUnitTestMixin)
@Mock([Store])
@TestFor(StoreService)
class StoreServiceTests{

   @Test
   void create_new_store(){
      StoreService storeService = new StoreService()
      def store = [name: 'Test Store']

      def newStore = storeService.create(store)

      assertNotNull newStore.id
      assertEquals 'Test Store', newStore.name
   }
}
