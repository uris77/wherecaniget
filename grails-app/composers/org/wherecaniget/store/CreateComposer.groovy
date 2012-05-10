package org.wherecaniget.store

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.*
import org.wherecaniget.Store

class CreateComposer {
    Window self
    def storeService

    def storeInstance

    def afterCompose = {Component comp ->
    }

    void onClick_saveButton(Event e) {
      storeInstance = storeService.create(self.params)
      if(storeInstance.errors){
         log.info storeInstance.errors
         self.renderErrors(bean: storeInstance)
      }else{
         flash.message = "Store saved successfully!"
         redirect(controller: 'store', action: 'list')
      }
    }
}
