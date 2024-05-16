package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SizePage extends BasePage {
	
	@FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class='aJWdJI dpZEpc' and @id='swatch-3-size']")
    private WebElement size32Button;

    public SizePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void searchForProduct(String product) {
        searchBox.sendKeys(product);
        searchButton.click();
    }

    public void selectSize32() {
        size32Button.click();
    }
}
