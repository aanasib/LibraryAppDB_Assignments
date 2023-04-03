package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US07_MC_StepDefs {
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

        String query = "select full_name,b.name,bb.borrowed_date from users u inner join book_borrow bb on u.id = bb.user_id inner join books b on bb.book_id = b.id where full_name='Test Student 5' order by 3 desc";

        DB_Util.runQuery(query);

        String actualResult = DB_Util.getCellValue(1, 1);

        Assert.assertEquals("Test Student 5", actualResult);


    }

    @And("the user searches for {string} book. MC")
    public void theUserSearchesForBookMC(String name) {
        bookName = name;
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(1);

    }

}
