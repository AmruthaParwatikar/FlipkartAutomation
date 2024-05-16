package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TopDealPage extends BasePage {
    

    @FindBy(xpath = "//div[contains(text(), 'Top Deals')]")
    private WebElement topDealsLink;
    
   
    public TopDealPage(WebDriver driver) {
        super(driver);
        
    }

    public void clickTopDealsLink() {
        topDealsLink.click();
    }
   
}
