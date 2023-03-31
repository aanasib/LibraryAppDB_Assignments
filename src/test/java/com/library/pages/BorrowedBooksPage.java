package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BorrowedBooksPage extends BasePage {
        public BorrowedBooksPage()
        {PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;
}
