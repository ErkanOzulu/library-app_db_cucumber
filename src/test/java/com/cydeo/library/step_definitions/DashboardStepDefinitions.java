package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardStepDefinitions {

    DashboardPage dashboardPage=new DashboardPage();
    @Then("user should be able to see the total amount of {string},{string} and {string}")
    public void shouldBeAbleToSeeTheTotalAmountOfAnd(String user_count, String book_count, String borrowed_books) {

        List<String>expected=new ArrayList<>(Arrays.asList(user_count,book_count,borrowed_books));

        List<String>actual=new ArrayList<>();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);

        for (WebElement element : dashboardPage.counts) {
            wait.until(ExpectedConditions.visibilityOf(element));
            actual.add(element.getText());
            System.out.println(element.getText());
        }
        System.out.println(actual);

        Assert.assertEquals(expected,actual);



    }

}
