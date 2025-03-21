@budgetflow @regression

Feature: Budget Management in Monefy
  Scenario: User sets a budget and tracks expenses
    Given the Monefy app is launched
    When the user sets a budget of "100" dollars
    And user adds an expense of "90" dollars for "House"
    Then the "budget" reflects "10" dollars