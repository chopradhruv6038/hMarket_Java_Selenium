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

public class TryADemoAccountCreationSuccessTests extends BaseTest {

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


    @Test(priority = 0, description = "Demo Account form_success_submission | This test will successfully register and open a demo account and validate successful message upon submitting form")
    public void demoAccRegistrationSuccessfulTests() throws InterruptedException {

        homePage.loadUrl(props.getProperty("hmarketswebURL"), "");
        tryADemoRegistrationFormPage = homePage.clickTryADemoBtnCntrHomePage();
        tryADemoRegistrationFormPage.selectLeverageDemoAcc(jsonObject.getJSONObject("DemoCreationFormData").getString("SelectLeverage"))
                .selectDemoAccSize(jsonObject.getJSONObject("DemoCreationFormData").getString("DemoAccSize"))
                .enterFirstNameDemoAcc(jsonObject.getJSONObject("DemoCreationFormData").getString("FirstName"))
                .enterLastNameDemoAcc(jsonObject.getJSONObject("DemoCreationFormData").getString("LastName"))
                .enterEmailDemoAcc(tryADemoRegistrationFormPage.generateRandomEmail())
                .selectCountryDemoAcc(jsonObject.getJSONObject("DemoCreationFormData").getString("CountryValue"))
                .enterPhoneNumDemoAcc(jsonObject.getJSONObject("DemoCreationFormData").getString("PhoneNum"))
                .clickMarketingNewsCheckBoxDemoAcc()
                .clickOpenADemoAccountBtn();
        tryADemoRegistrationFormPage.
                validateSuccessfulSubmissionMessageIsDisplayed();
        tryADemoRegistrationFormPage
                .assertSuccessfulSubmissionMessageIsCorrect(jsonObject.getJSONObject("DemoCreationFormData").getString("SuccessMessageDemoAcc"));


    }


    @Test(priority = 1, description = "Demo account negative / validations tests, this test will validate all the validations or errors")
    public void DemoAccRegistrationNegativeValidationsTests() {

        homePage.loadUrl(props.getProperty("hmarketswebURL"), "");
        tryADemoRegistrationFormPage = homePage.clickTryADemoBtnCntrHomePage();


    }


}
