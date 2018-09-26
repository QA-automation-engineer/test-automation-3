package lesson08.c_add_simple_api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends SimpleAPI{

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
