Feature: list stores
   I want to list all stores in my location

Scenario: list existing stores
      Given I already added "Test Store"
      When I view the store list
      Then my store list contains "Test Store"
