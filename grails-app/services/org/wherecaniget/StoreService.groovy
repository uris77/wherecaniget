package org.wherecaniget

class StoreService{

   def create(params){
      def _store = [:]
      Store store = new Store()
      Store.withTransaction{
         store.name = params.name

         store.validate()

         if(store.hasErrors()){
            log.info store.retrieveErrors()
            _store.errors = store.retrieveErrors()
         }else{
            store.save()
            _store = store.properties['id','name']
         }
      }

      return _store
   }
}
