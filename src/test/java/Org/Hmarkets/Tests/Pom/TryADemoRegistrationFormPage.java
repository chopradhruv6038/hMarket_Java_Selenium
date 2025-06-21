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

    // Locators for demo account form Validations:

    By openADemoAccountBtn = By.cssSelector("button[type='submit']");
    By leverageRequiredValidation = By.xpath("//span[normalize-space()='Leverage is required']");
    By accountSizeRequiredValidation = By.xpath("//span[normalize-space()='Account size is required']");
    By firstNameDemoRequiredValidation = By.xpath("//span[normalize-space()='First name is required']");
    By lastNameDemoRequiredValidation = By.xpath("//span[normalize-space()='Last name is required']");
    By emailDemoRequiredValidation = By.xpath("//span[normalize-space()='Email is required']");
    By countryDemoRequiredValidation = By.xpath("//span[normalize-space()='Country is required']");
    By invalidPhoneNumberDemoRequiredValidation = By.xpath("//span[normalize-space()='Invalid phone number']");


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

    // Validation Methods starts

    public TryADemoRegistrationFormPage clickOpenADemoAccBtnForValidations() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(openADemoAccBtnOnDemoAccPage)).click();

        return this;
    }



    public String getLeverageRequiredValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(leverageRequiredValidation)).getText();

    }

    public TryADemoRegistrationFormPage assertLeverageRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(leverageRequiredValidation)).isDisplayed();

        Assert.assertEquals(getLeverageRequiredValidationText(), expectedError);

        return this;


    }


    public String getAccSizeRequiredValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountSizeRequiredValidation)).getText();

    }

    public TryADemoRegistrationFormPage assertAccSizeRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(accountSizeRequiredValidation)).isDisplayed();

        Assert.assertEquals(getAccSizeRequiredValidationText(), expectedError);

        return this;

    }


    public String getFirstNameDemoRequiredValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameDemoRequiredValidation)).getText();

    }

    public TryADemoRegistrationFormPage assertFirstNameDemoRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameDemoRequiredValidation)).isDisplayed();

        Assert.assertEquals(getFirstNameDemoRequiredValidationText(), expectedError);

        return this;

    }

    public String getLastNameDemoRequiredValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameDemoRequiredValidation)).getText();

    }

    public TryADemoRegistrationFormPage assertLastNameDemoRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameDemoRequiredValidation)).isDisplayed();

        Assert.assertEquals(getLastNameDemoRequiredValidationText(), expectedError);

        return this;

    }

    public String getEmailDemoRequiredValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailDemoRequiredValidation)).getText();

    }

    public TryADemoRegistrationFormPage assertEmailDemoRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailDemoRequiredValidation)).isDisplayed();

        Assert.assertEquals(getEmailDemoRequiredValidationText(), expectedError);

        return this;

    }

    public String getCountryDemoRequiredValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryDemoRequiredValidation)).getText();

    }

    public TryADemoRegistrationFormPage assertCountryRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(countryDemoRequiredValidation)).isDisplayed();

        Assert.assertEquals(getCountryDemoRequiredValidationText(), expectedError);

        return this;

    }

    public String getInvalidPhoneNumDemoRequiredValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPhoneNumberDemoRequiredValidation)).getText();

    }

    public TryADemoRegistrationFormPage assertInvalidPhoneNumRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPhoneNumberDemoRequiredValidation)).isDisplayed();

        Assert.assertEquals(getInvalidPhoneNumDemoRequiredValidationText(), expectedError);

        return this;

    }



}
