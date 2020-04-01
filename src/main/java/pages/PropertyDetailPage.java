package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PropertyDetailPage {

    private WebDriver driver;

    private By commentsField = By.id("comments");
    private By sendCommentsButton = By.xpath("//*[@id=\"peopleComments\"]/div[2]/input");
    private By likesElement = By.id("likes");

    public PropertyDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCommentsField() throws InterruptedException {
        Thread.sleep(500);
        WebElement element = driver.findElement(commentsField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
        element.sendKeys("I am interested in your home!");
    }

    public void clickSendCommentsButton() {
        WebElement element = driver.findElement(sendCommentsButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    public int initialGetLikes() {
        WebElement element = driver.findElement(likesElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        int initialLikesValue = Integer.parseInt(driver.findElement(likesElement).getText());
        return initialLikesValue;
    }

    public int finalGetLikes() {
        int finalLikesValue = Integer.parseInt(driver.findElement(likesElement).getText());
        return finalLikesValue;
    }
}
