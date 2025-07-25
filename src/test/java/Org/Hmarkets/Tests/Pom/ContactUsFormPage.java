package Org.Hmarkets.Tests.Pom;

import Org.Hmarkets.Tests.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsFormPage extends BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }


    protected final By contactUsHeaderContactUsPage = By.xpath("//h1[normalize-space()='Contact us']");
    protected final By contactUsFormSubHeaderOnContactUsPage = By.xpath("//p[normalize-space()='For enquiries, assistance, or to explore our services, reach out to our dedicated team.']");
    // need to scroll to contact us form

    protected final By firstNameContactUsForm = By.cssSelector("input[name=\"first_name\"]");
    protected final By lastNameContactUsForm = By.cssSelector("input[name=\"last_name\"]");
    protected final By emailContactUsForm = By.cssSelector("input[name=\"email\"]");
    protected final By countryContactUsForm = By.cssSelector("select[name='country']");
    protected final By phoneNumberContactUsForm = By.cssSelector("input[inputmode=\"tel\"]");
    protected final By subjectDrpdownContactUsForm = By.xpath("//select[@name='subject']");
    protected final By messageToBeSendContactUsForm = By.xpath("//textarea[@name=\"lead_message\"]");
    protected final By captchaCheckBoxContactUsForm = By.xpath("//span[@id=\"recaptcha-anchor\"]");
    // (//div[@role="presentation"])[1]
    protected final By sendEnquiryBtnContactUsForm = By.xpath("//button[@type='submit']");
    protected final By yourSubmissionWasSuccessfulMessageContactUsForm = By.xpath("//p[contains(text(), \"Your submission was successful.\")]");
    protected final By iFrameCaptcha = By.cssSelector("iframe[title='reCAPTCHA']");


    // Locators for validations or errors:

    By sendEnquiryBtn = By.cssSelector("button[type='submit']");
    By firstNameRequiredValidationContactUsPage = By.xpath("//span[normalize-space()='First name is required']");
    By lastNameRequiredValidationContactUsPage = By.xpath("//span[normalize-space()='Last name is required']");
    By emailRequiredValidationContactUsPage = By.xpath("//span[normalize-space()='Email is required']");
    By countryRequiredValidationContactUsPage = By.xpath("//span[normalize-space()='Country is required']");
    By invalidPhoneNumberValidationContactUsPage = By.xpath("//span[normalize-space()='Invalid phone number']");
    By subjectRequiredValidationContactUsPage = By.xpath("//span[normalize-space()='Subject is required']");



    public Boolean validateContactUsMainHeaderIsDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsHeaderContactUsPage)).isDisplayed();

    }

    public String getContactUsHeaderText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsHeaderContactUsPage)).getText();

    }

    public ContactUsFormPage assertContactUsHeaderTextIsCorrect(String expectedText) {

        Assert.assertEquals(getContactUsHeaderText(), expectedText);

        return this;

    }

    public ContactUsFormPage scrollToContactUsForm() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(contactUsFormSubHeaderOnContactUsPage));

        return this;

    }

    public ContactUsFormPage enterFirstNameContactUsForm(String firstName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameContactUsForm)).sendKeys(firstName);

        return this;

    }

    public ContactUsFormPage enterLastNameContactUsForm(String lastName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameContactUsForm)).sendKeys(lastName);

        return this;

    }

    public ContactUsFormPage enterEmailContactUsForm(String email) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailContactUsForm)).sendKeys(email);

        return this;

    }

    public ContactUsFormPage selectCountryContactUsForm(String countryValue) {

        Select select = new Select(driver.findElement(countryContactUsForm));
        select.selectByValue(countryValue);

        return this;

    }

    public String generateRandomEmail() {

        String fullEmail = null;

        StringBuilder random = new StringBuilder();
        String pattern = "ABCD1234*&";

        for (int i = 0; i <= 4; i++) {
            random.append(pattern.charAt((int) Math.floor(Math.random() * pattern.length())));
        }

        fullEmail = random + "@gmail.com";
        return fullEmail;

    }

    public ContactUsFormPage enterPhoneNumContactUsForm(String phoneNumDemoAcc) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberContactUsForm)).sendKeys(phoneNumDemoAcc);

        return this;

    }


    public ContactUsFormPage selectSubjectContactUsForm(String subjectValue) {

        Select select = new Select(driver.findElement(subjectDrpdownContactUsForm));
        select.selectByValue(subjectValue);

        return this;

    }

    public ContactUsFormPage enterMessageToSendContactUsForm(String messageToBeSent) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(messageToBeSendContactUsForm)).sendKeys(messageToBeSent);

        return this;

    }

    public void switchToCaptchaFrame() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameCaptcha));

    }

    public ContactUsFormPage clickCaptchaCheckBoxContactUsForm() throws InterruptedException {

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", driver.findElement(captchaCheckBoxContactUsForm));

        wait.until(ExpectedConditions.visibilityOfElementLocated(captchaCheckBoxContactUsForm)).click();
        Thread.sleep(5000);

        return this;

    }


    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


    public ContactUsFormPage clickSendEnquiryBtnContactUsForm() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(sendEnquiryBtnContactUsForm)).click();

        return this;

    }

    public Boolean validateSuccessfulMessageIsDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(yourSubmissionWasSuccessfulMessageContactUsForm)).isDisplayed();

    }


    public String getContactUsFormSuccessfulSubmissionText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(yourSubmissionWasSuccessfulMessageContactUsForm)).getText();

    }


    public ContactUsFormPage assertContactUsSuccessfulSubmissionTextIsCorrect(String expectedText) {

        Assert.assertEquals(getContactUsFormSuccessfulSubmissionText(), expectedText);

        return this;

    }


    // Methods for contact us form validations

    public ContactUsFormPage clickSendEnquiryContactUsBtnForValidations() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(sendEnquiryBtn)).click();

        return this;

    }



    public String getFirstNameRequiredContactUsPageValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameRequiredValidationContactUsPage)).getText();

    }

    public ContactUsFormPage assertFirstNameContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameRequiredValidationContactUsPage)).isDisplayed();

        Assert.assertEquals(getFirstNameRequiredContactUsPageValidationText(), expectedError);

        return this;

    }

    public String getLastNameRequiredContactUsPageValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameRequiredValidationContactUsPage)).getText();

    }

    public ContactUsFormPage assertLastNameContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameRequiredValidationContactUsPage)).isDisplayed();

        Assert.assertEquals(getLastNameRequiredContactUsPageValidationText(), expectedError);

        return this;


    }



    public String getEmailRequiredContactUsPageValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailRequiredValidationContactUsPage)).getText();

    }

    public ContactUsFormPage assertEmailContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailRequiredValidationContactUsPage)).isDisplayed();

        Assert.assertEquals(getEmailRequiredContactUsPageValidationText(), expectedError);

        return this;


    }

    public String getCountryRequiredContactUsPageValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryRequiredValidationContactUsPage)).getText();

    }

    public ContactUsFormPage assertCountryRequiredContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(countryRequiredValidationContactUsPage)).isDisplayed();

        Assert.assertEquals(getCountryRequiredContactUsPageValidationText(), expectedError);

        return this;

    }


    public String getInvalidPhoneNumRequiredContactUsPageValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPhoneNumberValidationContactUsPage)).getText();

    }

    public ContactUsFormPage assertInvalidPhoneRequiredContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPhoneNumberValidationContactUsPage)).isDisplayed();

        Assert.assertEquals(getInvalidPhoneNumRequiredContactUsPageValidationText(), expectedError);

        return this;

    }


    public String getSubjectRequiredContactUsPageValidationText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(subjectRequiredValidationContactUsPage)).getText();

    }

    public ContactUsFormPage assertSubjectRequiredContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(String expectedError) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectRequiredValidationContactUsPage)).isDisplayed();

        Assert.assertEquals(getSubjectRequiredContactUsPageValidationText(), expectedError);

        return this;

    }


}
