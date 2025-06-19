package Org.Hmarkets.Tests.Pom;

import Org.Hmarkets.Tests.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PersonalDetailsPage extends BasePage {

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    protected final By personalDetailsText = By.xpath("//h5[normalize-space()='Personal details']");



    public boolean validatePersonalDetailsTextIsDisplayed(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsText)).isDisplayed();

    }

    public String getPersonalDetailsSectionHeaderText(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsText)).getText();
    }

    public PersonalDetailsPage assertPersonalDetailsSectionTextIsCorrect(String expectedText){

        Assert.assertEquals(getPersonalDetailsSectionHeaderText(), expectedText);

        return this;
    }

}
