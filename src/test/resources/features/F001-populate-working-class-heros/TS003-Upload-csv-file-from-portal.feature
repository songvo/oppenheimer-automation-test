Feature: Upload CSV file from portal

"""
   As the Clerk, I should be able to upload a csv file to a portal so
                            that I can populate the database from a UI
      AC1: First row of the csv file must be natid, name, gender, salary,
      birthday, tax
      AC2: Subsequent rows of csv are the relevant details of each working
      class hero
      AC3: A simple button that allows me to upload a file on my pc to the
      portal
  """

  Background:
    Given As the Clerk, I want to opened the Oppenheimer portal page
    Then As the Clerk, I arrived at Oppenheimer portal page

  @portal @regression
  Scenario: Upload CSV file from portal successfully
    When As the Clerk, I want to upload a csv file is "list-of-working-class-heroes.csv" to portal
    And As the Clerk, I want to refresh tax relief table
    Then QA verify the list of working class heroes and their tax relief is populated to table:
      | NatId     | Relief   |
      | 999-$$$$$ | 32463.53 |
      | 888-$$$$$ | 44950.00 |

