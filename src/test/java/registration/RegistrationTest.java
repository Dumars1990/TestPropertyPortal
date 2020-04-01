package registration;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;


public class RegistrationTest extends BaseTest {

    public static void registerValidUser(RegistrationPage registrationPage) throws InterruptedException {
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18012001);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(12345);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660646966);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("QWert12345!");
        registrationPage.setConfirmPasswordField("QWert12345!");
        registrationPage.clickRegistrationButton();
    }

    //Registration with all valid data
    @Test
    public void testGeneralInformationRegistration() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();

        String expectedURL = "https://grup5web.firebaseapp.com/register/register.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        registerValidUser(registrationPage);

        expectedURL = "https://grup5web.firebaseapp.com/login/login.html";
        actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    //Registration providing date Birth Day less than 18 years
    @Test
    public void invalidBirthDay() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18012002);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(12345);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660646966);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("QWert12345!");
        registrationPage.setConfirmPasswordField("QWert12345!");
        registrationPage.clickRegistrationButton();

        String expectedErrorMsg = "- Debe ser mayor de edad para poder registrarse.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),' - Debe ser mayor de edad para poder registrarse.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Registration with less than 5 Postal Code numbers
    @Test
    public void invalidPostalCode() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18061990);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(123);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660646966);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("QWert12345!");
        registrationPage.setConfirmPasswordField("QWert12345!");
        registrationPage.clickRegistrationButton();

        String expectedErrorMsg = "- El código postal tiene que tener una longitud de 5 números.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),' - El código postal tiene que tener una longitud de 5 números.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Registration phone with different 9 number of characters
    @Test
    public void invalidPhone() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18061990);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(12345);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("QWert12345!");
        registrationPage.setConfirmPasswordField("QWert12345!");
        registrationPage.clickRegistrationButton();

        String expectedErrorMsg = "- El teléfono tiene que tener una longitud de 9 números.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),' - El teléfono tiene que tener una longitud de 9 números.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Registration password with just one capital letter
    @Test
    public void invalidOneCapitalLetterPassword() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18061990);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(12345);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660646966);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("Qwert1345!");
        registrationPage.setConfirmPasswordField("QWert12345!");
        registrationPage.clickRegistrationButton();

        String expectedErrorMsg = "- La contraseña tiene que tener más de una mayúscula.\n- No coinciden las contraseñas.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),'- La contraseña tiene que tener más de una mayúscula.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Registration password with less than 8 characters
    @Test
    public void invalidLessEightCharactersPassword() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18061990);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(12345);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660646966);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("QWert12");
        registrationPage.setConfirmPasswordField("QWert12345!");
        registrationPage.clickRegistrationButton();

        String expectedErrorMsg = "- La contraseña tiene que tener una longitud de al menos 8 caracteres.\n- No coinciden las contraseñas.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),'- La contraseña tiene que tener una longitud de al menos 8 caracteres.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Registration password with just one number
    @Test
    public void invalidJustOneNumberPassword() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18061990);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(12345);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660646966);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("QWert1Qwert");
        registrationPage.setConfirmPasswordField("QWert1QWert");
        registrationPage.clickRegistrationButton();

        String expectedErrorMsg = "- La contraseña tiene que tener más de un número.\n- No coinciden las contraseñas.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),'- La contraseña tiene que tener más de un número.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //Registration password different than Confirm password
    @Test
    public void differentPasswordAndConfirmPassword() throws InterruptedException {
        RegistrationPage registrationPage = homePage.clickFormRegistration();
        registrationPage.setNameField("NameTest");
        registrationPage.setLastNameField("LastName");
        registrationPage.setDniField("48638898Q");
        registrationPage.setBirthDateField(18061990);
        registrationPage.setAddressField("AddressTest");
        registrationPage.setCityField("CityTest");
        registrationPage.setPostalCodeField(12345);
        registrationPage.setCountryField("CountryTest");
        registrationPage.setPhoneField(660646966);
        registrationPage.setEmailField("testEmail99@gmail.com");
        registrationPage.setUserNameField("UserTest");
        registrationPage.setPasswordField("QWert12345!");
        registrationPage.setConfirmPasswordField("QWert12345!AAA");
        registrationPage.clickRegistrationButton();

        String expectedErrorMsg = "- No coinciden las contraseñas.";
        WebElement exp = driver.findElement(By.xpath("//p[contains(text(),' - No coinciden las contraseñas.')]"));
        String actualErrorMsg = exp.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

}
