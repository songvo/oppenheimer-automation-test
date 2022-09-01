Feature: As the Governor, I should be able to see a button on the screen so
  that I can dispense tax relief for my working class heroes

  Background:
    Given As the Governor, I want to insert 5 random to database
    Then QA verifies that the HTTP response code is 200
    Given As the Governor, I want to opened the Oppenheimer portal page
    Then As the Governor, I arrived at Oppenheimer portal page

  @portal
  Scenario: Dispense tax relief successfully
    Then As the Governor, I should be able to see a button on the screen
      | text         | color |
      | Dispense Now | RED   |
    When As the Governor, I can dispense tax relief for my working class heroes
    Then QA verifies that dispense page will be displayed with text "Cash dispensed"

