package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;
    private By accountSection=By.cssSelector("div#center_column span");

    public AccountPage(WebDriver driver){
        this.driver=driver;
    }
    public String getAccountPageTitle(){
        return driver.getTitle();
    }

    public int getAccountsSectionCount(){
       return driver.findElements(accountSection).size()-1;
    }
    public List<String> getAccountsList(){
        List<String> accountList=new ArrayList<>();
        List<WebElement> accountHeaderList=driver.findElements(accountSection);
        for(int i=0;i<accountHeaderList.size();i++){
            WebElement elements=accountHeaderList.get(i);
            String text=elements.getText();
            accountList.add(text);
        }
        return accountList;
    }
}
