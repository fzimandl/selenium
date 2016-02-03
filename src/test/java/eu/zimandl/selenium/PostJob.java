package eu.zimandl.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author filip.zimandl
 */
class PostJob {

    private final WebDriver driver;

    public PostJob(WebDriver driver) {
        if (!"Post a Job".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not Post a job page.");
        }
        this.driver = driver;
    }
    
    public boolean isElementPresent(By locator) {
        //Set the timeout to something low
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            //Set the timeout back to a reasonable value
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
