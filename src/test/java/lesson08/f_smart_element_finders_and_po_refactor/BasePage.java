package lesson08.f_smart_element_finders_and_po_refactor;

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
