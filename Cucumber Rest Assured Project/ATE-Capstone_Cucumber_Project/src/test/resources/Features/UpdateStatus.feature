@tag
Feature: Update the product status
  I want to test the functionality of updating medicine status

  @tag1
  Scenario: Update the status of medicine
    Given there is an existing medicine product
    When selects a new status for the medicine
    Then the system should confirm the successful update of the medicine status
    And the user can validate the updated status
