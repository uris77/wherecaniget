import cucumber.runtime.PendingException
import static org.junit.Assert.*
import org.wherecaniget.*

this.metaClass.mixin(cucumber.runtime.groovy.EN)

StoreVM vm

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
