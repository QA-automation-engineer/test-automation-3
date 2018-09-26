package lesson08.d_custom_expected_condition;

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

    abstract WebDriver getWebDriver();

    void navigateTo(String url){
        getWebDriver().get(url);
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
        return (new WebDriverWait(getWebDriver(),timeout)).until(condition);
    }

    void assertThat(ExpectedCondition<Boolean> condition){
        assertThat(condition, 10);
    }

    void assertThat(ExpectedCondition<Boolean> condition, long timeout){
        (new WebDriverWait(getWebDriver(), timeout))
                .until(condition);
    }
}
