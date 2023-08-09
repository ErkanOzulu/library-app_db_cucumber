package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import com.cydeo.library.utilities.LibraryConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class Login_StepDefinition {

    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enter valid studentEmail and password")
    public void user_enter_valid_studentEmail_and() {

        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("student_email"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("student_password"));

    }

    @When("user clicks on the sign-in button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.sign_inButton.click();

    }

    @Then("{string} should be able to see homepage")
    public void shouldBeAbleToSeeHomepage(String username) {


        if (username.equals("student")){

            System.out.println("ic"+Driver.getDriver().getCurrentUrl());

            Assert.assertTrue(dashboardPage.accountDropdownn.isDisplayed());

        } else{
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
            wait.until(ExpectedConditions.urlContains("dashboard"));

            System.out.println(Driver.getDriver().getCurrentUrl());
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        }


    }

    @When("user enter valid LibrarianEmail and password")
    public void userEnterValidLibrarianEmailAndPassword() {
        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("librarian_email"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian_password"));

    }



    @When("user enter valid {string} and {string}")
    public void userEnterValidAnd(String userEmail, String password) {
        loginPage.inputEmail.sendKeys(userEmail);
        loginPage.inputPassword.sendKeys(password);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        String url = null;
        if (System.getProperty("env") != null) {
            url = ConfigurationReader.getProperty(System.getProperty("env") + "_url");

        } else {
            url = ConfigurationReader.getProperty("url");
        }

        System.out.println("Going to the login page");
        // login
        // Driver.getDriver()  --> gives us a driver object
        Driver.getDriver().get(url);

    }

    @When("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {
        System.out.println("Logging in as a "+userType);
        loginPage.login(userType);
        BrowserUtils.waitFor(4);
    }



    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        System.out.println("Verifying dashboard page");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String actualTitle = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.endsWith("dashboard"));
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        System.out.println("Logging in as a student");
        String email = ConfigurationReader.getProperty("student_email");
        String password = ConfigurationReader.getProperty("student_password");
        loginPage.login(email, password);
    }

    @When("I login as an admin")
    public void i_login_as_a_admin() {
        System.out.println("Logging in as an admin");
    }


    @Given("I login using following credentials:")
    public void i_login_using_following_credentials(Map<String, String> credentials) {
        System.out.println(credentials);
        String email = credentials.get("email");
        String password = credentials.get("password");
        System.out.println("email = " + email);
        System.out.println("password = " + password);

        loginPage.login(email, password);
    }



    @Given("I login to application as a {word}")
    public void i_login_to_application_as_a(String user) throws Exception {
        String email = null, password = null;
        switch (user.toLowerCase()) {
            case LibraryConstants.LIBRARIAN:
                email = ConfigurationReader.getProperty("librarian_email");
                password = ConfigurationReader.getProperty("librarian_password");
                break;
            case LibraryConstants.STUDENT:
                email = ConfigurationReader.getProperty("student_email");
                password = ConfigurationReader.getProperty("student_password");
                break;
            default:
                throw new Exception("Wrong user type is provided: "+user);
        }
        loginPage.login(email, password);
    }



}
