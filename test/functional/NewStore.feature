Feature: new store entry
   I want to add stores in my location
   so that I can track what items they sell

Scenario: new store
      Given I open new store form
      When I add "Test Store"
      Then I see "Test Store" details
