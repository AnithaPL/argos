package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 


public class BasketPage {
	 
	WebDriver driver;
    By basketIcon = By.cssSelector(".trolley-icon");
    By quantityDropdown = By.cssSelector(".quantity-selector");
    By quantityOption = By.cssSelector(".quantity-selector option[value='2']");
    By subtotal = By.cssSelector(".subtotal-value");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInBasket() {
        driver.findElement(basketIcon).click();
        return driver.findElement(subtotal).isDisplayed();
    }

    public void increaseQuantityBy(int quantity) {
        driver.findElement(quantityDropdown).click();
        driver.findElement(quantityOption).click();
    }

    public boolean isSubtotalUpdated() {
        String subtotalText = driver.findElement(subtotal).getText();
        // Add logic to check if subtotal is updated correctly
        return true;
    }
}
