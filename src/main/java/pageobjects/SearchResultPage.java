package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage {

	 WebDriver driver;
	    By productList = By.cssSelector(".styles__ProductsContainer-yk9ytf-1");
	    By firstProduct = By.cssSelector(".ProductCardstyles__MainWrapper-swg8my-2");

	    public SearchResultPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isProductListDisplayed() {
	        return driver.findElement(productList).isDisplayed();
	    }

	    public ProductPage clickOnFirstProduct() {
	        driver.findElement(firstProduct).click();
	        return new ProductPage(driver);
	    }
}
