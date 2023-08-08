@loginP
Feature: Login Feature
  As a user, I want to login so that
  I can access the app's main features.

  Background:
    Given user is on the login page

  Scenario Outline: Verify that users as a student should be able to log in with valid credentials and launch to the homepage.
    When user enter valid "<userEmail>" and "<password>"
    And user clicks on the sign-in button
    Then "student" should be able to see homepage

    Examples:
      | userEmail         | password    |
      | student7@library  | libraryUser |
      | student8@library  | libraryUser |
      | student9@library  | libraryUser |
      | student10@library | libraryUser |

  Scenario Outline: Verify that users as a librarian should be able to log in with valid credentials and launch to the homepage.
    When user enter valid "<userEmail>" and "<password>"
    And user clicks on the sign-in button
    Then "librarian" should be able to see homepage
    Examples:
      | userEmail           | password    |
      | librarian6@library  | libraryUser |
      | librarian7@library  | libraryUser |
      | librarian8@library  | libraryUser |
      | librarian9@library  | libraryUser |
      | librarian10@library | libraryUser |


  Scenario Outline: Login as librarian in the same line
    When I login using "<userEmail>" and "<password>"
    Then "librarian" should be able to see homepage
    And there should be <count> "<users>"
    Examples:
      | userEmail          | password    | users          | count |
      | librarian6@library | libraryUser | user_count     | 222   |
      | librarian7@library | libraryUser | book_count     | 1411  |
      | librarian8@library | libraryUser | borrowed_books | 85    |




#number can be whatever you have there