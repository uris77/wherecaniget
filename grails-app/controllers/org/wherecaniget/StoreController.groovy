package org.wherecaniget

class StoreController {

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {}

    def create = {
    }

    def edit = {
        def storeInstance = Store.get(params.id)
        if (!storeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'store.label', default: 'Store'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [storeInstance: storeInstance]
        }
    }

}
