package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(css = "input[class='r4vIwl BV+Dqf']")
    private WebElement emailOrPhoneInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterEmailOrPhone(String emailOrPhone) {
        emailOrPhoneInput.sendKeys(emailOrPhone);
    }
}
