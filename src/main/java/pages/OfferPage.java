package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OfferPage extends BasePage {

    @FindBy(xpath = "//img[@alt='Appliances']")
    private WebElement appliancesLink;

    @FindBy(linkText = "Offer Zone")
    private WebElement offerZoneLink;

    public OfferPage(WebDriver driver) {
        super(driver);
    }

    public void clickAppliancesLink() {
        appliancesLink.click();
    }

    public void clickOfferZoneLink() {
        offerZoneLink.click();
    }
}
