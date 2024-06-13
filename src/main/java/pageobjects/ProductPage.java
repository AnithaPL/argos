package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage {

	
	 WebDriver driver;
	    By addToBasketButton = By.cssSelector(".add-to-trolley-button");

	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void addToBasket() {
	        driver.findElement(addToBasketButton).click();
	    }
}
