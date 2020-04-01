package propertiesDetailTest;

import base.BaseTest;
import loginTest.LoginTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PropertiesPage;
import pages.PropertyDetailPage;
import pages.RegistrationPage;
import registration.RegistrationTest;

import static org.testng.Assert.assertNotEquals;

public class PropertiesDetailTest extends BaseTest {

    //Validation of likes before and after to send comments
    @Test
    public void testLikesValidation() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        RegistrationTest.registerValidUser(registrationPage);

        LoginPage loginPage = homePage.clickLoginPage();
        LoginTest.loginValidUser(loginPage);

        driver.get("https://grup5web.firebaseapp.com/properties/properties.html?region=Navarra");

        PropertiesPage propertiesPage = homePage.navarraComunity();

        String option = "los más caros";
        propertiesPage.filterProperties(option);
        propertiesPage.clickFirstPropertyFiltered();

        String expectedURL = "https://grup5web.firebaseapp.com/property-details/property-details.html?id=9";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        PropertyDetailPage propertyDetailPage = homePage.propertyDetail();

        propertyDetailPage.initialGetLikes();
        int initialLikes = propertyDetailPage.initialGetLikes();
        System.out.println("likesValidation-initial likes " + initialLikes);
        propertyDetailPage.setCommentsField();
        propertyDetailPage.clickSendCommentsButton();
        propertyDetailPage.finalGetLikes();
        int finalLikes = propertyDetailPage.finalGetLikes();
        System.out.println("likesValidation-final likes " + finalLikes);

        assertNotEquals(initialLikes, finalLikes, "Incorrect number of likes");

        driver.navigate().back();

        expectedURL = "https://grup5web.firebaseapp.com/properties/properties.html?region=Navarra";
        actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    //Validation of interested people
    @Test(priority = 1)
    public void testCardPeopleInterestedPropertiesPage() throws InterruptedException {
        driver.get("https://grup5web.firebaseapp.com/properties/properties.html?region=Navarra");
        PropertiesPage propertiesPage = homePage.navarraComunity();

        String option = "los más caros";
        propertiesPage.filterProperties(option);
        int peopleInterestedBeforeSendComments = propertiesPage.getCardPeopleInterestedElement();
        propertiesPage.clickFirstPropertyFiltered();

        String expectedURL = "https://grup5web.firebaseapp.com/property-details/property-details.html?id=9";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        PropertyDetailPage propertyDetailPage = homePage.propertyDetail();
        propertyDetailPage.setCommentsField();
        propertyDetailPage.clickSendCommentsButton();

        driver.navigate().back();
        driver.navigate().refresh();

        propertiesPage.filterProperties(option);

        int peopleInterestedAfterSendComments = propertiesPage.getCardPeopleInterestedElement();

        Assert.assertNotEquals(peopleInterestedAfterSendComments, peopleInterestedBeforeSendComments, "Incorrect number of interested people");
    }
}
