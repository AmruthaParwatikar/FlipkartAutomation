package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends BasePage {
	
	@FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[text()='Price -- Low to High']")
    private WebElement sortByPriceLowToHigh;

    public FilterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void searchForProduct(String product) {
        searchBox.sendKeys(product);
        searchButton.click();
    }

    public void sortByPriceLowToHigh() {
        sortByPriceLowToHigh.click();
    }
}
