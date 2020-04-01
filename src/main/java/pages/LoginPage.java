package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

    private WebDriver driver;

    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.xpath("//*[@id=\"loginForm\"]/div[3]/input");
    private By loginButton = By.xpath("/html/body/div[1]/div[2]/a[2]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserNameField(String name) throws InterruptedException {
        Thread.sleep(500);
        this.driver.findElement(userNameField).sendKeys(name);
    }

    public void setPasswordField(String password) {
        this.driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmitLoginButton() {
        WebElement element = this.driver.findElement(submitButton);
        Actions actions = new Actions(this.driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
