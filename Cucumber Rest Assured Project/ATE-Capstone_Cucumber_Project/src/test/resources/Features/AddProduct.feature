@tag
Feature: Create a product
  I want to test the functionality of creating a product

  @tag1 @Add
  Scenario: Create a Medicine Product
    Given the user is trying to create a product
    When the user  is hit the create product url
    Then the system should confirm the successful creation of the medicine product
    And check additional outcomes related to product creation
