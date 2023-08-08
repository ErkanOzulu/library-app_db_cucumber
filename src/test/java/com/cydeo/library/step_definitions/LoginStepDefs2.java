package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs2 {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        System.out.println("Enter username: " + username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        System.out.println("Enter password: " + password);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        System.out.println("Clicking on sign in button");
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer count) {
        System.out.println("Verifying user count " + count);
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
        System.out.println("Logging in using " + username + " and " + password);
        loginPage.login(username, password);
    }

    @Then("there should be {int} {string}")
    public void there_should_be(Integer count, String type) {
        for (WebElement eachCount : dashboardPage.counts) {

            if (eachCount.getAttribute("id").equals(type)){

                Assert.assertEquals(String.valueOf(count), eachCount.getText());
            }
        }

        System.out.println("Verifying " + count + " " + type);
    }


    @Then("There should be {string} in account Username section")
    public void there_should_be_in_account_username_section(String username) {

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.accountName));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.accountDropdownn));

        System.out.println("1-text name"+dashboardPage.accountName.getText());
        System.out.println("2-text drop"+dashboardPage.accountDropdownn.getText());



        Assert.assertTrue(dashboardPage.accountName.getText().toLowerCase().contains(username));

    }

}
