@expenseflow @regression

Feature: Expense Tracking in Monefy
  Scenario: User adds an expense and checks balance
    Given the Monefy app is launched
    When the user sets the "Income" as "1000" dollars for "month"
    And user adds an expense of "90" dollars for "Transport"
    Then the "total balance" reflects "910" dollars