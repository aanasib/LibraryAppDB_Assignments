Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection. SS

  @wip @db
  Scenario: verify users has unique IDs
    When Execute query to get all IDs from users. SS
    Then verify all users has unique ID. SS


  Scenario: verify users table columns
    When Execute query to get all columns. SS
    Then verify the below columns are listed in result. SS

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |