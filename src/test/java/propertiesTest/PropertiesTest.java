package propertiesTest;

import base.BaseTest;
import loginTest.LoginTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PropertiesPage;
import pages.RegistrationPage;
import registration.RegistrationTest;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PropertiesTest extends BaseTest {

    public static List<String> getFilterFromList(PropertiesPage propertiesPage, String option) {
        propertiesPage.filterProperties(option);
        return propertiesPage.getSelectedOptions();


    }

    @Test
    public void testGoToNavarraProperties() throws InterruptedException {
        //PropertiesPage propertiesPage = homePage.navarraComunity();

        RegistrationPage registrationPage = homePage.clickFormRegistration();
        RegistrationTest.registerValidUser(registrationPage);

        LoginPage loginPage = homePage.clickLoginPage();
        LoginTest.loginValidUser(loginPage);

        driver.get("https://grup5web.firebaseapp.com/properties/properties.html?region=Navarra");
        String expectedURL = "https://grup5web.firebaseapp.com/properties/properties.html?region=Navarra";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    //Validation select property
    @Test(priority = 1)
    public void testFilterAndSelectProperty() {
        driver.get("https://grup5web.firebaseapp.com/properties/properties.html?region=Navarra");
        PropertiesPage propertiesPage = homePage.navarraComunity();

        String filterToFind = "los más caros";
        List<String> selectedOptions = getFilterFromList(propertiesPage,filterToFind);
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(filterToFind), "Option not selected");

        propertiesPage.clickFirstPropertyFiltered();

        String expectedURL = "https://grup5web.firebaseapp.com/property-details/property-details.html?id=9";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }


}
