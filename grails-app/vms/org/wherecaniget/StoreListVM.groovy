package org.wherecaniget

import org.zkoss.bind.annotation.Command
import org.zkoss.bind.annotation.NotifyChange
import org.zkoss.zul.ListModelList

class StoreListVM {
   def filter = "*"
   def storeList = [] 
   ListModelList stores

    @NotifyChange(['stores'])
    @Command
    def search(){
        stores = new ListModelList()
        if(filter.equals("*")){
            storeList = Store.list([sort:'name'])
        }else{
            storeList = Store.findAllByNameIlike("%${filter}%")
        }
        stores.addAll(storeList)
    }

    def getStores(){
        search()
        return stores
    }

}

