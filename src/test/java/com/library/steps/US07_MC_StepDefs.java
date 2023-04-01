package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US07_MC_StepDefs {

//BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    String bookName;
    String student;
    @Given("the {string} on the home page. MC")
    public void theOnTheHomePageMC(String userType) {
        BrowserUtil.waitFor(1);
        loginPage.login(userType);
        BrowserUtil.waitFor(1);
        student = userType;
    }

    @And("the user navigates to {string} page. MC")
    public void theUserNavigatesToPageMC(String page) {
        bookPage.navigateModule(page);
    }
    @And("the user searches for {string} book. MC")
    public void theUserSearchesForBookMC(String name) {
        bookName = name;
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(1);

    }


    /*
    //8:17 am
      @Given("the user searches for {string} book")
      public void theUserSearchesForBook(String name) {
          bookName = "Head First Java";
          bookPage.search.sendKeys(bookName);
          BrowserUtil.waitFor(1);
      }

     */
    @When("the user clicks Borrow Book. MC")
    public void theUserClicksBorrowBookMC() {
        BrowserUtil.waitFor(1);
        bookPage.borrowBook(bookName);
        BrowserUtil.waitFor(1);
    }
    @Then("verify that book is shown in {string} page. MC")
    public void verifyThatBookIsShownInPageMC(String borrowingPage) {

        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();// because i need this class only in this step
        bookPage.navigateModule(borrowingPage);

        //BrowserUtil.getElementsText comes from my UtilityPackage
        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));
        BrowserUtil.waitFor(1);
    }
    @And("verify logged student has same book in database. MC")
    public void verifyLoggedStudentHasSameBookInDatabaseMC() {


        String query =  "select full_name,b.name,bb.borrowed_date from users u inner join book_borrow bb on u.id = bb.user_id inner join books b on bb.book_id = b.id where full_name='Test Student 5' order by 3 desc";

        DB_Util.runQuery(query);

        String actualResult = DB_Util.getCellValue(1,1);

        Assert.assertEquals("Test Student 5", actualResult);



    }








    }








    /*

    @Given("the {string} on the main page MC")
    public void theOnTheMainPage(String user) {
        BrowserUtil.waitFor(1);
        loginPage.login(user);
        BrowserUtil.waitFor(1);
        student = user;

    }

    @And("the user navigates to {string} page MC")
    public void theUserNavigatesToPage(String page) {
        bookPage.navigateModule(page);

    }
    @And("the user searches for {string} book MC")
    public void theUserSearchesForBook(String name) {
        bookName = name;
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(1);

    }

    @When("the user clicks Borrow Book MC")
    public void theUserClicksBorrowBook() {
        BrowserUtil.waitFor(1);
        bookPage.borrowBook(bookName);
        BrowserUtil.waitFor(1);

    }

    @Then("verify that book is shown in {string} page MC")
    public void verifyThatBookIsShownInPage(String borrowingPage) {
        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();// because i need this class only in this step
        bookPage.navigateModule(borrowingPage);

        //BrowserUtil.getElementsText comes from my UtilityPackage
        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));
        BrowserUtil.waitFor(1);
    }

    @And("verify logged student has same book in database MC")
    public void verifyLoggedStudentHasSameBookInDatabase() {

        String query = "select full_name,b.name,bb.borrowed_date from users u inner join book_borrow bb on u.id = bb.user_id inner join books b on bb.book_id = b.id where full_name='Test Student 5' order by 3 desc";

        DB_Util.runQuery(query);

        String actualResult = DB_Util.getCellValue(1, 1);

        Assert.assertEquals("Test Student 5", actualResult);

    }*/

    // @And("the user searches for {string} book MC")
    // public void theUserSearchesForBookMC(String arg0) {
    //  }

/*
    @Given("the {string} on the home page. MC")
    public void the_on_the_home_page_mc(String user) {
        BrowserUtil.waitFor(1);
        loginPage.login(user);
        BrowserUtil.waitFor(1);
        student = user;

    }

    @Given("the user navigates to {string} page. MC")
    public void theUserNavigatesToPage(String page) {
        bookPage.navigateModule(page);
    }

    @Given("the user searches for {string} book. MC")
    public void the_user_searches_for_book_mc(String name) {
        bookName = name;
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(1);
    }
    @When("the user clicks Borrow Book. MC")
    public void the_user_clicks_borrow_book_mc() {
        BrowserUtil.waitFor(1);
        bookPage.borrowBook(bookName);
        BrowserUtil.waitFor(1);
    }
    @Then("verify that book is shown in {string} page. MC")
    public void verify_that_book_is_shown_in_page_mc(String borrowingPage) {
        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();// because i need this class only in this step
        bookPage.navigateModule(borrowingPage);

        //BrowserUtil.getElementsText comes from my UtilityPackage
        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));
        BrowserUtil.waitFor(1);
    }
    @Then("verify logged student has same book in database. MC")
        public void verifyLoggedStudentHasSameBookInDatabase(){
    String query =  "select full_name,b.name,bb.borrowed_date from users u inner join book_borrow bb on u.id = bb.user_id inner join books b on bb.book_id = b.id where full_name='Test Student 38' order by 3 desc";

    DB_Util.runQuery(query);

    String actualResult = DB_Util.getCellValue(1,1);

    Assert.assertEquals("Test Student 38", actualResult);
    }


 */

/*


    //============================


    @Given("The {string} on the main page")
    public void the_on_the_main_page(String user) {
        public void theOnTheMainPage(String user) {
            BrowserUtil.waitFor(1);
            loginPage.login(user);
            BrowserUtil.waitFor(1);
            student = user;
    }


    @Given("the user navigates to {string} page")

        public void theUserNavigatesToPage(String page) {
            bookPage.navigateModule(page);

        }

    @Given("the user searches for {string} book")
    public void the_user_searches_for_book(String string) {

    }
    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {

    }
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String string) {

    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }


 */

/*
    @Given("The {string} on the main page")
    public void theOnTheMainPage(String user) {
        BrowserUtil.waitFor(1);
        loginPage.login(user);
        BrowserUtil.waitFor(1);
        student = user;

    }

    @And("the user navigates to {string} page")
    public void theUserNavigatesToPage(String page) {
        bookPage.navigateModule(page);

    }

    @And("the user searches for{string} book")
    public void theUserSearchesForBook(String name) {
        bookName = name;
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(1);

    }

    @When("the user clicks Borrow Book")
    public void theUserClicksBorrowBook() {
        BrowserUtil.waitFor(1);
        bookPage.borrowBook(bookName);
        BrowserUtil.waitFor(1);

    }

    @Then("verify that book is shown in {string} page")
    public void verifyThatBookIsShownInPage(String borrowingPage) {
        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();// because i need this class only in this step
        bookPage.navigateModule(borrowingPage);

        //BrowserUtil.getElementsText comes from my UtilityPackage
        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));
        BrowserUtil.waitFor(1);
    }


    @And("verify logged student has same book in database")
    public void verifyLoggedStudentHasSameBookInDatabase() {

        String query =  "select full_name,b.name,bb.borrowed_date from users u inner join book_borrow bb on u.id = bb.user_id inner join books b on bb.book_id = b.id where full_name='Test Student 38' order by 3 desc";

        DB_Util.runQuery(query);

        String actualResult = DB_Util.getCellValue(1,1);

        Assert.assertEquals("Test Student 38", actualResult);

    }

    */



}
