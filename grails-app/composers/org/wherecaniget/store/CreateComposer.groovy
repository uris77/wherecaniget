package org.wherecaniget.store

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.*
import org.wherecaniget.Store

class CreateComposer {
    Window self
    def afterCompose = {Component comp ->
        //todo initialize components here
    }

    void onClick_saveButton(Event e) {
        def storeInstance = new Store(self.params)
        if (!storeInstance.save(flush: true) && storeInstance.hasErrors()) {
            log.error storeInstance.errors
            self.renderErrors(bean: storeInstance)
        } else {
            flash.message = g.message(code: 'default.created.message', args: [g.message(code: 'store.label', default: 'Store'), storeInstance.id])
            redirect(controller: "store", action: "list")
        }
    }
}