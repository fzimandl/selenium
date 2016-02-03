package eu.zimandl.selenium;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author filip.zimandl
 */
class CreateAccountPage {
    private final WebDriver driver;
    
    public CreateAccountPage(WebDriver driver) {
        if (!"Create an Account".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not Create an account page.");
        }
        this.driver = driver;
    }
}
