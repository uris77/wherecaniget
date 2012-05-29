import cucumber.runtime.PendingException
import static org.junit.Assert.*
import org.wherecaniget.*

this.metaClass.mixin(cucumber.runtime.groovy.EN)

StoreVM vm
StoreListVM listVm = new StoreListVM()
def storeList = []
List<Store> listStore
//StoreService storeService = new StoreService()

Given(~"^I open new store form\$") {->
}

Given(~"^I add \"([^\"]*)\"\$"){String arg1->
   vm = new StoreVM()
   vm.store = [name: 'Test Store']
   vm.storeService = new StoreService()
   vm.save()
}

Then(~"^I see \"([^\"]*)\" details\$")  {String arg1->
   assertNotNull vm.store.id
}

Given(~"^I already added \"([^\"]*)\"\$"){ String arg1->
   def storeService = appCtx.getBean('storeService')
   storeService.create([name:'New Store'])
}

When(~"^I view the store list\$"){->
   storeList = listVm.search()
}

Then(~"^my store list contains \"([^\"]*)\"\$"){ String arg1->
   Store storeInstance = Store.findByName('New Store')
   assertTrue Store.list().contains(storeInstance)
}
