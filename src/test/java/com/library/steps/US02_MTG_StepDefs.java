package com.library.steps;

import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_MTG_StepDefs {

    String actualBorrowedBookNumbers;

    @Given("the {string} on the home page. MTG")
    public void theOnTheHomePageMTG(String userType) {
        new LoginPage().login(userType);

    }

    @When("the librarian gets borrowed books number. MTG")
    public void theLibrarianGetsBorrowedBooksNumberMTG() {
        String query = "select count(*) from book_borrow\n" + "where is_returned=0;"; // 465
        DB_Util.runQuery(query);

        actualBorrowedBookNumbers = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualBorrowedBookNumbers = " + actualBorrowedBookNumbers);

        BrowserUtil.waitFor(2);

    }

    @Then("borrowed books number information must match with DB. MTG")
    public void borrowedBooksNumberInformationMustMatchWithDBMTG() {
        String query = "select count(*) from book_borrow\n" + "where is_returned=0;";
        DB_Util.runQuery(query);
        String expectedBorrowedBookNumbers = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBookNumbers = " + expectedBorrowedBookNumbers);

        // MAKE ASSERTIONS
        Assert.assertEquals(expectedBorrowedBookNumbers, actualBorrowedBookNumbers);
    }
}
