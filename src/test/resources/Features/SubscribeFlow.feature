@Subscribeflow @regression

Feature: Subscription and Autopay in Monefy
  Scenario: User subscribes to a 7-day plan and enables autopay
    Given the Monefy app is launched
    When the user navigates to the subscription page
    And selects a 7-day subscription plan
    And enables autopay
    Then the subscription is activated
    And the "total balance" reflects "0" dollars