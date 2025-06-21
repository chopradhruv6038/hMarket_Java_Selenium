package Org.Hmarkets.Tests.Tests;

import Org.Hmarkets.Tests.Base.BaseTest;
import Org.Hmarkets.Tests.Pom.ContactUsFormPage;
import Org.Hmarkets.Tests.Pom.HomePage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserContactUsFormErrorsOrValidationsTests extends BaseTest {

    protected HomePage homePage;
    protected ContactUsFormPage contactUsFormPage;

    protected String path;
    protected InputStream loginDetails;
    protected Properties props;

    protected InputStream inputData;
    protected JSONObject jsonObject;
    protected JSONTokener jsonTokener;
    protected String jsonPath;

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


    @Test(priority = 0, description = "Contact Us Form_negative_validations | This tests validate all the error or validations for contact US form.")
    public void contactUsFormNegativeValidationsTests() {

        homePage.loadUrl(props.getProperty("hmarketswebURL"), "");
        contactUsFormPage = homePage.clickContactUsBtnTopHomePage()
                .clickSendEnquiryContactUsBtnForValidations()
                .assertFirstNameContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("ContactUsFormDataValidations").getString("FirstNameValidation"))
                .assertLastNameContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("ContactUsFormDataValidations").getString("LastNameValidation"))
                .assertEmailContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("ContactUsFormDataValidations").getString("EmailValidation"))
                .assertCountryRequiredContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("ContactUsFormDataValidations").getString("CountryValidation"))
                .assertInvalidPhoneRequiredContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("ContactUsFormDataValidations").getString("PhoneNumberValidation"))
                .assertSubjectRequiredContactUsPageRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("ContactUsFormDataValidations").getString("SubjectValidation"));


    }



}
