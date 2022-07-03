Feature: As a Bank Manager I want to be able to create a new customer

  Scenario: Add a New Customer
    Given I am on the Login Page
    When I navigate to the Manager Page
    And I click on the Add Customer button
    And I fill the form with values and submit it
    And I accept the popup
    Then I should be able to add a new customer successfully
    When I click on the Delete button
    Then I should see the customer is deleted