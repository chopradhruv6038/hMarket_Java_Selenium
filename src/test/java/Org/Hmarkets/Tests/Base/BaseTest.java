package Org.Hmarkets.Tests.Base;
import Org.Hmarkets.Tests.Factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {

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


    //========Getter Setter methods below for parallel execution which are thread safe | each thread will get its own copy using setter ============//

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);

    }

    public WebDriver getDriver() {
        return this.driver.get();

    }





}
