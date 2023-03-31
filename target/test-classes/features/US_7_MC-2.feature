@B28G48-139
Feature: Default
#@B28G48-138
	@ui @db @wip
	Scenario: Verify user should borrow a book
		Scenario: Student borrow new book
		
		Given The "student" on the main page
		
		And the user navigates to "Books" page
		
		And the user searches book name called "Head First Java" 
		
		When the user clicks Borrow Book
		
		Then verify that book is shown in "Borrowing Books" page
		
		And verify logged student has same book in database