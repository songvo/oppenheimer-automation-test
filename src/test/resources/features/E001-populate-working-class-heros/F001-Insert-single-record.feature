Feature: As the Clerk, I should be able to insert a single record of working class hero into database via an API

  @service
  Scenario: Insert single record successfully
    When As the Clerk, I want to insert single record(s) of working class hero as following details:
      | natid       | name     | gender | birthday | salary  | tax  |
      | 789-1234567 | Leo Park | M      | 01011990 | 7000000 | 2000 |
    Then QA verifies that the HTTP response code is 202
    And QA verifies that the HTTP response body as text:
    """
    Alright
    """