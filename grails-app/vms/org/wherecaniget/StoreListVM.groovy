package org.wherecaniget

import org.zkoss.bind.annotation.Command
import org.zkoss.bind.annotation.NotifyChange

class StoreListVM {
   def filter
   def storeList = [] 

   @NotifyChange(['storeList'])
   @Command
   def search(){
      if(filter.equals("*")){
         storeList = Store.list()
      }else{
         storeList = Store.findAllByName(filter)
      }
   }

}

