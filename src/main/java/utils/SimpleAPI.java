package utils;

import com.google.common.base.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class SimpleAPI {

    private static final Logger LOG = LogManager.getLogger(SimpleAPI.class);

    private static final int DEFAULT_TIMEOUT = 30;

    protected abstract WebDriver getWebDriver();

    protected void navigateTo(String url){
        getWebDriver().get(url);
        waitForDocumentCompleteState();
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

    protected void setValue(WebElement element, String value){
        clickOn(element);
        element.clear();
        element.sendKeys(value);
    }

    protected void setValue(By locator, String value){
        clickOn(locator);
        $(locator).clear();
        $(locator).sendKeys(value);
    }

    protected void clickOn(WebElement element) {
        $(elementToBeClickable(element)).click();
    }

    protected void clickOn(By locator) {
        $(elementToBeClickable(locator)).click();
    }

    protected void waitForDocumentCompleteState() {
        try {
            new WebDriverWait(getWebDriver(), 30).until((WebDriver driver) -> {
                String documentState = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
                LOG.debug(String.format("Current document state is: %s", documentState));
                return "complete".equals(documentState);
            });
        } catch (TimeoutException e) {
            LOG.warn("Can't wait till document.readyState is complete");
        }
    }

    public String getPageTitle(){
        return getWebDriver().getTitle();
    }
}
