package lesson08.c_add_simple_api;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

class LandingPage extends BasePage implements LandingPageLocators {

    public LandingPage(WebDriver wd) {
        super(wd);
    }

    void searchFor(String query){
        $(searchField).click();
        $(searchField).clear();
        $(searchField).sendKeys(query);
    }

    void visit(){
        navigateTo("http://automationpractice.com/index.php");
    }

}