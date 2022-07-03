Feature: As a Bank Manager I want to delete a customer

  Scenario: Delete a found customer
    Given I search for the created user
    When I click on the Delete button
    Then I should see the customer is deleted