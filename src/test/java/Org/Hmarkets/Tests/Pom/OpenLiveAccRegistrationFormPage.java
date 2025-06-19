package Org.Hmarkets.Tests.Pom;

import Org.Hmarkets.Tests.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class OpenLiveAccRegistrationFormPage extends BasePage {

    public OpenLiveAccRegistrationFormPage(WebDriver driver) {
        super(driver);
    }


    // Element locators starts:

    protected final By openAnAccountHeaderLiveAccPage = By.xpath("//h1[contains(text(),'Open an account with a')]");
    protected final By firstNameFieldLiveAccPage = By.xpath("//input[@name=\"first_name\"]");
    protected final By lastNameFieldLiveAccPage = By.xpath("//input[@name=\"last_name\"]");
    protected final By emailFieldLiveAccPage = By.xpath("//input[@name=\"email\"]");
    protected final By countryFieldLiveAccPage = By.xpath("//select[@name='country']");
    protected final By phoneNumberFieldLiveAccPage = By.xpath("//input[@inputmode=\"tel\"]");
    protected final By passwordFieldLiveAccpage = By.xpath("//input[@placeholder='Enter your password']");
    protected final By marketingAckCheckboxLiveAccPage = By.xpath("(//input[@type='checkbox'])[1]");
    protected final By startYourApplicationBtnLiveAccPage = By.cssSelector("button[type='submit']");


    // Methods - User Actions starts here:


    public Boolean validateOpenAnAccountHeaderIsDisplayed() { // Validate header is displayed

        return wait.until(ExpectedConditions.visibilityOfElementLocated(openAnAccountHeaderLiveAccPage)).isDisplayed();

    }

    public OpenLiveAccRegistrationFormPage enterFirstNameLiveAcc(String firstName) { // Enter first name

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFieldLiveAccPage)).sendKeys(firstName);

        return this;
    }

    public OpenLiveAccRegistrationFormPage enterLastNameLiveAcc(String LastName) { // Enter last name

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFieldLiveAccPage)).sendKeys(LastName);

        return this;

    }

    public OpenLiveAccRegistrationFormPage enterEmailLiveAcc(String Email) { // Enter email

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLiveAccPage)).sendKeys(Email);

        return this;

    }


    public OpenLiveAccRegistrationFormPage selectCountryLiveAcc(String countryValue) { // Select country based on value of select tag, will pass while calling
        Select select = new Select(driver.findElement(countryFieldLiveAccPage));
        select.selectByValue(countryValue);
        return this;
    }


    public OpenLiveAccRegistrationFormPage enterPhoneNumberLivAcc(String PhoneNumber) { // Enter Email

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberFieldLiveAccPage)).sendKeys(PhoneNumber);

        return this;

    }

    public OpenLiveAccRegistrationFormPage enterPasswordLivAcc(String Password) { // Enter Email

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLiveAccpage)).sendKeys(Password);

        return this;

    }

    public OpenLiveAccRegistrationFormPage clickMarketingCheckBoxLivAcc() { // Click check box

        wait.until(ExpectedConditions.visibilityOfElementLocated(marketingAckCheckboxLiveAccPage)).click();

        return this;

    }

    public String generateRandomEmail(){

        String fullEmail = null;

        StringBuilder random = new StringBuilder();
        String pattern = "ABCD1234*&";

        for (int i = 0; i<=4; i++){
            random.append(pattern.charAt((int)Math.floor(Math.random()*pattern.length())));
        }

        fullEmail = random + "@gmail.com";
        return fullEmail;

    }

    public PersonalDetailsPage clickStartYourApplicationBtn(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(startYourApplicationBtnLiveAccPage)).click();

        return new PersonalDetailsPage(driver);

    }




}
