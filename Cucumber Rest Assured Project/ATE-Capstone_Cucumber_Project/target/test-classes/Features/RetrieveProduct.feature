@tag
Feature: Retrieve All products from the Medicare
  I want to test the functionality of retrieving all products

  @tag1  @RetrieveProduct
  Scenario: Retrieve all medicines
    Given the user is on the Medicare products page
    When the user clicks on the "Retrieve All" button
    Then all medicines should be displayed
    And the user can check more details about each medicine
