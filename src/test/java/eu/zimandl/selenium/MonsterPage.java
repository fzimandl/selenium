package eu.zimandl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author filip.zimandl
 */
public class MonsterPage {

    private final WebDriver driver;

    MonsterPage(WebDriver driver) {
        this.driver = driver;
        driver.getTitle();
        if (!"Monster Pay for Performance Job Ads".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not Monster add job page.");
        }
    }
    
    private By edtJobTitleLocator = By.id("JobTitle");
    private By edtLocationLocator = By.id("Location");
    private By btnGetStartedLocator = By.className("btn-lg");/* btn btn-success btn-block */
    
    public MonsterPage typeJobTitle(String title) {
        driver.findElement(edtJobTitleLocator).sendKeys(title);
        return this;
    }
    
    public MonsterPage typeLocation(String location) {
        driver.findElement(edtLocationLocator).sendKeys(location);
        return this;
    }
    
    public CreateAccountPage sumbit() {
        driver.findElement(btnGetStartedLocator).submit();
        return new CreateAccountPage(driver);
    }
    
    public PostJob submitError() {
        driver.findElement(btnGetStartedLocator).submit();
        return new PostJob(driver);
    }
}

