package com.library.steps;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US05_RC_StepDefs {
    String actualPopularGenre;

    @Given("Establish the database connection RC")
    public void establish_the_database_connection_rc() {
         //already implemented by Hooks class
        }

    @When("I execute query to find most popular book genre RC")
    public void i_execute_query_to_find_most_popular_book_genre_rc() {
        String query = "select bc.name, count(*)\n" +
                "from book_borrow bb\n" +
                "         inner join books b on bb.book_id = b.id\n" +
                "         inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by name\n" +
                "order by 2 desc;";

        DB_Util.runQuery(query);

        actualPopularGenre = DB_Util.getFirstRowFirstColumn();
        //System.out.println(actualPopularGenre);

    }

    @Then("verify {string} is the most popular book genre RC")
    public void verify_is_the_most_popular_book_genre_rc(String string) {
        //System.out.println(string);
        Assert.assertEquals(string, actualPopularGenre);


    }
}