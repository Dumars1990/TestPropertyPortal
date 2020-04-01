package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class PropertiesPage {

    private WebDriver driver;

    private By filterDropDown = By.id("filter");
    private By firstPropertyCard = By.xpath("/html/body/div[2]/div[3]/div[1]");
    //    private By firstPropertyCard = By.id("card-9");
    private By cardLikesElement = By.id("likes-9");

    public PropertiesPage (WebDriver driver) {
        this.driver = driver;
    }

    public void filterProperties(String option){
        driver.findElement(filterDropDown).click();
        findDropDownFilter().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownFilter().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownFilter(){
        return new Select(driver.findElement(filterDropDown));
    }

    public int getCardPeopleInterestedElement(){
        String likesBefore = driver.findElement(cardLikesElement).getText();
        return Integer.parseInt(likesBefore.split(" ")[0]);
    }


    public void clickFirstPropertyFiltered(){
        driver.findElement(firstPropertyCard).click();
    }

}
