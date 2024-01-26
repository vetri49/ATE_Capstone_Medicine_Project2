@tag
Feature: Delete the medicine
  I want to test the functionality of deleting a medicine

  @tag1 @DeleteMedicine
  Scenario: Delete the product
    Given the user is logged into the product management system
    When there is an existing medicine product to be deleted
    Then the system should confirm the successful deletion of the medicine product
    And the user can verify that the product is no longer available
