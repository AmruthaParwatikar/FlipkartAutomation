package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage extends BasePage {
	
	@FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[text()='View Details']")
    private WebElement viewDetailsButton;

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }
    public void searchForProduct(String product) {
        searchBox.sendKeys(product);
        searchButton.click();
    }


    public void clickViewDetails() {
        viewDetailsButton.click();
    }
}
