@B28G48-129
Feature: As a data consumer, I want UI and DB book information to be matching.
  @B28G48-128 @db @ui @wip
  Scenario: US04AC1-Verify book information with DB
    Given the "librarian" on the home page AN
    And the user navigates to "Books" page AN
    When the user searches for "AttiaNasib" book AN
    And  the user clicks edit book button AN
    Then book information must match the Database AN