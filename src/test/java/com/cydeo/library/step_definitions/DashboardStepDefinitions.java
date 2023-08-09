package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.utilities.DBUtils;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardStepDefinitions {

    DashboardPage dashboardPage = new DashboardPage();

    String actualUsersCount;
    String actualBooksCount;
    String actualBorrowedBooksCount;


    @Then("user should be able to see the total amount of {int},{int} and {int}")
    public void shouldBeAbleToSeeTheTotalAmountOfAnd(int user_count, int book_count,int borrowed_books) {

        List<Integer> expected = new ArrayList<>(Arrays.asList(user_count, book_count, borrowed_books));

        List<Integer> actual = new ArrayList<>();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.user_count));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.book_count));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.borrowed_count));

        actual.add(Integer.valueOf(dashboardPage.user_count.getText()));
        actual.add(Integer.valueOf(dashboardPage.book_count.getText()));
        actual.add(Integer.valueOf(dashboardPage.borrowed_count.getText()));


        System.out.println(actual);

        Assert.assertEquals(expected, actual);


    }


    @When("user gets all information from models")
    public void userGetsAllInformationFromModels() {
        actualUsersCount = dashboardPage.getModuleCount("Users");
        System.out.println("actualUsersCount = " + actualUsersCount);

        actualBooksCount = dashboardPage.getModuleCount("Books");
        System.out.println("actualBooksCount = " + actualBooksCount);

        actualBorrowedBooksCount = dashboardPage.getModuleCount("Borrowed Books");
        System.out.println("actualBorrowedBooksCount = " + actualBorrowedBooksCount);

    }

    @Then("the information should be same with database")
    public void theInformationShouldBeSameWithDatabase() {



        String userCount =String.valueOf(DBUtils.getCellValue("select count(*) from users")) ;
        String bookCount=String.valueOf(DBUtils.getCellValue("select count(*) from books"));
        String borrowedBCount=String.valueOf(DBUtils.getCellValue("select count(*) from book_borrow where is_returned=0"));

        Assert.assertEquals(userCount,actualUsersCount);
        Assert.assertEquals(bookCount,actualBooksCount);
        Assert.assertEquals(borrowedBCount,actualBorrowedBooksCount);


    }
}
