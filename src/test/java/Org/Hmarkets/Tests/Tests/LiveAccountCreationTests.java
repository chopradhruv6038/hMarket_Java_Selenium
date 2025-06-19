package Org.Hmarkets.Tests.Tests;

import Org.Hmarkets.Tests.Base.BaseTest;
import Org.Hmarkets.Tests.Pom.HomePage;
import Org.Hmarkets.Tests.Pom.OpenLiveAccRegistrationFormPage;
import Org.Hmarkets.Tests.Pom.PersonalDetailsPage;
import Org.Hmarkets.Tests.Pom.TryADemoRegistrationFormPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LiveAccountCreationTests extends BaseTest {

    protected HomePage homePage;
    protected OpenLiveAccRegistrationFormPage openLiveAccRegistrationFormPage;
    protected TryADemoRegistrationFormPage tryADemoRegistrationFormPage;
    protected PersonalDetailsPage personalDetailsPage;

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
        openLiveAccRegistrationFormPage = new OpenLiveAccRegistrationFormPage(getDriver());
        tryADemoRegistrationFormPage = new TryADemoRegistrationFormPage(getDriver());
        personalDetailsPage = new PersonalDetailsPage(getDriver());


    }


    @Test(priority = 0, description = "This test will successfully register and open a live account and validate successful message upon opening")
    public void liveAccRegistrationSuccessFulTests() throws InterruptedException {

        homePage.loadUrl("");
        homePage.validateOpenAnAccountBtnIsDisplayed(); // Validate open an account button is displayed.

        openLiveAccRegistrationFormPage = homePage.clickOpenAnAccBtnCntrHomePage();


    }


    @Test(priority = 1, description = "Live account negative / validations tests, this test will validate all the validations or errors")
    public void LiveAccRegistrationNegativeValidationsTests() {

        homePage.loadUrl(""); // homepage

        openLiveAccRegistrationFormPage = homePage.clickOpenAnAccBtnCntrHomePage();

        openLiveAccRegistrationFormPage.validateOpenAnAccountHeaderIsDisplayed();
        openLiveAccRegistrationFormPage.enterFirstNameLiveAcc(jsonObject.getJSONObject("LiveAccCreationFormData").getString("FirstName"))
                .enterLastNameLiveAcc(jsonObject.getJSONObject("LiveAccCreationFormData").getString("LastName"))
                .enterEmailLiveAcc(openLiveAccRegistrationFormPage.generateRandomEmail());
        openLiveAccRegistrationFormPage.selectCountryLiveAcc(jsonObject.getJSONObject("LiveAccCreationFormData").getString("CountryValue"));
        openLiveAccRegistrationFormPage.enterPhoneNumberLivAcc(jsonObject.getJSONObject("LiveAccCreationFormData").getString("PhoneNumber"))
                .enterPasswordLivAcc(jsonObject.getJSONObject("LiveAccCreationFormData").getString("Password"))
                .clickMarketingCheckBoxLivAcc();

        personalDetailsPage = openLiveAccRegistrationFormPage.clickStartYourApplicationBtn();
        personalDetailsPage.validatePersonalDetailsTextIsDisplayed();
        personalDetailsPage.assertPersonalDetailsSectionTextIsCorrect(jsonObject.getJSONObject("LiveAccCreationExpectedTexts").getString("PersonalDetailsSectionText"));



    }


}
