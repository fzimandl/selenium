package eu.zimandl.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author filip.zimandl
 */
public class Tests {

    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void correctValues() {
        driver.get("https://networkjobads.monster.com/");
        MonsterPage model = new MonsterPage(driver);
        model.typeJobTitle("Dream Job");
        model.typeLocation("10019, New York City, NY");
        CreateAccountPage newAccount = model.sumbit();
    }
    
    @Test
    public void allEmpty() {
        driver.get("https://networkjobads.monster.com/");
        MonsterPage model = new MonsterPage(driver);
        PostJob newAccount = model.submitError();
        driver.findElement(By.linkText("Job Title"));
        driver.findElement(By.linkText("Location"));
    }
    
    @Test
    public void missingLocation() {
        driver.get("https://networkjobads.monster.com/");
        MonsterPage model = new MonsterPage(driver);
        model.typeJobTitle("Jobic");
        PostJob newAccount = model.submitError();
        Assert.assertTrue("Element missing location not present", newAccount.isElementPresent(By.linkText("Location")));
        Assert.assertFalse("Element missing job title present", newAccount.isElementPresent(By.linkText("Job Title")));
    }
    
    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }
}
