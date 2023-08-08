package com.cydeo.library.step_definitions;

import com.cydeo.library.utilities.DBUtils;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before()
    public void setUp(){
        System.out.println("\tthis is coming from before hook");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario){ //it must come from cucumber.io not junit
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
        System.out.println("After hook close driver");
    }

    @Before("@db")
    public void setUpDB(){
        System.out.println("creating database conneciton...");
        DBUtils.createConnection();

    }

    @After("@db")
    public void tearDownDb(){
        System.out.println("ending database connection...");
        DBUtils.destroy();
    }
}
