@login
Feature:Library app login feature
  User Story:
  As a user, I want to login so that
  I can access the app's main features.

  Background:
    Given user is on the login page

  Scenario: Verify that user as a student should be able to log in with valid credentials and launch to the homepage.
    When user enter valid studentEmail and password
    And user clicks on the sign-in button
    Then "student" should be able to see homepage

  Scenario: Verify that user as a librarian should be able to log in with valid credentials and launch to the homepage.
    When user enter valid LibrarianEmail and password
    And user clicks on the sign-in button
    Then "librarian" should be able to see homepage

#Feature: Library app login feature
#  User Story:
#  As a user, I should be able to login with correct
#  credentials to different accounts
#
#  Background: Assuming user is on the login page
#    Given user is on the login page

#  Scenario: Login as librarian
#    When user enters librarian username
#    And user enters librarian password
#    Then user should see the dashboard
#  @student
#  Scenario: Login as student
#    When user enters student username
#    And user enters student password
#    Then user should see the dashboard
#