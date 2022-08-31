Feature: As the Clerk, I should be able to insert more than one working class hero into database via an API

  @service
  Scenario: Insert multiple records successfully
    When As the Clerk, I want to insert multiple record(s) of working class hero as following details:
      | natid       | name        | gender | birthday | salary     | tax    |
      | 789-1234567 | Leo Park    | M      | 01011990 | 7000000.00 | 678.90 |
      | 456-9876543 | Henry Rob   | F      | 09092000 | 2345678.89 | 345.90 |
      | 925-9845698 | Dara Jennie | F      | 15091980 | 876500.60  | 965.20 |
    Then QA verifies that the HTTP response code is 202
    And QA verifies that the HTTP response body as text:
    """
    Alright
    """