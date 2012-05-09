import cucumber.runtime.PendingException

this.metaClass.mixin(cucumber.runtime.groovy.EN)

Given(~"^I open new store form\$") {->
   throw new PendingException()
}

Given(~"^I add \"([^\"]*)\"\$"){String arg1->
   throw new PendingException()
}

Then(~"^I see \"([^\"]*)\" details\$")  {String arg1->
   throw new PendingException()
}
