@B28G48-142
Feature: As a data consumer, I want UI and DB book categories are match.
  @B28G48-137 @db @ui

  Scenario: verify book categories with DB
    Given the "librarian" on the home page. JES
    When the user navigates to "Books" page. JES
    And the user clicks book categories. JES
    Then verify book categories must match book_categories table from db. JES