@B24G48-135
Feature: As a data consumer, I want to know genre of books are being borrowed the most


   @ui @db @wip
  Scenario: US05AC1-Verify the common book genre that’s being borrowed RC
    Given Establish the database connection RC
    When I execute query to find most popular book genre RC
    Then verify "Fantasy" is the most popular book genre RC

