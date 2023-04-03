package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US06_KAD_StepDefs {
    String BookName, ISBN, year, author, category;
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
    @Given("the {string} on the home page. KAD")
    public void the_on_the_home_page_kad(String userType) {
        loginPage.login(userType);
    }

    @Given("the user navigates to {string} page. KAD")
    public void the_user_navigates_to_page_kad(String string) {
        bookPage.navigateModule(string);

    }
    @When("the librarian click to add book. KAD")
    public void the_librarian_click_to_add_book_kad() {
    bookPage.addBook.click();
    }
    @When("the librarian enter book name {string}. KAD")
    public void the_librarian_enter_book_name_kad(String BookName) {
      bookPage.bookName.sendKeys(BookName);
      this.BookName= BookName;
    }
    @When("the librarian enter ISBN {string}. KAD")
    public void the_librarian_enter_isbn_kad(String ISBN) {
       bookPage.isbn.sendKeys(ISBN);
       this.ISBN=ISBN;
    }
    @When("the librarian enter year {string}. KAD")
    public void the_librarian_enter_year_kad(String year) {
        bookPage.year.sendKeys(year);
        this.year=year;
    }
    @When("the librarian enter author {string}. KAD")
    public void the_librarian_enter_author_kad(String author) {
    bookPage.author.sendKeys(author);
    this.author=author;
    }

            @When("the librarian choose the book category {string}. KAD")
            public void the_librarian_choose_the_book_category_kad (String category){
                Select select = new Select(bookPage.mainCategoryElement);
                select.selectByVisibleText(category);
                this.category = category;
            }
            @When("the librarian click to save changes. KAD")
            public void the_librarian_click_to_save_changes_kad () {
            bookPage.saveChanges.click();

            }
            @Then("verify {string} message is displayed. KAD")
            public void verify_message_is_displayed_kad (String string){
            bookPage.toastMessage.isDisplayed();
            }
            @Then("verify {string} information must match with DB. KAD")
            public void verify_information_must_match_with_db_kad (String string){
              String query = "SELECT books.name, isbn, year, author, bc.name\n" +
                        "from books\n" +
                    "         join book_categories bc\n" +
                    "              on books.book_category_id = bc.id\n" +
                    "where books.name = '"+BookName+"'and isbn='"+ISBN+"' and year='"+year+"' and author='"+author+"' and bc.name='"+category+"'";
                DB_Util.runQuery(query);
                System.out.println(DB_Util.getRowDataAsList(1));
                Assert.assertEquals(BookName, DB_Util.getCellValue(1,1));
                Assert.assertEquals(ISBN,DB_Util.getCellValue(1,2));
                Assert.assertEquals(year, DB_Util.getCellValue(1,3));
                Assert.assertEquals(author,DB_Util.getCellValue(1,4));
                Assert.assertEquals(category,DB_Util.getCellValue(1,5));
            }
            }
