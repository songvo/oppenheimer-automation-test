Feature: As the Bookkeeper, I should be able to query the amount of tax
  relief for each person in the database so that I can report the
  figures to my Bookkeeping Manager

  """
  (4) As the Bookkeeper, I should be able to query the amount of tax
    relief for each person in the database so that I can report the
    figures to my Bookkeeping Manager

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
    When As the Clerk, I want to upload a csv file is "list-of-working-class-heroes.csv" using api

  @service
  Scenario: Query tax relief successfully
    When As the Bookkeeper, I want to query the amount of tax relief for each person
    Then QA verifies that the HTTP response code is 200
    And QA verifies that the HTTP response body as json:
    """
    [
      {
          "natid": "999-$$$$$",
          "name": "Henry Henry",
          "relief": "32463.53"
      },
      {
          "natid": "888-$$$$$",
          "name": "Bamboo Bamboo",
          "relief": "44950.00"
      }
    ]
    """
    And QA verifies that NatId field must be masked from the 5th character
    And QA verify that Calculated tax relief amount after subjecting to normal rounding rule
#    # How to apply the round up rules????? => Already verify response why should verify it
#  # Input as a list of data => map loop to format the data to expected