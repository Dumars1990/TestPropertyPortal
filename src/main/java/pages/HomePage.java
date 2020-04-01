package pages;


import org.openqa.selenium.WebDriver;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage clickFormRegistration() {
        return new RegistrationPage(driver);
    }

    public LoginPage clickLoginPage() {
        return new LoginPage(driver);
    }

    public PropertiesPage navarraComunity() {
        return new PropertiesPage(driver);
    }

    public PropertyDetailPage propertyDetail() {
        return new PropertyDetailPage(driver);
    }


}
