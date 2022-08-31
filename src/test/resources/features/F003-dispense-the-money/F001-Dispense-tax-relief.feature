Feature: Dispense tax relief
  """
  (5) As the Governor, I should be able to see a button on the screen so
that I can dispense tax relief for my working class heroes
      AC1: The button on the screen must be red-colored
      AC2: The text on the button must be exactly “Dispense Now”
      AC3: After clicking on the button, it should direct me to a page with a
      text that says “Cash dispensed”
  """
  Background:
    Given As the Governor, I want to opened the Oppenheimer portal page
    Then As the Governor, I arrived at Oppenheimer portal page

  @portal
  Scenario: Dispense tax relief successfully
    Then As the Governor, I should be able to see a button on the screen
    When As the Governor, I can dispense tax relief for my working class heroes
    Then QA verifies that dispense page will be displayed

