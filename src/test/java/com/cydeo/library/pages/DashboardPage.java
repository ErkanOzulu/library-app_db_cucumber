package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends PageBase {


    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "navbarDropdown")
    public WebElement accountDropdownn;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountName;

    @FindBy(xpath = "//h2[@class='font-light m-b-0']")
    public List<WebElement> counts;

    @FindBy(id = "user_count")
    public WebElement user_count;

    @FindBy(id = "book_count")
    public WebElement book_count;

    @FindBy(id = "borrowed_books")
    public WebElement borrowed_count;

    public String getModuleCount(String module){
        //h6[normalize-space(.)='Users']//..//h2

        String locator="//h6[normalize-space(.)='"+module+"']//..//h2";

        WebElement elementOfModule = Driver.getDriver().findElement(By.xpath(locator));

        return elementOfModule.getText();
    }

}
