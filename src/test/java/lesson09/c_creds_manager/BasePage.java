package lesson09.c_creds_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends SimpleAPI {

    protected WebDriver wd;

    protected BasePage(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @Override
    WebDriver getWebDriver() {
        return wd;
    }
}
