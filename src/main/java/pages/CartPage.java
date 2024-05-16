package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    

    @FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2']")
	public WebElement addToCartButton;
    
  
    public void addToCart() {
        addToCartButton.click();
    }
}