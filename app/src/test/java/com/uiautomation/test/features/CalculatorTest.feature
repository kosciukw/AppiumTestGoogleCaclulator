@Calculator
Feature: Calculator operations

  Background:
    Given Clear input

  @Add
  Scenario: Add 10 and 12
    When Click button one
    And Click button zero
    And Click button add
    And Click button one
    And Click button two
    And Click button equals
    Then The result should be "22"

  @Subtract
  Scenario: Subtract 10 and 7
    When Click button one
    And Click button zero
    And Click button subtract
    And Click button seven
    And Click button equals
    Then The result should be "3"

  @HistoryNavigation
  Scenario: Swipe down to show history
    When Swipe down expression
    Then History Page displayed
