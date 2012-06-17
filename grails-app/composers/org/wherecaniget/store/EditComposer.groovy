package org.wherecaniget.store

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.*
import org.wherecaniget.Store

class EditComposer {
    Window self
    def afterCompose = {Component comp ->
        //todo initialize components here
    }

    void onClick_saveButton(Event e) {
        def params=self.params
        def storeInstance = Store.get(params.id)
        if (storeInstance) {
            if (params.version != null) {
                def version = params.version
                if (storeInstance.version > version) {
                    String failureMessage = g.message(code:"default.optimistic.locking.failure",args:[g.message(code: 'store.label', default: 'Store')],default:"Another user has updated this ${storeInstance} while you were editing")
                    Messagebox.show(failureMessage, g.message(code:'error',default:'Error'), Messagebox.YES, Messagebox.ERROR)
                    return
                }
            }
            storeInstance.properties = params
            if (!storeInstance.hasErrors() && storeInstance.save(flush: true)) {
                flash.message = g.message(code: 'default.updated.message', args: [g.message(code: 'store.label', default: 'Store'), storeInstance.id])
                redirect(controller: "store", action: "edit", id: storeInstance.id)
            }else {
                log.error storeInstance.errors
                self.renderErrors(bean: storeInstance)
            }
        }
        else {
            flash.message = g.message(code: 'default.not.found.message', args: [g.message(code: 'store.label', default: 'Store'), params.id])
            redirect(controller: "store",action: "list")
        }

    }
}
