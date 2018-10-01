package lesson09.c_creds_manager;

import org.junit.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class FirstTest extends BaseTest {


    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void verifyLogin(){
        loginPage.visit();
        assertThat(titleContains("Login"));
        loginPage.login();
        assertThat(titleContains("My account"));
    }
}