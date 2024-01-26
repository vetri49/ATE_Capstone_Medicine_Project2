@tag 
Feature: Retrieve all users from Medicare
  I want to test the functionality of getting users.

  @tag1  @RetrieveUsers
  Scenario: Retrieve all users
    Given the user has logged into the Medicare system
    When the user initiates the "Retrieve All Users" action
    Then the system should return a list of all users
    And the user can validate the details of each retrieved user
