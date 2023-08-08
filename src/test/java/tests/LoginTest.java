package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

@Test(description = "Проверка логина с валидными данными")
public void loginUserIsValidData(){
    boolean isHomePageOpen = loginPage.open()
            .loginAndPassword("evgeniymatyas@mail.ru","77721185948934James")
            .clickLogInButton()
            .isPageOpen();
    assertTrue(isHomePageOpen);
}

@DataProvider(name = "incorrectLoginTest" )
public Object[][] incorrectLoginTest(){
    return  new Object[][]{
            {"", "", "Incorrect username or password."},
            {"sdfdsfjhjhg", "", "Incorrect username or password."},
            {"", "34534gfv546", "Incorrect username or password."},
            {"hgfjghkjghkgh", "45654gjghj", "Incorrect username or password."},
    };

    }

@Test(dataProvider = "incorrectLoginTest")
public void loginTestWithWrongData(String login,String pass,String errorMessage){
    loginPage.open()
            .loginAndPassword(login,pass)
            .clickLogInButton();
    assertEquals(loginPage.getErrorMessage(), errorMessage,
            "Текст сообщения неверный или отсутствует");

}

}
