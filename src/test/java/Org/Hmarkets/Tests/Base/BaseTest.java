package Org.Hmarkets.Tests.Base;

import Org.Hmarkets.Tests.Factory.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BaseTest {

    //Variable declaration | Thread safe | Multi Threading support

    protected final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Before method - Start driver for driver initialisation

    @Parameters({"Browser"})
    @BeforeMethod
    public void startDriver(@Optional String Browser) throws InterruptedException {

        if (Browser == null) Browser = "chrome";

        setDriver(new DriverManager().initializeDriver(Browser));

    }

    @AfterMethod
    public void quitDriver() {

        getDriver().quit();
    }


    //========Getter Setter methods below for parallel execution which are thread safe============//

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);

    }

    public WebDriver getDriver() {
        return this.driver.get();

    }





}
