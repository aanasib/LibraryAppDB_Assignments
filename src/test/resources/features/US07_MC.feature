@B28G48-139
Feature: Books module
  As a students, I should be able to borrow book
  @B28G48-138 @ui @db
  Scenario: Student borrow new book
    Given the "student" on the home page. MC
    And the user navigates to "Books" page. MC
    And the user searches for "Self Confidence" book. MC
    When the user clicks Borrow Book. MC
    Then verify that book is shown in "Borrowing Books" page. MC
    And  verify logged student has same book in database. MC
