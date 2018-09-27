package lesson08.b_refactor_explicitly_waits;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

class LandingPage implements LandingPageLocators {

    private WebDriver wd;

    public LandingPage(WebDriver wd) {
        this.wd = wd;
    }

    void searchFor(String query){
        $(searchField).click();
        $(searchField).clear();
        $(searchField).sendKeys(query);
    }

    void visit(){
        wd.get("http://automationpractice.com/index.php");
    }

    WebElement $(By locator){
        return waitFor(visibilityOfElementLocated(locator));
    }

    WebElement $(String xpath){
        return $(By.xpath(xpath));
    }

    List<WebElement> $$(By locator){
        return waitFor(visibilityOfAllElementsLocatedBy(locator));
    }

    private <V> V waitFor(Function<? super WebDriver, V> condition){
        return waitFor(condition, 10);
    }

    private <V> V waitFor(Function<? super WebDriver, V> condition, long timeout){
        return (new WebDriverWait(wd,timeout)).until(condition);
    }
}
