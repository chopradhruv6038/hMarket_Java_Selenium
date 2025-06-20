package Org.Hmarkets.Tests.Pom;

import Org.Hmarkets.Tests.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TryADemoRegistrationFormPage extends BasePage {

    public TryADemoRegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    protected final By mt4OptionDemoAccPage = By.xpath("//button[normalize-space()='MT4']");
    protected final By tryAFreeDemoHeader = By.xpath("//h1[1][contains(text(), \"Try a free demo with a virtual\")]");
    protected final By leverageDrpdownDemoAccPage = By.cssSelector("select[name='leverage']");
    protected final By accSizeDemoAccPage = By.cssSelector("select[name='deposit']");
    protected final By firstNameDemoAccPage = By.cssSelector("input[name=\"firstName\"]");
    protected final By lastNameDemoAccPage = By.cssSelector("input[name=\"lastName\"]");
    protected final By emailDemoAccPage = By.cssSelector("input[name=\"email\"]");
    protected final By countryDemoAccPage = By.cssSelector("select[name='country']");
    protected final By phoneNumberDemoAccPage = By.cssSelector("input[inputmode=\"tel\"]");
    protected final By marketCheckboxDemoAccPage = By.xpath("(//input[@type='checkbox'])[1]");
    protected final By openADemoAccBtnOnDemoAccPage = By.cssSelector("button[type='submit']");
    protected final By successfulSubmissionMessageDemoAccount = By.xpath("//p[normalize-space()=\"Your submission was successful.\"]");


    public Boolean validateMt4OptionIsDisplayed() { // Validating mt4 option is displayed

        return wait.until(ExpectedConditions.visibilityOfElementLocated(mt4OptionDemoAccPage)).isDisplayed();

    }

    public Boolean validateTryAFreeDemoHeaderIsDisplayed() { // validating Try a free demo header is displayed

        return wait.until(ExpectedConditions.visibilityOfElementLocated(tryAFreeDemoHeader)).isDisplayed();

    }

    public TryADemoRegistrationFormPage selectLeverageDemoAcc(String leverageValue) { // These methods will return the instance of the same page

        Select select = new Select(driver.findElement(leverageDrpdownDemoAccPage));
        select.selectByValue(leverageValue);

        return this;

    }

    public TryADemoRegistrationFormPage selectDemoAccSize(String demoAccValue) {

        Select select = new Select(driver.findElement(accSizeDemoAccPage));
        select.selectByValue(demoAccValue);

        return this;

    }

    public TryADemoRegistrationFormPage enterFirstNameDemoAcc(String firstName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameDemoAccPage)).sendKeys(firstName);

        return this;
    }

    public TryADemoRegistrationFormPage enterLastNameDemoAcc(String lastName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameDemoAccPage)).sendKeys(lastName);

        return this;

    }

    public TryADemoRegistrationFormPage enterEmailDemoAcc(String email) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailDemoAccPage)).sendKeys(email);

        return this;

    }

    public TryADemoRegistrationFormPage selectCountryDemoAcc(String countryValue) {

        Select select = new Select(driver.findElement(countryDemoAccPage));
        select.selectByValue(countryValue);

        return this;

    }

    public TryADemoRegistrationFormPage enterPhoneNumDemoAcc(String phoneNumDemoAcc) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberDemoAccPage)).sendKeys(phoneNumDemoAcc);

        return this;

    }

    public TryADemoRegistrationFormPage clickMarketingNewsCheckBoxDemoAcc() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(marketCheckboxDemoAccPage)).click();

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

    public TryADemoRegistrationFormPage clickOpenADemoAccountBtn() { // This method also returns the instance of the same page, it returns the success message.

        wait.until(ExpectedConditions.visibilityOfElementLocated(openADemoAccBtnOnDemoAccPage)).click();

        return this;

    }

    public Boolean validateSuccessfulSubmissionMessageIsDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulSubmissionMessageDemoAccount)).isDisplayed();

    }

    public String getSuccessfulSubmissionMessageText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulSubmissionMessageDemoAccount)).getText();

    }

    public TryADemoRegistrationFormPage assertSuccessfulSubmissionMessageIsCorrect(String expectedMessage) {

        Assert.assertEquals(getSuccessfulSubmissionMessageText(), expectedMessage);

        return this;

    }


}
