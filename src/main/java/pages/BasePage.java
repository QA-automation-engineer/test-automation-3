package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.SimpleAPI;

public abstract class BasePage extends SimpleAPI {

    protected WebDriver wd;

    protected BasePage(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    @Override
    protected WebDriver getWebDriver() {
        return wd;
    }
}
