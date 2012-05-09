package org.wherecaniget

import org.zkoss.bind.annotation.Command
import org.zkoss.bind.annotation.NotifyChange


class StoreVM {
   def storeService
   def store

   @Command @NotifyChange(['store'])
   def save(){
      store = storeService.create(store)
   }
}

