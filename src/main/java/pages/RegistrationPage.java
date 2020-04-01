package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage {

    private WebDriver driver;

    private By nameField = By.id("name");
    private By lastNameField = By.id("lastname");
    private By dniField = By.id("dni");
    private By birthDateField = By.id("birthdate");
    private By addressField = By.id("address");
    private By cityField = By.id("city");
    private By postalCodeField = By.id("zipcode");
    private By countryField = By.id("country");
    private By phoneField = By.id("phone");
    private By emailField = By.id("email");
    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("verifyPassword");
    private By registrationButton = By.xpath("//*[@id=\"registerForm\"]/div[14]/input");
    private By startRegistrationLink = new By.ByXPath("/html/body/div[1]/div[2]/a[1]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(startRegistrationLink).click();
    }

    public void setNameField(String name) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(nameField).sendKeys(name);
    }

    public void setLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setDniField(String dni) {
        driver.findElement(dniField).sendKeys(dni);
    }

    public void setBirthDateField(Integer birthDate) {
        driver.findElement(birthDateField).sendKeys(String.valueOf(birthDate));
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setCityField(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void setPostalCodeField(Integer postalCode) {
        driver.findElement(postalCodeField).sendKeys(String.valueOf(postalCode));
    }

    public void setCountryField(String country) {
        driver.findElement(countryField).sendKeys(country);
    }

    public void setPhoneField(Integer phone) {
        driver.findElement(phoneField).sendKeys(String.valueOf(phone));
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setUserNameField(String user) throws InterruptedException {
        driver.findElement(userNameField).sendKeys(user);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPasswordField(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickRegistrationButton() {
        WebElement element = driver.findElement(registrationButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

}
