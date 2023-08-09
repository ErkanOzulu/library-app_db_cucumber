
Feature: Dashboard page functionalities
  As a Librarian,
  I want to see the total amount of users, books, and borrowed books on the dashboard page.

  Background:
    Given user is on the login page

  Scenario Outline:
  Verify that users as a librarian should be able to see the total amount of users,
  books, and borrowed books on the dashboard page.
    When user enter valid "<UserEmail>" and "<Password>"
    And user clicks on the sign-in button
    Then user should be able to see the total amount of <Users>,<Books> and <Borrowed_books>

    Examples:

      | UserEmail           | Password    | Users | Books | Borrowed_books |
      | librarian6@library  | libraryUser | 230   | 1531  | 105            |
      | librarian7@library  | libraryUser | 230   | 1531  | 105            |
      | librarian8@library  | libraryUser | 230   | 1531  | 105            |
      | librarian9@library  | libraryUser | 230   | 1531  | 105            |
      | librarian10@library | libraryUser | 230   | 1531  | 105            |
  @wip @db
    Scenario: Dashboard data verification against Db
      Given the user logged in as "librarian"
      When user gets all information from models
      Then the information should be same with database