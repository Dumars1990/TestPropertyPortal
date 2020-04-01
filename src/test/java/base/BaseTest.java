package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;


public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://grup5web.firebaseapp.com");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){driver.quit();}


}
