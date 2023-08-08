Feature:

  Background:
    Given user is on the login page
@wip
  Scenario: Login as Librarian
    Given I login as a librarian
    When I click on "users" link
    And show records default value should be 10
    Then show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |

