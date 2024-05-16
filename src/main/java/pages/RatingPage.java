package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RatingPage extends BasePage {

    @FindBy(xpath = "//span[@class='Wphh3N']")
    private WebElement ratings;
    
    @FindBy(xpath = "//div[@class='f+WmCe']")
    private WebElement availableOffers;

    public RatingPage(WebDriver driver) {
        super(driver);
    }

    public String getRatings() {
        return ratings.getText();
    }
    
    public String getAvailableOffers() {
        return availableOffers.getText();
    }
}
