@History
Feature: Calculator history operations

  Background:
    Given Calculator has previous entries

  @ClickFormula
  Scenario: Clicking 10+12 formula should set it as current expression
    When Swipe down expression
    Then History Page displayed
    When Click formula containing "10+12"
    Then Current expression should contain "10+12"
    And Close History Page

  @ClickFormulaUiAutomator
  Scenario: Clicking 10+12 formula using AndroidUiAutomator
    When Swipe down expression
    Then History Page displayed
    When Scroll to formula "10+12"
    Then Current expression should contain "10+12"
    And Close History Page
