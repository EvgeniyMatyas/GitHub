package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.HomePage;
import pages.LoginPage;
import tests.base.TestListener;

import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;



@Step("Настройка и открытие браузера")
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);



    }
    @Step("Закрытие браузера")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}


//ecueg-hcd5@force.com
//77721185948934James
//
//на рабоч.компе
//loginAndPassword("dsygek-fvey@force.com","123456789James")
//oxodpub-cnkg@force.com     123456789J