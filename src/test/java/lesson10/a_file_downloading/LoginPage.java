package lesson10.a_file_downloading;
/**
 * Created by Vladimir Trandafilov on 01.10.2018.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CredsManager;

public class LoginPage extends BasePage {
    //Logger
    private static final Logger LOG = LogManager.getLogger(LoginPage.class);

    protected LoginPage(WebDriver wd) {
        super(wd);
    }

    public void login(){
        setValue(By.id("email"), CredsManager.getCred("username"));
        setValue(By.id("passwd"), CredsManager.getCred("passwd"));
        clickOn(By.id("SubmitLogin"));
    }

    public void visit(){
        navigateTo("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
}
