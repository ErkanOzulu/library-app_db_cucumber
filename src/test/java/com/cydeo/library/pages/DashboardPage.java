package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends PageBase {


    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "navbarDropdown")
    public WebElement accountDropdownn;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountName;

    @FindBy(xpath = "//h2[@class='font-light m-b-0']")
    public List<WebElement> counts;




}
