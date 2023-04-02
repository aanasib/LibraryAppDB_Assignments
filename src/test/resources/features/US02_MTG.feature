 @B28G48-136
Feature: As a librarian, I want to know borrowed books number

  @B28G48-134 @db @ui @wip
  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page. MTG
    When the librarian gets borrowed books number. MTG
    Then borrowed books number information must match with DB. MTG