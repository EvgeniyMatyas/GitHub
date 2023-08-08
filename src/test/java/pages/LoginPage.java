package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2



public class LoginPage extends BasePage{

    public static final By USER_NAME = By.id("login_field");
    public static final By PASSWORD = By.id("password");
    public static final By SING_IN_BUTTON = By.xpath("//input[contains(@class, 'js-sign-in-button')]");
    public static final By ERROR_MESSAGE = By.xpath("//div[normalize-space(text()) = 'Incorrect username or password.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
@Step("Открыть сайт")
    public LoginPage open(){
        driver.get(BASE_URL+"login");
        log.info("Открыть сайт с помощью URL: " + BASE_URL+"login");
        return this;

    }
@Step("Вводим логин: '{name}' и пароль: '{password}'")
    public LoginPage loginAndPassword(String name,String password) {
        driver.findElement(USER_NAME).sendKeys(name);
        log.info("ВВести в поле ЮЗЕРНЕЙМ: " + name);
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("ВВести в поле ЮЗЕРНЕЙМ: " + password);
        return this;
    }
    @Step("Кликаем по кнопке LoginButton")
    public HomePage clickLogInButton(){
        driver.findElement(SING_IN_BUTTON).click();
        log.info("Кликаем на кнопку SING_IN_BUTTON с помощью XPath : " + SING_IN_BUTTON);
        return new HomePage(driver);
    }
    @Step("получить сообщение об ошибке")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    @Override
    public boolean isPageOpen() {
        return isExist(SING_IN_BUTTON);
    }

}
