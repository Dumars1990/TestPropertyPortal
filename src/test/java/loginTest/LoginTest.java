package loginTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import registration.RegistrationTest;


public class LoginTest extends BaseTest {

    public static void loginValidUser(LoginPage loginPage) throws InterruptedException {
        loginPage.setUserNameField("UserTest");
        loginPage.setPasswordField("QWert12345!");

        loginPage.clickSubmitLoginButton();
    }

    //Login with valid data
    @Test
    public void testLoginPage() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        RegistrationTest.registerValidUser(registrationPage);

        LoginPage loginPage = homePage.clickLoginPage();
        loginValidUser(loginPage);

        String expectedURL = "https://grup5web.firebaseapp.com/map/map.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    //Login with invalid user name
    @Test (priority = 1)
    public void invalidUserName() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.clickLoginButton();
        loginPage.setUserNameField("InvalidName");
        loginPage.setPasswordField("QWert12345!");
        loginPage.clickSubmitLoginButton();

        String expectedErrorMsg = "El usuario introducido no existe.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),'El usuario introducido no existe.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Login with invalid password
    @Test (priority = 1)
    public void invalidPassword() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.clickLoginButton();
        loginPage.setUserNameField("UserTest");
        loginPage.setPasswordField("InvalidPassword");
        loginPage.clickSubmitLoginButton();

        String expectedErrorMsg = "La contraseña introducida no es correcta. Le quedan 2 intentos.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),'La contraseña introducida no es correcta. Le quedan 2 intentos.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
