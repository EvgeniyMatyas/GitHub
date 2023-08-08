package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public static final By HOME_TITTLE = By.xpath("//h4[text()='Start a new repository']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(HOME_TITTLE);
    }
}
