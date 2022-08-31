Feature: Insert multiple records

  """
  As the Clerk, I should be able to insert more than one working
                              class hero into database via an API

  """
  @service
  Scenario: Insert multiple records successfully
    When As the Clerk, I want to insert record(s) of working class hero as following details:
      | natId       | name     | gender | birthday   | salary  |
      | 789-1234567 | Leo Park | Male   | 09-09-1992 | 7000000 |
      | 789-1234567 | Leo Park | Male   | 09-09-1992 | 7000000 |
    Then QA verifies that the HTTP response code is 202
    And QA verifies that the HTTP response body is:
    """
      Alright
    """