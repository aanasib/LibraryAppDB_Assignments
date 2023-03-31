package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US03_JES_StepDefs {
    LoginPage loginPage= new LoginPage();
    BookPage bookPage = new BookPage();

    List<String> actualBookCategories;

    @Given("the {string} on the home page. JES")
    public void the_on_the_home_page_jes(String userType) {
        loginPage.login(userType);
    }
    @When("the user navigates to {string} page. JES")
    public void the_user_navigates_to_page_jes(String string) {
        bookPage.navigateModule(string);
    }
    @When("the user clicks book categories. JES")
    public void the_user_clicks_book_categories_jes() {
        bookPage.mainCategoryElement.click();
    }
    @Then("verify book categories must match book_categories table from db. JES")
    public void verify_book_categories_must_match_book_categories_table_from_db_jes() {
        Select select = new Select(bookPage.mainCategoryElement);

        actualBookCategories = BrowserUtil.getElementsText(select.getOptions());

        actualBookCategories.remove(0);

        String query = "select name from book_categories";

        DB_Util.runQuery(query);

        List<String> expectedBookCategories = DB_Util.getColumnDataAsList("name");

        Assert.assertEquals(actualBookCategories, expectedBookCategories);

    }

}
