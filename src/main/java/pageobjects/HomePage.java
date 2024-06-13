package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	WebDriver driver;
    By searchBox = By.id("searchTerm");
    By searchButton = By.cssSelector("._2mKaC");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
	    }
}
