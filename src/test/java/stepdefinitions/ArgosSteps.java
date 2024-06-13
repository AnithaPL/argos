package stepdefinitions;

import pageobjects.BasketPage;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchResultPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArgosSteps {
	private  WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    BasketPage basketPage;
    
    public ArgosSteps() {
        System.setProperty("webdriver.chrome.driver", 
        		"C:\\Users\\hp\\eclipse-workspace\\uk.argos\\drivers\\chrome.exe"); 
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
    }
    @Given("I am on the Argos homepage")
    public void i_am_on_the_argos_homepage() {
        driver.get("https://www.argos.co.uk/");
        homePage = new HomePage(driver);
    }

    @When("I search for {String}")
    public void i_search_for(String product) {
        homePage.searchForProduct(product);
        searchResultPage = new SearchResultPage(driver);
    }

    @Then("I should see results for {String}")
    public void i_should_see_results_for(String product) {
        Assert.assertTrue(searchResultPage.isProductListDisplayed());
    }

    @When("I add the first product to the basket")
    public void i_add_the_first_product_to_the_basket() {
        productPage = searchResultPage.clickOnFirstProduct();
        productPage.addToBasket();
        basketPage = new BasketPage(driver);
    }

    @Then("the product should be in the basket")
    public void the_product_should_be_in_the_basket() {
        Assert.assertTrue(basketPage.isProductInBasket());
    }

    @When("I increase the quantity by {Int}")
    public void i_increase_the_quantity_by(Integer quantity) {
        basketPage.increaseQuantityBy(quantity);
    }

    @Then("the subtotal should be updated accordingly")
    public void the_subtotal_should_be_updated_accordingly() {
        Assert.assertTrue(basketPage.isSubtotalUpdated());
        driver.quit();
    }
}
