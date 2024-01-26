@tag
Feature: Update the medicine product
  I want to test the functionality of updating a medicine

  @tag1 @UpdateMedicine
  Scenario: Update medicine in the store
    Given the user is on the update product page
    When modifies the details of the medicine product
    Then the system should confirm the successful update of the medicine product
    And check additional outcomes related to product updating
