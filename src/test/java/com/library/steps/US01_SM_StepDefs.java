package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_SM_StepDefs {

    String actualUserCount;

    @Given("Establish the database connection. SM")
    public void establishTheDatabaseConnectionSM() {
        // Make conn with database
        // DB_Util.createConnection();
        System.out.println("**********************************************");
        System.out.println("*** CONNECTION WILL BE DONE WITH HOOK CLASS***");
        System.out.println("**********************************************");
    }
    @When("Execute query to get all IDs from users. SM")
    public void executeQueryToGetAllIDsFromUsersSM() {
        String query="select count(id) from users"; // 1855
        DB_Util.runQuery(query);

        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);
    }


    @Then("verify all users has unique ID. SM")
    public void verifyAllUsersHasUniqueIDSM() {
        String query="select count(distinct id) from users";
        DB_Util.runQuery(query);
        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);

        // MAKE ASSERTIONS
        Assert.assertEquals(expectedUserCount,actualUserCount);

        //CLOSE CONN
        // DB_Util.destroy();
        System.out.println("**********************************************");
        System.out.println("*** DESTROY  WILL BE DONE WITH HOOK CLASS***");
        System.out.println("**********************************************");
    }
    List<String> actualList;

    @When("Execute query to get all columns. SM")
    public void execute_query_to_get_all_columns_sm() {
        DB_Util.runQuery("select * from users");
        actualList = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualList = " + actualList);

    }
    @Then("verify the below columns are listed in result. SM")
    public void verify_the_below_columns_are_listed_in_result_sm(List<String> expectedList) {
        System.out.println("expectedList = " + expectedList);
        // Assertions
        Assert.assertEquals(expectedList,actualList);
    }

}