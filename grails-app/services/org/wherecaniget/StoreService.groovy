package org.wherecaniget

class StoreService{

   def create(params){
      def _store = [:]
      Store store = new Store()
      store.name = params.name

      store.validate()

      if(store.hasErrors()){
         println store.retrieveErrors()
         _store.errors = store.retrieveErrors()
      }else{
         store.save()
         _store = store.properties['id','name']
      }

      return _store
   }

}
