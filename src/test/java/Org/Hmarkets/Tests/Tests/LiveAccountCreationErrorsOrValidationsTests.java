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

public class LiveAccountCreationErrorsOrValidationsTests extends BaseTest {


    protected HomePage homePage;
    protected OpenLiveAccRegistrationFormPage openLiveAccRegistrationFormPage;
    protected TryADemoRegistrationFormPage tryADemoRegistrationFormPage;
    protected PersonalDetailsPage personalDetailsPage;

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
        openLiveAccRegistrationFormPage = new OpenLiveAccRegistrationFormPage(getDriver());
        tryADemoRegistrationFormPage = new TryADemoRegistrationFormPage(getDriver());
        personalDetailsPage = new PersonalDetailsPage(getDriver());


    }


    @Test(priority = 0, description = "Live Account_negative_validations | This tests validate all the error or validations for all form fields for opening Live account.")
    public void LiveAccRegistrationNegativeValidationsTests() {

        homePage.loadUrl(props.getProperty("hmarketswebURL"), "");

        openLiveAccRegistrationFormPage = homePage.clickOpenAnAccBtnCntrHomePage();
        openLiveAccRegistrationFormPage.clickStartYourApplicationBtnForValidations()
                .assertFirstNameValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("LiveAccCreationFormDataValidations").getString("FirstNameValidation"))
                .assertLastNameValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("LiveAccCreationFormDataValidations").getString("LastNameValidation"))
                .assertEmailValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("LiveAccCreationFormDataValidations").getString("EmailValidation"))
                .assertCountryValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("LiveAccCreationFormDataValidations").getString("CountryValidation"))
                .assertInvalidPhoneNumValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("LiveAccCreationFormDataValidations").getString("PhoneNumberValidation"))
                .assertPasswordCharacterValidationTextIsDisplayedAndIsCorrect(jsonObject.getJSONObject("LiveAccCreationFormDataValidations").getString("PasswordValidation"));


    }


}
