package lesson08.f_smart_element_finders_and_po_refactor;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class SimpleAPI {

    public static final int DEFAULT_TIMEOUT = 30;

    abstract WebDriver getWebDriver();

    void navigateTo(String url){
        getWebDriver().get(url);
    }

    protected WebElement $(By locator){
        return waitFor(visibilityOfElementLocated(locator));
    }

    protected WebElement $(String xpath){
        return $(By.xpath(xpath));
    }

    protected WebElement $(Function<? super WebDriver, WebElement> condition){
        return waitFor(condition);
    }

    protected List<WebElement> $$(By locator){
        return waitFor(visibilityOfAllElementsLocatedBy(locator));
    }

    protected List<WebElement> $$(String xpath){
        return waitFor(visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    protected List<WebElement> $$(Function<? super WebDriver, List<WebElement>> condition){
        return waitFor(condition);
    }

    protected <V> V waitFor(Function<? super WebDriver, V> condition){
        return waitFor(condition, DEFAULT_TIMEOUT);
    }

    protected  <V> V waitFor(Function<? super WebDriver, V> condition, long timeout){
        return (new WebDriverWait(getWebDriver(),timeout)).until(condition);
    }

    protected void assertThat(ExpectedCondition<Boolean> condition){
        assertThat(condition, DEFAULT_TIMEOUT);
    }

    protected void assertThat(ExpectedCondition<Boolean> condition, long timeout){
        (new WebDriverWait(getWebDriver(), timeout))
                .until(condition);
    }
}
