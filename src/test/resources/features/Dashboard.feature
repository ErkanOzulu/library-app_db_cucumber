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
    Then user should be able to see the total amount of "<Users>","<Books>" and "<Borrowed_books>"

    Examples:

      | UserEmail           | Password    | Users | Books | Borrowed_books |
      | librarian6@library  | libraryUser | g     | g     | f              |
      | librarian7@library  | libraryUser | fd    | fg    | g              |
      | librarian8@library  | libraryUser | g     | a     | g              |
      | librarian9@library  | libraryUser | g     | d     | g              |
      | librarian10@library | libraryUser | df    | g     | h              |
