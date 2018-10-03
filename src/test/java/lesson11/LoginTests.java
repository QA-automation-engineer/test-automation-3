package lesson11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

import static org.hamcrest.core.StringContains.containsString;

public class LoginTests extends BaseGUITest {

    private LoginPage loginPage;

    @Before
    public void openLoginPage(){
        loginPage = new LoginPage(webDriver);
        loginPage.visit();
    }

    @Test
    public void Verify_That_Login_Page_Can_Be_Opened(){
        // assert
        Assert.assertThat(
                loginPage.getPageTitle(),
                containsString("Login"));
    }

    @Test
    public void Verify_That_User_Can_Login_Into_Private_Cabinet(){
        // act
        loginPage.login();
        // assert
        Assert.assertThat(
                loginPage.getPageTitle(),
                containsString("My account"));
    }
}