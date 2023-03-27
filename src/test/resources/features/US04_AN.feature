
Feature: As a data consumer, I want UI and DB book information to be matching.
  @db @ui @wip
  Scenario: Verify book information with DB
    Given the "librarian" on the home page AN
    And the user navigates to "Books" page AN
    When the user searches for "AttiaNasib" book AN
    And  the user clicks edit book button AN
    Then book information must match the Database AN