package Org.Hmarkets.Tests.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class DriverManager {

    protected WebDriver driver;

    @Parameters({"Browser"})
    public WebDriver initializeDriver(String Browser) {

//        ChromeOptions options = new ChromeOptions();
//        int width = 600;
//        int height = 400;
//        Dimension dimension = new Dimension(width, height); // For specific dimension

        switch (Browser) {
            case "chrome":
                // options.addArguments("--headless=new"); // For headless mode
                driver = new ChromeDriver();
                break;

            case "firefox":

                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid Browser : " + Browser);


        }

        driver.manage().window().maximize();
        //driver.manage().window().setSize(dimension);
        return driver;

    }


}
