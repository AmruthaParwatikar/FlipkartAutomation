package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage{

    @FindBy(xpath = "//div[@class='_3wU53n']")
    private List<WebElement> productNames;

    public ListPage(WebDriver driver) {
        super(driver);
        
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement productName : productNames) {
            names.add(productName.getText());
        }
        return names;
    }
}
