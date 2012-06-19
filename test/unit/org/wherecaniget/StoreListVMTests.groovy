package org.wherecaniget

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

@TestMixin(GrailsUnitTestMixin)
@Mock([Store])
class StoreListVMTests {

   StoreListVM vm

   @Before
   public void setUp(){
      vm = new StoreListVM()
      new Store(name:'Store1').save()
      new Store(name:'Store2').save()
      new Store(name:'Store3').save()
   }

    @Test
    void list_all_stores(){
        vm.search()
        assertEquals 3, vm.storeList.size()
    }


    @Test
    void search_for_store_by_name(){
        vm.filter = 'Store1'
        vm.search()

        assertEquals 1, vm.storeList.size()
    }

}

