
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page KAD
    And the user navigates to "Books" page KAD
    When the librarian click to add book KAD
    And the librarian enter book name "<Book Name>" KAD
    When the librarian enter ISBN "<ISBN>" KAD
    And the librarian enter year "<Year>" KAD
    When the librarian enter author "<Author>" KAD
    And the librarian choose the book category "<Book Category>" KAD
    And the librarian click to save changes KAD
    Then verify "The book has been created" message is displayed KAD
    And verify "<Book Name>" information must match with DB KAD
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |