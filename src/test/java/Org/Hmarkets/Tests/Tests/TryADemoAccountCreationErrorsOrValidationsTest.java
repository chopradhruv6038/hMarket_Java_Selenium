package Org.Hmarkets.Tests.Tests;

import Org.Hmarkets.Tests.Base.BaseTest;
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

public class TryADemoAccountCreationErrorsOrValidationsTest extends BaseTest {

    protected HomePage homePage;
    protected TryADemoRegistrationFormPage tryADemoRegistrationFormPage;

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
        tryADemoRegistrationFormPage = new TryADemoRegistrationFormPage(getDriver());


    }


    @Test(priority = 0, description = "Demo Account_negative_validations | This tests validate all the error or validations for all form fields for opening Demo account.")
    public void DemoAccRegistrationNegativeValidationsTests(){

        homePage.loadUrl(props.getProperty("hmarketswebURL"), "");
        tryADemoRegistrationFormPage = homePage.clickTryADemoBtnCntrHomePage()
                .clickOpenADemoAccBtnForValidations()
                .assertLeverageRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("DemoAccCreationFormDataValidations").getString("LeverageValidation"))
                .assertAccSizeRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("DemoAccCreationFormDataValidations").getString("AccSizeValidation"))
                .assertFirstNameDemoRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("DemoAccCreationFormDataValidations").getString("FirstNameValidation"))
                .assertLastNameDemoRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("DemoAccCreationFormDataValidations").getString("LastNameValidation"))
                .assertEmailDemoRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("DemoAccCreationFormDataValidations").getString("EmailValidation"))
                .assertCountryRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("DemoAccCreationFormDataValidations").getString("CountryValidation"))
                .assertInvalidPhoneNumRequiredValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("DemoAccCreationFormDataValidations").getString("PhoneNumberValidation"));



    }



}
