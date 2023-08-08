Feature:
  As a user, I should be able to login with different users using their
  correct emails and passwords. When I login, I should be able to
  see username in the account username section

  Background:
    Given user is on the login page
#Data Driven Testing with different user accounts
  Scenario Outline:Login with different credentials
    When I login using "<userEmail>" and "<password>"
    Then There should be "<username>" in account Username section
    Examples:
      | userEmail          | password    | username   |
      | librarian6@library | libraryUser | librarian 6 |
      | librarian7@library | libraryUser | librarian 7 |
      | librarian8@library | libraryUser | librarian 8 |