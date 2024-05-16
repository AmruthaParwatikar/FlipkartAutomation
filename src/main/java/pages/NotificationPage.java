package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationPage extends BasePage {

    @FindBy(xpath = "//img[@class='-dOa_b']")
    private WebElement threeDotsIcon;

    @FindBy(xpath = "//img[@class='SFnind' and @alt='Notification Preferences']")
    private WebElement notificationPreferencesOption;

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    public void clickThreeDotsIcon() {
        threeDotsIcon.click();
    }

    public void selectNotificationPreferencesOption() {
        notificationPreferencesOption.click();
    }
   
}
