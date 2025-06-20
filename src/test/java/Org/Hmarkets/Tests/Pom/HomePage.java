package Org.Hmarkets.Tests.Pom;

import Org.Hmarkets.Tests.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Element Locator Starts

    protected final By openAnAccountBtnAtHomePageCenter = By.xpath("(//div[normalize-space()=\"Open an account\"])[2]");

    protected final By tryADemoBtnAtHomePageCenter = By.xpath("(//div[normalize-space()='Try a demo'])[1]");

    protected final By contactUsLinkTopNavigationBarHomePage = By.xpath("(//a[normalize-space()='Contact Us'])[1]");

    // Method Starts

    public void loadUrl(String url, String path) { // method to load URL, path can be passed when called in test class according to the need.

        driver.get(url + path);

    }


    public Boolean validateOpenAnAccountBtnIsDisplayed() { // validating button with specific text is displayed, will return true or false.

        return wait.until(ExpectedConditions.visibilityOfElementLocated(openAnAccountBtnAtHomePageCenter)).isDisplayed();

    }

    public Boolean validateTryADemoBtnIsDisplayed() { // validating button with specific text is displayed, will return true or false.

        return wait.until(ExpectedConditions.visibilityOfElementLocated(tryADemoBtnAtHomePageCenter)).isDisplayed();

    }

    public Boolean validateContactUsBtnIsDisplayed() { // validating link with specific text is displayed, will return true or false.

        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLinkTopNavigationBarHomePage)).isDisplayed();

    }


    public OpenLiveAccRegistrationFormPage clickOpenAnAccBtnCntrHomePage() { // Clicking open an account button at the center of home screen

        wait.until(ExpectedConditions.visibilityOfElementLocated(openAnAccountBtnAtHomePageCenter)).click();

        return new OpenLiveAccRegistrationFormPage(driver);
    }


    public TryADemoRegistrationFormPage clickTryADemoBtnCntrHomePage() { // clicking Try a demo btn at the center of home screen

        wait.until(ExpectedConditions.visibilityOfElementLocated(tryADemoBtnAtHomePageCenter)).click();

        return new TryADemoRegistrationFormPage(driver);
    }

    public ContactUsFormPage clickContactUsBtnTopHomePage() { // clicking Try a demo btn at the center of home screen

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLinkTopNavigationBarHomePage)).click();

        return new ContactUsFormPage(driver);
    }


}
