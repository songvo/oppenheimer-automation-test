Feature: As the Bookkeeper, I should be able to query the amount of tax
  relief for each person in the database so that I can report the
  figures to my Bookkeeping Manager

  """
    AC1: a GET endpoint which returns a list consist of natid, tax relief
      amount and name
      AC2: natid field must be masked from the 5th character onwards with
      dollar sign ‘$’
      AC3: computation of the tax relief is using the formula as described:
      AC4: After calculating the tax relief amount, it should be subjected to
      normal rounding rule to remove any decimal places
      AC5: If the calculated tax relief amount after subjecting to normal
      rounding rule is more than 0.00 but less than 50.00, the final tax
      relief amount should be 50.00
      AC6: If the calculated tax relief amount before applying the normal
      rounding rule gives a value with more than 2 decimal places, it should
      be truncated at the second decimal place and then subjected to normal
      rounding rule

  """

  Background:
    When As the QA, I want to insert multiple records of working class hero as following details:
      | natid       | name      | gender | birthday | salary    | tax    |
      | 789-1234567 | Leo Park  | M      | 01011990 | 700.00    | 678.90 |
      | 456-9876543 | Henry Rob | F      | 09092000 | 150000.00 | 1500   |

  @service @regression
  Scenario: Query tax relief successfully
    When As the Bookkeeper, I want to query the amount of tax relief for each person
    Then QA verifies that the HTTP response code is 200
    And QA verifies that natid must be masked and calculated tax relief must be rounded correctly
    And QA verifies that the HTTP response body as json:
    """
    [
        {
            "natid": "789-$$$$$$$",
            "name": "Leo Park",
            "relief": "50.00"
        },
        {
            "natid": "456-$$$$$$$",
            "name": "Henry Rob",
            "relief": "119300.00"
        }
    ]
    """
