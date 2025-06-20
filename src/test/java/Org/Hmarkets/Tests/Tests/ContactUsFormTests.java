package Org.Hmarkets.Tests.Tests;

import Org.Hmarkets.Tests.Base.BaseTest;
import Org.Hmarkets.Tests.Pom.ContactUsFormPage;
import Org.Hmarkets.Tests.Pom.HomePage;
import Org.Hmarkets.Tests.Pom.TryADemoRegistrationFormPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ContactUsFormTests extends BaseTest {

    protected HomePage homePage;
    protected ContactUsFormPage contactUsFormPage;

    String path;
    InputStream loginDetails;
    Properties props;

    InputStream inputData;
    JSONObject jsonObject;
    JSONTokener jsonTokener;
    String jsonPath;

    @BeforeClass
    public void beforeClass() throws IOException {


        props = new Properties();
        path = "config.properties";
        loginDetails = getClass().getClassLoader().getResourceAsStream(path);
        props.load(loginDetails);


        jsonPath = "Data/InputAndExpectedData.json";
        inputData = getClass().getClassLoader().getResourceAsStream(jsonPath);
        jsonTokener = new JSONTokener(inputData);
        jsonObject = new JSONObject(jsonTokener);

    }

    @BeforeMethod
    public void beforeMethod() {

        homePage = new HomePage(getDriver());
        contactUsFormPage = new ContactUsFormPage(getDriver());



    }


    @Test(priority = 0, description = "This test will successfully register and open a demo account and validate successful message upon opening")
    public void contactUsFormSuccessfulTests() throws InterruptedException {

        homePage.loadUrl(props.getProperty("hmarketswebURL"), "");
        homePage.validateContactUsBtnIsDisplayed(); // validate contact us link is displayed.

        contactUsFormPage = homePage.clickContactUsBtnTopHomePage();
        contactUsFormPage.validateContactUsMainHeaderIsDisplayed();
        contactUsFormPage.assertContactUsHeaderTextIsCorrect(jsonObject.getJSONObject("ContactUsFormData").getString("ContactUsPageHeader"))
                .scrollToContactUsForm()
                .enterFirstNameContactUsForm(jsonObject.getJSONObject("ContactUsFormData").getString("FirstName"))
                .enterLastNameContactUsForm(jsonObject.getJSONObject("ContactUsFormData").getString("LastName"))
                .enterEmailContactUsForm(contactUsFormPage.generateRandomEmail())
                .selectCountryContactUsForm(jsonObject.getJSONObject("ContactUsFormData").getString("CountryValue"))
                .enterPhoneNumContactUsForm(jsonObject.getJSONObject("ContactUsFormData").getString("PhoneNum"))
                .selectSubjectContactUsForm(jsonObject.getJSONObject("ContactUsFormData").getString("Subject"))
                .enterMessageToSendContactUsForm(jsonObject.getJSONObject("ContactUsFormData").getString("Message"))
                .clickCaptchaCheckBoxContactUsForm()
                .clickSendEnquiryBtnContactUsForm()
                .validateContactUsMainHeaderIsDisplayed();
        contactUsFormPage.assertContactUsSuccessfulSubmissionTextIsCorrect(jsonObject.getJSONObject("ContactUsFormData").getString("SuccessMessageContactUsForm"));


    }




    @Test(priority = 1, description = "Demo account negative / validations tests, this test will validate all the validations or errors")
    public void contactUsFormNegativeValidationsTests(){

        homePage.loadUrl(props.getProperty("hmarketswebURL"), "");
        contactUsFormPage = homePage.clickContactUsBtnTopHomePage();



    }





}
