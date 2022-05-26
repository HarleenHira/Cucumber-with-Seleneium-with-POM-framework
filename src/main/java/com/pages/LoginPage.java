package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailId= By.id("email");
    private By password=By.id("passwd");
    private By signInButton=By.id("SubmitLogin");
    private By forgotPwdLink=By.linkText("Forgot your password?");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public String getLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean isForgotPwdLinkExists(){
        return driver.findElement(forgotPwdLink).isDisplayed();
    }
    public String isForgotPwdLink(){
        return driver.findElement(forgotPwdLink).getText();
    }
    public void enterUsername(String username) {
        driver.findElement(emailId).sendKeys(username);
    }
    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin(){
        driver.findElement(signInButton).click();
    }
    public AccountPage doLogin(String un,String pwd){
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountPage(driver);
    }

}
