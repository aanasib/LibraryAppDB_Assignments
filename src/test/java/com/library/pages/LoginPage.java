package com.library.pages;

import com.library.utility.ConfigurationReader;
import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //@FindBy(id = "inputEmail") // this is orig

   // @FindBy(css = "label[for=\"inputEmail\"]")
   @FindBy(xpath = "//*[@id='inputEmail']") // screenshot in folder / wasn't working so revised
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;
/*

    public void login(userType){

        String username= ConfigurationReader.getProperty("student"+"_username");
        String password=ConfigurationReader.getProperty("student"+"_password");

         emailBox.sendKeys("student");
        passwordBox.sendKeys("student");
        loginButton.click();
 */

/*

orig:


   public void login(String userType){

        String username= ConfigurationReader.getProperty(userType+"_username");
        String password=ConfigurationReader.getProperty(userType+"_password");


        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();


 */
public void login(String userType){

        String username= ConfigurationReader.getProperty(userType+"_username");
        String password=ConfigurationReader.getProperty(userType+"_password");

/*
orig: 8;52


 */
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();


    }




}
